package pers.lyning.medical.patientcontext.gateways.ohs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.lyning.medical.patientcontext.application.patient.FindOnePatientQuery;
import pers.lyning.medical.patientcontext.application.patient.PatientAppService;
import pers.lyning.medical.patientcontext.domain.patient.Patient;
import reactor.core.publisher.Mono;

/**
 * @author lyning
 */
@Slf4j
@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientAppService patientAppService;

    @Autowired
    public PatientController(final PatientAppService patientAppService) {
        this.patientAppService = patientAppService;
    }

    /**
     * 通过 username 获取患者
     *
     * @param id 用户名
     * @return patient info
     */
    @GetMapping("/{id}")
    public Mono<Patient> findById(@PathVariable("id") final Long id) {
        final Patient patient = this.patientAppService.obtainPatientInfo(id);
        return Mono.justOrEmpty(patient);
    }

    /**
     * 通过 username 获取患者
     *
     * @param query 查询参数
     * @return patient info
     */
    @GetMapping
    public Mono<Patient> findOneByParams(final FindOnePatientQuery query) {
        final Patient patient = this.patientAppService.obtainPatientInfo(query);
        return Mono.justOrEmpty(patient);
    }
}
