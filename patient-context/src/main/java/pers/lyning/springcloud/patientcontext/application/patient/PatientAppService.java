package pers.lyning.springcloud.patientcontext.application.user;

import pers.lyning.springcloud.corestandard.ddd.annotation.application.ApplicationService;
import pers.lyning.springcloud.patientcontext.domain.user.User;

/**
 * @author lyning
 */
@ApplicationService
public class UserAppService {

    /**
     * 获取 用户信息
     *
     * @param id patient id
     * @return 用户信息
     */
    public User obtainUserInfo(final Long id) {
        return new User(id, id.toString());
    }

    /**
     * 获取 用户信息
     *
     * @param query query params
     * @return 用户信息
     */
    public User obtainUserInfo(final FindOneUserQuery query) {
        return new User(1L, query.getUsername());
    }
}
