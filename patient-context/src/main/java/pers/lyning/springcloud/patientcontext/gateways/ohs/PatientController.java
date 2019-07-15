package pers.lyning.springcloud.patientcontext.gateways.ohs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.lyning.springcloud.patientcontext.application.user.FindOneUserQuery;
import pers.lyning.springcloud.patientcontext.application.user.UserAppService;
import pers.lyning.springcloud.patientcontext.domain.user.User;
import reactor.core.publisher.Mono;

/**
 * @author lyning
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserAppService userAppService;

    @Autowired
    public UserController(final UserAppService userAppService) {
        this.userAppService = userAppService;
    }

    /**
     * 通过 username 获取用户
     *
     * @param id 用户名
     * @return patient info
     */
    @GetMapping("/{id}")
    public Mono<User> findById(@PathVariable("id") final Long id) {
        final User user = this.userAppService.obtainUserInfo(id);
        return Mono.justOrEmpty(user);
    }

    /**
     * 通过 username 获取用户
     *
     * @param query 查询参数
     * @return patient info
     */
    @GetMapping
    public Mono<User> findOneByParams(final FindOneUserQuery query) {
        final User user = this.userAppService.obtainUserInfo(query);
        return Mono.justOrEmpty(user);
    }
}
