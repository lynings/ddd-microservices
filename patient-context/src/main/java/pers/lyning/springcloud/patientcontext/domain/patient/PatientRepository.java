package pers.lyning.springcloud.patientcontext.domain.user;

import org.springframework.data.repository.CrudRepository;
import pers.lyning.springcloud.corestandard.ddd.annotation.domain.DomainRepository;
import pers.lyning.springcloud.corestandard.ddd.support.domain.AggregateId;

/**
 * @author lyning
 */
@DomainRepository
public interface UserRepository extends CrudRepository<User, AggregateId> {
}
