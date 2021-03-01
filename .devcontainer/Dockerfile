# See here for image contents: https://github.com/microsoft/vscode-dev-containers/tree/v0.158.0/containers/codespaces-linux/.devcontainer/base.Dockerfile

FROM mcr.microsoft.com/vscode/devcontainers/universal:1-focal

USER root

RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
    && apt-get -y install --no-install-recommends 

RUN curl -sSLo ./kind https://kind.sigs.k8s.io/dl/v0.10.0/kind-linux-amd64 \
    && chmod +x ./kind \
    && mv ./kind /usr/local/bin/

RUN curl -sSLo skaffold https://storage.googleapis.com/skaffold/releases/latest/skaffold-linux-amd64 \
    && chmod +x skaffold \
    && mv ./skaffold /usr/local/bin/

USER codespace

RUN alias k='kubectl'
RUN alias kc='kubectl create'
