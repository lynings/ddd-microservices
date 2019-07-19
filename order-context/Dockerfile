FROM registry.cn-shenzhen.aliyuncs.com/ddd-microservices/java:8u172-jre-alpine
FROM registry.cn-shenzhen.aliyuncs.com/lyning/skywalking-agent:6.2.0
# 设置时区
RUN ln -fs /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

ARG JAR_FILE
ARG SERVICE_NAME
ENV PROFILE docker
ENV SERVICE_NAME ${SERVICE_NAME}

ADD ./${JAR_FILE} /opt/app.jar
EXPOSE 8080
ENTRYPOINT java ${JAVA_OPTS} -javaagent:/skywalking/agent/skywalking-agent.jar \
-Dskywalking.trace.ignore_path=/actuator/** \
-Dskywalking.agent.service_name=${SERVICE_NAME} \
-Dskywalking.collector.backend_service='172.17.0.3:11800' \
-Djava.security.egd=file:/dev/./urandom \
-Duser.timezone=Asia/Shanghai \
-Dfile.encoding=UTF-8 \
-Dspring.profiles.active=${PROFILE} \
-jar /opt/app.jar