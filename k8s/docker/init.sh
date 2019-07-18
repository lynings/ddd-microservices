#!/usr/bin/env bash
minikube stop && minikube delete
minikube start --cpus 4 --memory 4096 --docker-env HTTP_PROXY=http://10.0.2.2:1087 --docker-env HTTPS_PROXY=http://10.0.2.2:1087 --docker-env NO_PROXY=localhost,127.0.0.1,10.96.0.0/12,192.168.99.0/24,192.168.39.0/24
kubectl create namespace ddd-microservices