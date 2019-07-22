#!/usr/bin/env bash
../gradlew :patient-context:docker &&

docker run --rm \
-d \
-e JAVA_OPTS='-server -Xmx256M' \
-e PROFILE='docker' \
-e CONFIG_SERVER_HOST=172.17.0.7 \
-e CONFIG_SERVER_PORT=9090 \
-e EUREKA_SERVER_HOST=172.17.0.5 \
-e EUREKA_SERVER_PORT=8010 \
pers.lyning.medical.patient-server
