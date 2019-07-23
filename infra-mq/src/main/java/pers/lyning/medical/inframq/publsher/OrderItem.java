package pers.lyning.medical.inframq.publsher;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lyning
 */
@Setter
@Getter
public class OrderItem implements Serializable {
    private static final long serialVersionUID = -2318045228288115219L;

    private Long id;

    private Long orderId;

    private Long produceId;

    private Date createDate;
}
