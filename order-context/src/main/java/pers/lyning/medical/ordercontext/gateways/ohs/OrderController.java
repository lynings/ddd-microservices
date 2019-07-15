package pers.lyning.medical.ordercontext.gateways.ohs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.lyning.medical.ordercontext.domain.Order;
import pers.lyning.medical.ordercontext.gateways.ohs.data.OrderCommand;
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

    @GetMapping("/{id}")
    public Order findById(@PathVariable final Long id) {
        return new Order(id);
    }

    /**
     * 创建订单
     *
     * @param orderCommand
     * @return
     */
    @PostMapping
    public Long create(@RequestBody final OrderCommand orderCommand) {
        return this.orderAppService.placeOrder(orderCommand);
    }
}
