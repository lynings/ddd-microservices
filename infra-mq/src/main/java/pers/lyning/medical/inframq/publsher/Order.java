package pers.lyning.medical.inframq.publsher;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author lyning
 */
@Setter
@Getter
@ToString
public class Order implements Serializable {
    private static final long serialVersionUID = -5936196826111778809L;

    private Long id;

    private List<OrderItem> orderItems;
}
