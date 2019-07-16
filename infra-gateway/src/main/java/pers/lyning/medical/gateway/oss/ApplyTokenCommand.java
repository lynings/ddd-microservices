package pers.lyning.medical.gateway.oss;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author lyning
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApplyTokenCommand {

    /**
     * 用户名
     */
    @NotNull
    private String username;

    /**
     * 密码
     */
    @NotNull
    private String password;
}
