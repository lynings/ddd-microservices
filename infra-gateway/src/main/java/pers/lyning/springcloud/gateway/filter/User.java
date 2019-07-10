package pers.lyning.springcloud.gateway.filter;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author lyning
 */
@Setter
@Getter
public class User {

    private Long id;

    private String username;


    public Map<String, Object> asMap() {
        return null;
    }
}