package pers.lyning.medical.gateway.oss;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Optional;

/**
 * @author lyning
 */
@Getter
@NoArgsConstructor
public class Token {

    private final static String TOKEN_PREFIX = "Bearer ";

    /**
     * jwt
     */
    @NotNull
    private String token;

    private Token(final String token) {
        this.token = token;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        return Objects.equals(this.token, ((Token) o).getToken());
    }

    /**
     * 填充前缀
     *
     * @param value
     * @return
     */
    public static Token fillPrefix(final String value) {
        return new Token(TOKEN_PREFIX + value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.token);
    }

    public static Token of(final String value) {
        return new Token(value);
    }

    /**
     * 提纯，去掉非 token 部分
     *
     * @return
     */
    String refining() {
        return Optional.of(this.token)
                .map(o -> o.replaceAll(TOKEN_PREFIX, ""))
                .get();
    }
}
