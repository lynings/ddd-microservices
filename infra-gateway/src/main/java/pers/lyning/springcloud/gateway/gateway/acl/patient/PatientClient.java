package pers.lyning.springcloud.gateway.gateway.acl.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lyning
 */
@FeignClient(name = "patient-service")
public interface UserClient {

    /**
     * 根据 username 获取用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    @GetMapping("/users")
    User findByUsername(@RequestParam("username") String username);
}
