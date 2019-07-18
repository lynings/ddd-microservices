#!/usr/bin/env bash
cat infra-registry-rc.yml | sed "s/{{VM_IP}}/$(minikube ip)/g" | kubectl apply -f -
cat infra-registry-svc.yml | sed "s/{{VM_IP}}/$(minikube ip)/g" | kubectl apply -f -

cat infra-config-rc.yml | sed "s/{{VM_IP}}/$(minikube ip)/g" | kubectl apply -f -
cat infra-config-svc.yml | sed "s/{{VM_IP}}/$(minikube ip)/g" | kubectl apply -f -

cat infra-gateway-rc.yml | sed "s/{{VM_IP}}/$(minikube ip)/g" | kubectl apply -f -
cat infra-gateway-svc.yml | sed "s/{{VM_IP}}/$(minikube ip)/g" | kubectl apply -f -


#kubectl create -f infra-registry-rc.yml
#kubectl create -f infra-registry-svc.yml
#
#kubectl create -f infra-config-rc.yml
#kubectl create -f infra-config-svc.yml
#
#kubectl create -f infra-gateway-rc.yml
#kubectl create -f infra-gateway-svc.yml