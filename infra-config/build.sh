#!/usr/bin/env bash
../gradlew :infra-config:docker

docker run -p 9090:9090 --rm \
-e JAVA_OPTS='-server -Xmx256M' \
-e PROFILE='local' \
ddd-microservices/config-server
