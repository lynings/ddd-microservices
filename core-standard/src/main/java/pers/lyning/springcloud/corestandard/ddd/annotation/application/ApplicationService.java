package pers.lyning.springcloud.corestandard.ddd.annotation.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 应用服务
 * 可以理解 business use case，例如下单就是一个用例，那么 placeOrder 就是一个应用服务接口， OrderAppService 就是一个应用服务
 * <code>
 *     \@ApplicationService
 *     public class OrderAppService {
 *         public OrderVO placeOrder(PlaceOrderCommand command) {
 *             // TODO do something
 *         }
 *     }
 * </code>
 *
 * 约束：
 * 必须使用业务语言描述 应用服务接口，不要使用任何跟技术相关的用语，例如：递归、循环 等等
 *
 * 主要的作用：
 * 1. 提供业务含义的接口（粒度 相对于 业务逻辑接口 要粗）
 * 2. 协调多个业务逻辑
 * @author lyning
 */
@Service
@Transactional
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationService {
}
