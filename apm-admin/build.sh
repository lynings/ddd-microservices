#!/usr/bin/env bash
../gradlew :apm-admin:docker &&

docker run -p 1234:8080 --rm \
-d \
-e JAVA_OPTS='-server -Xmx256M' \
-e PROFILE='default' \
-e ADMIN_HOST=172.17.0.6 \
-e EUREKA_SERVER_HOST=172.17.0.5 \
-e EUREKA_SERVER_PORT=8010 \
pers.lyning.medical.apm-admin
