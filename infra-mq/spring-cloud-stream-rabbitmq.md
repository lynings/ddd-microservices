## Spring Cloud Stream Rabbitmq 学习笔记

### 知识点

#### exchange
用于接收 producer 发送的消息，并根据规则来选择应该如何处理消息。

#### Binding
代表了 exchange 和 queue 的一种关系，可以理解为：queue 对来自此 exchange 的消息感兴趣

#### routing key

#### Direct Exchange

### 死信队列
autoBindDlq 可以绑定和创建一个死信队列，dlq 指的是 dead-letter queues.

通过在 queue 名后缀增加 .dlq 即可标识为 死信队列

如果开启重试（`maxAttempts` > 1），重试次数耗尽的消息会被路由到信息队列

如果禁止了重试（`maxAttempts` = 1），需要设置 `requeueRejected = false` （默认），以便于失败的消息能够路由到 DLQ

注意：如果将 `requeueRejected` 设置为 true，那么会导致消息重新排队并不断的重试，因此当该选项设置为 `true` 时最好要设置 `maxAttempts` > 1


### RabbitMQ Binder Properties
默认使用 spring boot `ConnectionFactory`，因此支持 spring boot  `spring.rabbitmq` 配置。

支持 spring cloud 配置：`spring.cloud.stream.rabbit`

### RabbitMQ Consumer Properties
`spring.cloud.stream.rabbit.bindings.<changelName>.consumer.xxx`

### 增强 Listener Container Configuration 
`ListenerContainerCustomizer::configure`

### RabbitMQ Consumer Properties
`spring.cloud.stream.rabbit.bindings.<changelName>.producer.xxx`

### RabbitMQ 分区
允许 将特定的消息严格发送给特定的分区处理

优点 可以将并发无序的请求 变成紧凑有序的请求

缺点 消息消费者不支持动态扩展、 不太适合并发要求高的场景

原生 RabbitMQ 不支持分区

spring rabbitmq 提供了这个功能的封装


## 问题
- [ ] message-driven consumer(支持监听多个队列) diff polled consumer（只支持监听一个队列）


## Tasking
- [ ] 集成 spring-cloud-starter-stream-rabbit
- [ ] 增加
