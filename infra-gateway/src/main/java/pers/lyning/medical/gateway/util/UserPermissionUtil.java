package pers.lyning.medical.gateway.util;


import org.springframework.http.server.reactive.ServerHttpRequest;
import pers.lyning.medical.gateway.gateway.acl.patient.Patient;

/**
 * @author lyning
 */
public class UserPermissionUtil {

    /**
     * 赋权
     *
     * @param patient
     */
    public static void permission(final Patient patient) {
        // TODO 赋权
    }

    /**
     * 权限验证
     *
     * @param patient
     * @param request
     * @return
     */
    public static boolean verify(final Patient patient, final ServerHttpRequest request) {
        // TODO 验证患者是否有权限
        return false;
    }
}
