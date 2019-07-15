package pers.lyning.medical.patientcontext.domain.patient;

import org.springframework.data.repository.CrudRepository;
import pers.lyning.medical.corestandard.ddd.annotation.domain.DomainRepository;
import pers.lyning.medical.corestandard.ddd.support.domain.AggregateId;

/**
 * @author lyning
 */
@DomainRepository
public interface PatientRepository extends CrudRepository<Patient, AggregateId> {
}
