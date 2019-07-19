#!/usr/bin/env bash
../gradlew :infra-config:docker

docker run -p 9090:9090 --rm \
-d \
-e JAVA_OPTS='-server -Xmx256M' \
-e PROFILE='docker' \
pers.lyning.medical.config-server
