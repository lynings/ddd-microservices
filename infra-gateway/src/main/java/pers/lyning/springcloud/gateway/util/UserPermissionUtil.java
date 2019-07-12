package pers.lyning.springcloud.gateway.util;


import org.springframework.http.server.reactive.ServerHttpRequest;
import pers.lyning.springcloud.gateway.gateway.acl.user.User;

/**
 * @author lyning
 */
public class UserPermissionUtil {

    /**
     * 赋权
     *
     * @param user
     */
    public static void permission(User user) {
        // TODO 赋权
    }

    /**
     * 权限验证
     *
     * @param user
     * @param request
     * @return
     */
    public static boolean verify(User user, ServerHttpRequest request) {
        // TODO 验证用户是否有权限
        return false;
    }
}
