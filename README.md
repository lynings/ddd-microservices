## 描述
DDD 实践

## Modules
- [ ] 注册中心 —— eureka
    - [x] spring cloud 集成
    - [ ] 性能调优
- [ ] 统一网关 —— gateway
    - [x] 路由分发
    - [x] 统一拦截，身份认证、鉴权
        - [x] 集成 jwt
        - [x] 解析 jwt
        - [x] 申请 jwt
            - [x] 获取患者信息
    - [ ] 性能调优
- [ ] 统一配置中心 —— config
    - [x] 热刷新 —— github
        - [x] 集成 spring cloud bus amqp
        - [x] 集成 spring cloud config monitor
        - [x] 集成 rabbitmq
        - [x] 触发热更新：/monitor?path=application -header: X-Github-Event=Push Event
        - [x] 排查没有推送刷新通知原因 
    - [ ] 性能调优
- [ ] 全链路监控
    - [ ] skywalking
        - [x] H2 存储
        - [ ] ElasticSearch 存储    
        - [ ] 性能调优
- [ ] 通知
    - [ ] 集成 rabbitmq
    - [ ] 支持 消息推动
    - [ ] 支持 接收消息 并转换成 pojo
    - [ ] 支持 消息延迟
- [ ] 通用工具
    - [ ] 支持阿里云 文件上传下载
    - [ ] 集成 excel 导入导出
    - [ ] 集成 excel 转换 pdf
    - [x] spring data jpa
    - [x] flyway （数据库版本控制）
    - [ ] spring rest doc (自动生成 api 文档)
        - [x] demo
        - [ ] 线上统一访问
- [ ] 代码模型
    - [ ] 模块边界
    - [ ] 分包原则
    - [ ] 各层职责
- [ ] 单元测试环境
    - [x] assertJ 集成
    - [x] jacoco
    - [x] junit 5
    - [ ] demo
- [ ] 集成测试环境
    - [x] h2
    - [ ] spring boot test
    - [ ] demo
    - [ ] contract test
- [ ] CI 
- [ ] CD
- [ ] Docker