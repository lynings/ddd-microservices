package pers.lyning.medical.ordercontext.gateways.ohs.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author lyning
 */
@Getter
@Setter
@NoArgsConstructor
public class PlaceOrderCommand {

    /**
     * 患者id
     */
    private Long patientId;
}
