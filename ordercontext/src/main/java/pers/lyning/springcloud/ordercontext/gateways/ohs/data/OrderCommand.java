package pers.lyning.springcloud.ordercontext.gateways.ohs.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author lyning
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCommand {

    /**
     * 用户 id
     */
    private Long userId;
}
