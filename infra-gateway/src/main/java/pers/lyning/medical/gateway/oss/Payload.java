package pers.lyning.medical.gateway.oss;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pers.lyning.medical.gateway.client.patient.Patient;
import pers.lyning.medical.gateway.client.patient.Permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lyning
 */
@Setter
@Getter
@NoArgsConstructor
public class Payload {

    private String name;
    private String username;
    private List<Permission> permissions;

    public Payload(final Patient patient) {
        this.name = patient.getName();
        this.username = patient.getUsername();
        this.permissions = patient.getPermissions();
    }

    public Map<String, Object> asMap() {
        final Map<String, Object> map = new HashMap<>();
        map.put("name", this.name);
        map.put("username", this.username);
        map.put("permissions", this.permissions);
        return map;
    }
}
