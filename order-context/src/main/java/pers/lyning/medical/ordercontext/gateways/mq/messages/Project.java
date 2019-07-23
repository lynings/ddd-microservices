package pers.lyning.medical.ordercontext.gateways.mq.messages;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lyning
 */
@Setter
@Getter
public class Project {

    /**
     * 医疗项目 id
     */
    private Long id;

    /**
     * 套餐 id
     */
    private Long packageId;
}
