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
- [x] 单元测试环境
    - [x] assertJ 集成
    - [x] jacoco
    - [x] junit 5
    - [x] demo
- [ ] 集成测试环境
    - [x] h2
    - [x] spring boot test
    - [x] demo
    - [ ] contract test
- [ ] CI 
- [ ] CD
- [ ] Docker
    - [x] gradle docker plugin
    - [x] 服务 docker 化
    - [x] 一键构建
    - [ ] 配置中心 ip 获取问题
- [ ] k8s

## 环境
- 在容器中启动 mysql
```bash
docker run --rm -d -e MYSQL_ROOT_PASSWORD=123456 \
      -v mysql-8.0.5-volume:/var/lib/mysql \
      -p 23333:3306 mysql:8.0.15
```
```bash
# 查看 docker 中的 mysql 容器的 IP
sudo docker inspect  mysql-container-id | grep IPAddress
```

### 软件安装指南

#### k8s
这里选择 minikube 来搭建本地单机版的 k8s 集群。

- [安装 VisualBox](https://www.virtualbox.org/wiki/Downloads)
- [安装 kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl/)
- [安装 Minikube](https://kubernetes.io/docs/tasks/tools/install-minikube/)

- VisualBox 直接下载安装就可以
- kubectl 和 minikube 最好设置代理下载（代理设置参考：export HTTPS_PROXY="http://127.0.0.1:1087"）
- kubectl 在安装之前，确保 8080 端口没有被占用，不然会报错（`error: unable to parse the server version: invalid character '<' looking for beginning of value`）
- minikube start 用于启动本地的 k8s 集群，启动过程中需要下载依赖，下载之前最好设置代理
- minikube start 运行完成之后，执行 minikube dashboard 就可以查看在浏览器查看 k8s 的控制台
- 运行 minikube dashboard 之前如果没有 minikube start，会报错（`Unable to enable dashboard: [command runner: getting ssh client for bootstrapper: Error dialing tcp via ssh client: dial tcp 127.0.0.1:22: connect: connection refused]` 或者 `kube-system:kubernetes-dashboard is not running: Error getting kubernetes client: getting clientset: kubeConfig: auth info "minikube" does not exist`）

### 运行
build 镜像
```bash
gradle docker
``` 
---
push 镜像 到仓库
```bash
gradle dockerTagsPush
``` 
---