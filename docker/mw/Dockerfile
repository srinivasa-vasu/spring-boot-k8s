FROM humourmind/ubuntu:bionic

ENV JAVA_VERSION jdk-11.0.7+10

RUN set -eux; \
    ARCH="$(dpkg --print-architecture)"; \
    case "${ARCH}" in \
       aarch64|arm64) \
         ESUM='cfe504e9e9621b831a5cfd800a2005dafe90a1d11aa14ee35d7b674d68685698'; \
         BINARY_URL='https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.7%2B10/OpenJDK11U-jre_aarch64_linux_hotspot_11.0.7_10.tar.gz'; \
         ;; \
       armhf|armv7l) \
         ESUM='581bae8efcaa40e209a780baa6f96b7c8c9397965bc6d54533f4fd8599d5c742'; \
         BINARY_URL='https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.7%2B10/OpenJDK11U-jre_arm_linux_hotspot_11.0.7_10.tar.gz'; \
         ;; \
       ppc64el|ppc64le) \
         ESUM='364a030a4c5c10660d33988bd1d40e6a34f49ca6a2e04ff44b8cf809da75423a'; \
         BINARY_URL='https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.7%2B10/OpenJDK11U-jre_ppc64le_linux_hotspot_11.0.7_10.tar.gz'; \
         ;; \
       s390x) \
         ESUM='8e14d11a84c67da457695cbc20a9d70628c741ffc09087d11b40a52f2e11dddc'; \
         BINARY_URL='https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.7%2B10/OpenJDK11U-jre_s390x_linux_hotspot_11.0.7_10.tar.gz'; \
         ;; \
       amd64|x86_64) \
         ESUM='74b493dd8a884dcbee29682ead51b182d9d3e52b40c3d4cbb3167c2fd0063503'; \
         BINARY_URL='https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.7%2B10/OpenJDK11U-jre_x64_linux_hotspot_11.0.7_10.tar.gz'; \
         ;; \
       *) \
         echo "Unsupported arch: ${ARCH}"; \
         exit 1; \
         ;; \
    esac; \
    curl -LfsSo /tmp/openjdk.tar.gz ${BINARY_URL}; \
    echo "${ESUM} */tmp/openjdk.tar.gz" | sha256sum -c -; \
    mkdir -p /opt/java/openjdk; \
    cd /opt/java/openjdk; \
    tar -xf /tmp/openjdk.tar.gz --strip-components=1; \
    rm -rf /tmp/openjdk.tar.gz;

ENV JAVA_HOME=/opt/java/openjdk \
    PATH="/opt/java/openjdk/bin:$PATH"