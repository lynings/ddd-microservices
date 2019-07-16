package pers.lyning.medical.gateway.oss;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.ExpiredJwtException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Base64Utils;
import pers.lyning.medical.gateway.oss.helper.PayloadFactory;
import pers.lyning.medical.gateway.oss.helper.TokenGenerator;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JwtProviderTest {
    private static final long EXPIRATION = 604800L;
    private static final String SECRET = "xfk!@#$%^&*()xfk!@#$%^&*()xfk!@#$%^&*()";
    private static final long RENEW_EXPIRATION = 2592000L;

    private JwtProvider jwtProvider;

    @BeforeEach
    void setUp() {
        /**
         *  # 密钥
         *   secret: xfk!@#$%^&*()xfk!@#$%^&*()xfk!@#$%^&*()
         *   # 七天
         *   expiration: 604800
         *   # 续约30天
         *   renew-expiration: 2592000
         */
        this.jwtProvider = new JwtProvider();
        this.jwtProvider.setSecret(SECRET);
        this.jwtProvider.setExpiration(EXPIRATION);
        this.jwtProvider.setRenewExpiration(RENEW_EXPIRATION);
    }

    /*********** generate test start ***********/
    @Test
    void should_generated_jwt_when_correct_input_payload() throws Exception {
        // given
        final Payload givenPayload = PayloadFactory.create();
        // when
        final Token token = this.jwtProvider.generate(givenPayload);
        // then
        assertThat(token.getToken()).isNotNull();
    }

    @Test
    void should_generated_jwt_when_input_null() throws Exception {
        // given
        final Payload givenPayload = new Payload();
        // when
        final Token token = this.jwtProvider.generate(givenPayload);
        // then
        assertThat(token.getToken()).isNotNull();
    }
    /*********** generate test end ***********/


    /*********** renew test start ***********/
    @Test
    void should_renew_when_token_unexpired() throws Exception {
        // given
        final Token token = TokenGenerator.generateUnexpiredToken();
        final Long currentTimeMillis = System.currentTimeMillis();
        // when
        final Token renewToken = this.jwtProvider.renew(token);
        // then
        assertThat(token).isNotEqualTo(renewToken);
        final Long exp = this.obtainExpFrom(renewToken);
        final long numberOfDay = (exp - currentTimeMillis / 1000) / 3600 / 24;
        assertThat(numberOfDay).isEqualTo(RENEW_EXPIRATION / 3600 / 24);
    }

    @Test
    void should_renew_fail_when_token_expired() throws Exception {
        // given
        final Token expiredToken = TokenGenerator.generateExpiredToken();
        // when
        assertThrows(ExpiredJwtException.class, () -> {
            this.jwtProvider.renew(expiredToken);
        });
    }

    private Long obtainExpFrom(final Token renewToken) {
        final String payload = renewToken.getToken().split("\\.")[1];
        final Map<String, Object> map = JSON.parseObject(Base64Utils.decodeFromString(payload), HashMap.class);
        return Long.valueOf(map.get("exp").toString());
    }

    /*********** renew test end ***********/


    /*********** validate test start ***********/
    @Test
    void should_validate_passed_when_token_valid() throws Exception {
        // given
        final Token token = TokenGenerator.generateUnexpiredToken();
        // when
        final boolean passed = this.jwtProvider.validate(token);
        // then
        assertThat(passed).isTrue();
    }

    @Test
    void should_validate_not_pass_when_token_invalid() throws Exception {
        // given
        final Token token = TokenGenerator.generateExpiredToken();
        // when
        final boolean passed = this.jwtProvider.validate(token);
        // then
        assertThat(passed).isFalse();
    }
    /*********** validate test end ***********/

    /*********** parse test start ***********/
    @Test
    void should_return_payload_when_parse_unexpired_token() throws Exception {
        // given
        final Token token = TokenGenerator.generateUnexpiredToken();
        // when
        final Payload payload = this.jwtProvider.parse(token);
        // then
        assertThat(payload).usingDefaultComparator()
                .isEqualToComparingFieldByFieldRecursively(PayloadFactory.create());
    }

    @Test
    void should_parse_fail_when_token_expired() throws Exception {
        // given
        final Token token = TokenGenerator.generateExpiredToken();
        // when
        assertThrows(ExpiredJwtException.class, () -> this.jwtProvider.parse(token));
    }
    /*********** parse test end ***********/
}