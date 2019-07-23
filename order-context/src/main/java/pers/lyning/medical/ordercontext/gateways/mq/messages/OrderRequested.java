package pers.lyning.medical.ordercontext.gateways.mq.messages;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author lyning
 */
@Setter
@Getter
public class OrderRequested implements Serializable {

    private static final long serialVersionUID = 3439365422321723997L;

    /**
     * 患者id
     */
    private Long patientId;

    /**
     * 项目
     * <p>
     * 谁：姓名
     * <p>
     * 购买了什么医疗项目
     * <p>
     * 是否选择了套餐
     */
    private Project project;
}
