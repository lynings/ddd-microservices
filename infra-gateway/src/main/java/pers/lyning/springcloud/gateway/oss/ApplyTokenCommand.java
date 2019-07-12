package pers.lyning.springcloud.gateway.oss;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lyning
 */
@Setter
@Getter
public class ApplyTokenCommand {

    private String username;

    private String password;
}
