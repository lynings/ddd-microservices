package pers.lyning.springcloud.gateway.gateway.acl.user;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lyning
 */
@Setter
@Getter
public class Permission {

    private String url;

    private String resource;

    private String method;
}
