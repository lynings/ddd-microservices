#!/usr/bin/env bash
../gradlew :infra-registry:docker

docker run -p 8010:8010 --rm \
-e JAVA_OPTS='-server -Xmx256M' \
-e PROFILE='docker' \
-e SERVER_PORT=8010 \
-e EUREKA_SERVER_HOST=172.17.0.4 \
-e EUREKA_SERVER_PORT=8010 \
pers.lyning.medical/infra-registry
