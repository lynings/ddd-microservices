package pers.lyning.medical.gateway.sso;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import pers.lyning.medical.gateway.client.patient.Patient;
import pers.lyning.medical.gateway.client.patient.PatientClient;
import pers.lyning.medical.gateway.client.patient.Permission;
import pers.lyning.medical.gateway.oss.ApplyTokenCommand;
import pers.lyning.medical.gateway.oss.JwtProvider;
import pers.lyning.medical.gateway.oss.Payload;
import pers.lyning.medical.gateway.oss.Token;
import pers.lyning.medical.gateway.testing.BaseIntegrationTest;

import java.util.ArrayList;

/**
 * @author lyning
 */
@WebFluxTest
class TokenApiDoc extends BaseIntegrationTest {

    private static final String URI = "/tokens";

    @MockBean
    private PatientClient patientClientMock;
    @SpyBean
    private JwtProvider jwtProvider;

    @Test
    void apply() throws Exception {
        // given
        final String username = "admin";
        final String password = "admin";

        final ArrayList<Permission> permissions = Lists.newArrayList(new Permission("/patients", "link.get.user", "get"));
        final Patient patient = new Patient(username, username, permissions);
        BDDMockito.doReturn(patient).when(this.patientClientMock).obtainByUsername(username);
        // when
        final WebTestClient.ResponseSpec responseSpec = this.client.post()
                .uri(URI)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(new ApplyTokenCommand(username, password)))
                .exchange();
        // then
        responseSpec.expectStatus().is2xxSuccessful()
                .expectBody(Token.class)
                .value((token -> token.getToken().startsWith("Bearer eyJhbGciOiJIUzUxMiJ9")))
                .consumeWith(this.commonDocumentation());
    }

    @Test
    void renew() throws Exception {
        // given
        final Token token = this.generateUnexpiredToken();
        // when
        final WebTestClient.ResponseSpec responseSpec = this.client
                .post()
                .uri(URI + "/renews")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(token))
                .exchange();

        // then
        responseSpec.expectBody(Token.class)
                .value((jwt -> jwt.getToken().startsWith("Bearer eyJhbGciOiJIUzUxMiJ9")))
                .consumeWith(this.commonDocumentation());
    }


    private Token generateUnexpiredToken() {
        Payload payload = preparePayload();
        return this.jwtProvider.generate(payload);
    }

    private Payload preparePayload() {
        final ArrayList<Permission> permissions = Lists.newArrayList(new Permission("/patients", "link.get.user", "get"));
        final Patient patient = new Patient("admin", "admin", permissions);
        return new Payload(patient);
    }

}
