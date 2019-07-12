package pers.lyning.springcloud.gateway.gateway.acl.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author lyning
 */
@Getter
@AllArgsConstructor
public class User {

    private final String username;

    private final String name;

    private final List<Permission> permissions;
}