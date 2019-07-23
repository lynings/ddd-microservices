package pers.lyning.medical.inframq.publsher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author lyning
 */
@RestController
@EnableBinding(OrderResource.class)
@Slf4j
public class PublisherController {

    private final OrderResource orderResource;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public PublisherController(OrderResource orderResource, RabbitTemplate rabbitTemplate) {
        this.orderResource = orderResource;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/orders")
    public Mono<Order> postOrder(Order order) {
        this.orderResource.placeOrder().send(MessageBuilder.withPayload(order).build());
        this.rabbitTemplate.convertAndSend(OrderResource.PLACE_ORDER_OUTPUT, order);
        log.info(order.toString());
        return Mono.just(order);
    }


}
