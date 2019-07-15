package pers.lyning.medical.patientcontext.application.patient;

import pers.lyning.medical.corestandard.ddd.annotation.application.ApplicationService;
import pers.lyning.medical.corestandard.ddd.support.domain.AggregateId;
import pers.lyning.medical.patientcontext.domain.patient.Patient;

/**
 * @author lyning
 */
@ApplicationService
public class PatientAppService {

    /**
     * 获取 患者信息
     *
     * @param id patient id
     * @return 患者信息
     */
    public Patient obtainPatientInfo(final Long id) {
        return new Patient(new AggregateId(id), id.toString());
    }

    /**
     * 获取 患者信息
     *
     * @param query query params
     * @return 患者信息
     */
    public Patient obtainPatientInfo(final FindOnePatientQuery query) {
        return new Patient(new AggregateId(1L), query.getUsername());
    }
}
