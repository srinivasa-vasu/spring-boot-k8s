#!/bin/bash

cd /tmp || exit

curl -Lo ./kind https://kind.sigs.k8s.io/dl/v0.10.0/kind-linux-amd64
chmod 755 ./kind
sudo mv kind /usr/local/bin/

curl -Lo skaffold https://storage.googleapis.com/skaffold/releases/latest/skaffold-linux-amd64
chmod 755 skaffold
sudo mv skaffold /usr/local/bin/

kind create cluster --name local-k8s
kubectl create ns spring
