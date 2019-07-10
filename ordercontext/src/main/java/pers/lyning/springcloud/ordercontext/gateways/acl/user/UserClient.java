package pers.lyning.springcloud.ordercontext.gateways.acl.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lyning
 */
@FeignClient(name = "user-service")
public interface UserClient {

    /**
     * 根据 id 获取用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    @GetMapping("/users/{id}")
    User findUserById(@PathVariable("id") Long id);
}
