package pers.lyning.springcloud.patientcontext.domain.patient;

import org.springframework.data.repository.CrudRepository;
import pers.lyning.springcloud.corestandard.ddd.annotation.domain.DomainRepository;
import pers.lyning.springcloud.corestandard.ddd.support.domain.AggregateId;

/**
 * @author lyning
 */
@DomainRepository
public interface PatientRepository extends CrudRepository<Patient, AggregateId> {
}
