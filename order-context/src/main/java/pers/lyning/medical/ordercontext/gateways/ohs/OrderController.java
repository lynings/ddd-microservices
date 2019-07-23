package pers.lyning.medical.ordercontext.gateways.ohs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.lyning.medical.corestandard.ddd.support.domain.AggregateId;
import pers.lyning.medical.ordercontext.domain.Order;
import pers.lyning.medical.ordercontext.gateways.ohs.data.PlaceOrderCommand;
import pers.lyning.medical.ordercontext.interfaces.OrderAppService;

/**
 * @author lyning
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderAppService orderAppService;

    @Autowired
    public OrderController(final OrderAppService orderAppService) {
        this.orderAppService = orderAppService;
    }

    /**
     * 创建订单
     *
     * @param orderCommand
     * @return
     */
    @PostMapping
    public Long create(@RequestBody final PlaceOrderCommand orderCommand) {
        return this.orderAppService.placeOrder(orderCommand);
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable final Long id) {
        return Order.builder()
                .aggregateId(new AggregateId(id))
                .build();
    }
}
