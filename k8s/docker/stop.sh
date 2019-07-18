#!/usr/bin/env bash
cat infra-registry-rc.yml | sed "s/{{VM_IP}}/$(minikube ip)/g" | kubectl delete -f -
cat infra-registry-svc.yml | sed "s/{{VM_IP}}/$(minikube ip)/g" | kubectl delete -f -

cat infra-config-rc.yml | sed "s/{{VM_IP}}/$(minikube ip)/g" | kubectl delete -f -
cat infra-config-svc.yml | sed "s/{{VM_IP}}/$(minikube ip)/g" | kubectl delete -f -

cat infra-gateway-rc.yml | sed "s/{{VM_IP}}/$(minikube ip)/g" | kubectl delete -f -
cat infra-gateway-svc.yml | sed "s/{{VM_IP}}/$(minikube ip)/g" | kubectl delete -f -


#kubectl delete -f infra-registry-rc.yml
#kubectl delete -f infra-registry-svc.yml
#
#kubectl delete -f infra-config-rc.yml
#kubectl delete -f infra-config-svc.yml
#
#kubectl delete -f infra-gateway-rc.yml
#kubectl delete -f infra-gateway-svc.yml