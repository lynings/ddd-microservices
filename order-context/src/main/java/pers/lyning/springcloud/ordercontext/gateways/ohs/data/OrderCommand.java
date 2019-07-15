package pers.lyning.springcloud.ordercontext.gateways.ohs.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author lyning
 */
@Getter
@Setter
@NoArgsConstructor
public class OrderCommand {

    /**
     * 患者id
     */
    private Long patientId;
}