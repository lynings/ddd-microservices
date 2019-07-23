## 订单上下文

## 职责
- [ ] 下单（根据参与者不同，有可能采用订阅 或者 调用 rest api）
    - [ ] 检验 订单信息
    - [ ] 发布 库存请求 InventoryRequested（验证库存是否足够）
    - [ ] 订阅 库存验证通过事件 AvailabilityValidated
    - [ ] 验证 AvailabilityValidated
    - [ ] 发布 OrderValidated 事件，从而发起支付流程
    - [ ] 订阅 PaymentProcessed 事件，确认支付完成进而发布 OrderConfirmed 事件（可能被多个上下文订阅）
- [ ] 取消订单
- [ ] 查看订单信息
    - [ ] 查看个人订单信息
        - [ ] 按患者 标识 和 时间查询
        - [ ] 默认降序