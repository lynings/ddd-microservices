FROM registry.cn-shenzhen.aliyuncs.com/ddd-microservices/java:8u172-jre-alpine
# 设置时区
RUN ln -fs /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

ARG JAR_FILE
ARG SERVICE_NAME
ENV PROFILE docker
ENV SERVICE_NAME ${SERVICE_NAME}

ADD ./${JAR_FILE} /opt/app.jar
EXPOSE 8080
ENTRYPOINT java ${JAVA_OPTS} \
-Djava.security.egd=file:/dev/./urandom \
-Duser.timezone=Asia/Shanghai \
-Dfile.encoding=UTF-8 \
-Dspring.profiles.active=${PROFILE} \
-jar /opt/app.jar