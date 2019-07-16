package pers.lyning.medical.gateway.client.patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author lyning
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Permission {

    private String url;

    private String resource;

    private String method;
}
