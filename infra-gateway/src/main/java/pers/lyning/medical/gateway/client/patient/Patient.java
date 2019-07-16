package pers.lyning.medical.gateway.client.patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lyning
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    private String name;

    private String username;

    private List<Permission> permissions;
}