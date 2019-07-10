package pers.lyning.springcloud.usercontext.gateways.ohs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.lyning.springcloud.usercontext.domain.User;

/**
 * @author lyning
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * 通过 id 获取用户
     *
     * @param id user id
     * @return user info
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable final Long id) {
        log.debug("user id {}", id);
        return new User(id);
    }
}
