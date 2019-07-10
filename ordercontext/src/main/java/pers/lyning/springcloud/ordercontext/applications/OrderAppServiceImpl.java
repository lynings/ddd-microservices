package pers.lyning.springcloud.ordercontext.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.lyning.springcloud.ordercontext.gateways.acl.user.User;
import pers.lyning.springcloud.ordercontext.gateways.acl.user.UserClient;
import pers.lyning.springcloud.ordercontext.gateways.ohs.data.OrderCommand;
import pers.lyning.springcloud.ordercontext.interfaces.OrderAppService;

/**
 * @author lyning
 */
@Service
public class OrderAppServiceImpl implements OrderAppService {

    private final UserClient userClient;

    @Autowired
    public OrderAppServiceImpl(final UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public Long placeOrder(final OrderCommand orderCommand) {
        final User user = this.userClient.findUserById(orderCommand.getUserId());
        System.out.println(user);
        return user.getId();
    }
}
