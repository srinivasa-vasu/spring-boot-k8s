# See here for image contents: https://github.com/microsoft/vscode-dev-containers/tree/v0.158.0/containers/codespaces-linux/.devcontainer/base.Dockerfile
ARG version=1-focal

FROM mcr.microsoft.com/vscode/devcontainers/universal:$version

USER root

RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
    && apt-get -y install --no-install-recommends 

RUN curl -sSLo ./kind https://kind.sigs.k8s.io/dl/latest/kind-linux-amd64 \
    && chmod +x ./kind \
    && mv ./kind /usr/local/bin/

RUN curl -sSLo skaffold https://storage.googleapis.com/skaffold/releases/latest/skaffold-linux-amd64 \
    && chmod +x skaffold \
    && mv ./skaffold /usr/local/bin/

RUN curl -sSLo ./dive.tar.gz https://github.com/wagoodman/dive/releases/download/v0.10.0/dive_0.10.0_linux_amd64.tar.gz \
    && tar -xvf dive.tar.gz dive \
    && chmod +x dive \
    && mv ./dive /usr/local/bin/ \
    && rm ./dive.tar.gz

USER codespace

ENV user=srinivasa-vasu
ENV registry=ghcr.io

RUN echo 'alias k="kubectl"' >> ~/.bashrc
RUN echo 'alias kc="kubectl create"' >> ~/.bashrc
RUN echo 'test $(kind get clusters -q | wc -l) -eq 0 && nohup kind create cluster --name local-k8s </dev/null >/dev/null 2>&1 &' >> ~/.bashrc
RUN echo 'echo $CR_PAT | docker login $registry -u $user --password-stdin' >> ~/.bashrc
