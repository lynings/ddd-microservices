package pers.lyning.medical.notificationcontext.application;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author lyning
 */
@Setter
@Getter
@ToString
public class OrderConfirmed implements Serializable {

    private static final long serialVersionUID = -3049750853806810013L;

    private Long orderId;
}
