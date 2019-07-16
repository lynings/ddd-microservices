package pers.lyning.medical.gateway.sso;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import pers.lyning.medical.gateway.client.patient.Patient;
import pers.lyning.medical.gateway.client.patient.PatientClient;
import pers.lyning.medical.gateway.client.patient.Permission;
import pers.lyning.medical.gateway.oss.ApplyTokenCommand;
import pers.lyning.medical.gateway.oss.Token;
import pers.lyning.medical.gateway.testing.BaseIntegrationTest;

import java.util.ArrayList;

/**
 * @author lyning
 */
@WebFluxTest
class TokenDoc extends BaseIntegrationTest {

    @MockBean
    private PatientClient patientClientMock;

    @Test
    void applyToken() throws Exception {
        // given
        final String username = "admin";
        final String password = "admin";

        final ArrayList<Permission> permissions = Lists.newArrayList(new Permission("/patients", "link.get.user", "get"));
        final Patient patient = new Patient(username, username, permissions);
        BDDMockito.doReturn(patient).when(this.patientClientMock).obtainByUsername(username);
        // when
        final WebTestClient.ResponseSpec responseSpec = this.client.post()
                .uri("/tokens")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(new ApplyTokenCommand(username, password)))
                .exchange();
        // then
        final Token expectedToken = Token.fillPrefix("eyJhbGciOiJIUzUxMiJ9.eyJwZXJtaXNzaW9ucyI6W3sidXJsIjoiL3BhdGllbnRzIiwicmVzb3VyY2UiOiJsaW5rLmdldC51c2VyIiwibWV0aG9kIjoiZ2V0In1dLCJuYW1lIjoiYWRtaW4iLCJ1c2VybmFtZSI6ImFkbWluIn0.TKrY-oYgXslajPDblH5AwuCZtw7SCnG4dwJzMoLeaNve-7pMugSUu7we4uAFvXRzqKM_oK_r297lwnjfaGJdjg");
        responseSpec.expectStatus().is2xxSuccessful()
                .expectBody(Token.class)
                .isEqualTo(expectedToken)
                .consumeWith(this.commonDocumentation());
    }

}
