package pers.lyning.springcloud.gateway.oss;

import lombok.NoArgsConstructor;
import lombok.Setter;
import pers.lyning.springcloud.gateway.gateway.acl.user.Permission;
import pers.lyning.springcloud.gateway.gateway.acl.user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lyning
 */
@Setter
@NoArgsConstructor
public class Payload {

    private String name;
    private String username;
    private List<Permission> permissions;

    public Payload(User user) {
        this.name = user.getName();
        this.username = user.getUsername();
        this.permissions = user.getPermissions();
    }

    public Map<String, Object> asMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", Payload.this.name);
        map.put("username", Payload.this.username);
        map.put("permissions", Payload.this.permissions);
        return map;
    }
}
