#!/usr/bin/env bash
../gradlew :infra-gateway:docker &&

docker run -p 7890:7890 --rm \
-d \
-e JAVA_OPTS='-server -Xmx256M' \
-e PROFILE='docker' \
-e SERVER_PORT=7890 \
-e EUREKA_SERVER_HOST=172.17.0.5 \
-e EUREKA_SERVER_PORT=8010 \
pers.lyning.medical.gateway-server
