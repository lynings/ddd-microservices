package pers.lyning.springcloud.usercontext.application.user;

import org.springframework.stereotype.Service;
import pers.lyning.springcloud.usercontext.domain.user.User;

/**
 * @author lyning
 */
@Service
public class UserAppService {

    public User findUser(Long id) {
        return new User(id, id.toString());
    }

    public User findUser(FindOneUserQuery query) {
        return new User(1L, query.getUsername());
    }
}
