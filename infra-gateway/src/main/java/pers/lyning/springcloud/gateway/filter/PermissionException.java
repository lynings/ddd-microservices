package pers.lyning.springcloud.gateway.filter;

/**
 * @author lyning
 */
public class PermissionException extends RuntimeException {

    public PermissionException(String errorMsg) {
        super(errorMsg);
    }
}
