package pers.lyning.medical.gateway.gateway.acl.patient;

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
