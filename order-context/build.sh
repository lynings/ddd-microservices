#!/usr/bin/env bash
../gradlew :order-context:docker

docker run -p 8090:8090 --rm \
-e JAVA_OPTS='-server -Xmx256M' \
-e PROFILE='local' \
-e SERVER_PORT=8090 \
-e CONFIG_SERVER_HOST=172.17.0.3 \
-e CONFIG_SERVER_PORT=9090 \
-e EUREKA_SERVER_HOST=172.17.0.4 \
-e EUREKA_SERVER_PORT=8010 \
pers.lyning.medical/order-context