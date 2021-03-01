# See here for image contents: https://github.com/microsoft/vscode-dev-containers/tree/v0.158.0/containers/codespaces-linux/.devcontainer/base.Dockerfile
ARG version=1-focal

FROM mcr.microsoft.com/vscode/devcontainers/universal:$version

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

ENV user=srinivasa-vasu

RUN echo 'alias k="kubectl"' >> ~/.bashrc
RUN echo 'alias kc="kubectl create"' >> ~/.bashrc
RUN echo 'test $(kind get clusters -q | wc -l) -eq 0 && nohup kind create cluster --name local-k8s </dev/null >/dev/null 2>&1 &' >> ~/.bashrc
RUN echo 'echo $CR_PAT | docker login ghcr.io -u $user --password-stdin' >> ~/.bashrc
