package pers.lyning.medical.gateway.oss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.lyning.medical.gateway.client.patient.Patient;
import pers.lyning.medical.gateway.client.patient.PatientClient;

/**
 * @author lyning
 */
@Service
public class TokenService {

    private final JwtProvider jwtProvider;
    private final PatientClient patientClient;

    @Autowired
    public TokenService(final JwtProvider jwtProvider, final PatientClient patientClient) {
        this.jwtProvider = jwtProvider;
        this.patientClient = patientClient;
    }

    /**
     * 申请
     *
     * @param applyTokenCommand
     * @return
     */
    public Token apply(final ApplyTokenCommand applyTokenCommand) {
        final Patient patient = this.patientClient.obtainByUsername(applyTokenCommand.getUsername());
        final Payload payload = new Payload(patient);
        return this.jwtProvider.generate(payload);
    }

    /**
     * 续租
     *
     * @param token
     * @return
     */
    public Token renew(final Token token) {
        return this.jwtProvider.renew(token);
    }
}
