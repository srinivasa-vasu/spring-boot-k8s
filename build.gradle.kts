import org.springframework.boot.buildpack.platform.build.PullPolicy.*

plugins {
    id("org.springframework.boot") version "2.4.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("java")
}

group = "io.humourmind"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

extra["wavefrontVersion"] = "2.1.0"
extra["springCloudVersion"] = "2020.0.0"

dependencyManagement {
    imports {
        mavenBom("com.wavefront:wavefront-spring-boot-bom:${property("wavefrontVersion")}")
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.bootJar {
    layered {
        isEnabled = true
    }
}

tasks.bootBuildImage {
    // imageName 	= "humourmind/${project.name}:${project.version}"
    // environment = listOf("BP_JVM_VERSION"  = "11.0.7", "BPL_JVM_HEAD_ROOM"  = "5")
    // builder 	= "paketobuildpacks/builder:tiny"
    // verboseLogging = true
    // publish = true
//	environment = listOf("BP_BOOT_NATIVE_IMAGE"  = "1", "BP_BOOT_NATIVE_IMAGE_BUILD_ARGUMENTS" = "-Dspring.native.remove-yaml-support=true -Dspring.native.remove-jmx-support=true -Dspring.native.remove-spel-support=true -H =TraceClassInitialization=true --initialize-at-build-time=org.springframework.boot.logging")
    pullPolicy = IF_NOT_PRESENT
    // verboseLogging = true
    imageName = "humourmind/kloudnative-cnb:1.0"
//    environment = mapOf("BP_BOOT_NATIVE_IMAGE"  to "1", "BP_JVM_VERSION" to "11")
//    builder 	= "paketobuildpacks/builder:tiny"
//	builder 	= "humourmind/paketo-java-builder-tiny@sha256:42eeea2f4cbf6ebc22bf4acc832edd9579c68c59f6755378c20bac0c8b55df9f"
    // builder 	= "humourmind/paketo-java-builder-tiny@sha256:fd6c716f4dbf4a58c1a7e2d39f80eb1d724c05fa0a4d74569657c5b3098ae88f"
    // builder 	= "humourmind/paketo-java-builder-tiny@sha256:40be20ed070cce98f6cfa3b9b588919502cc5f4f7ee330d19ec28cddf7d985bb" // latest
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
//    implementation("io.dekorate:kubernetes-spring-starter:0.10.0")
//    implementation("com.wavefront:wavefront-spring-boot-starter")
//    implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
    implementation("org.springframework:spring-context-indexer")
//    implementation("org.springframework.experimental:spring-graalvm-native:0.8.3")
//    implementation("io.micrometer:micrometer-registry-prometheus")
//    compileOnly("org.projectlombok:lombok")
//    developmentOnly("org.springframework.boot:spring-boot-devtools")
//    runtimeOnly("com.h2database:h2")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
//    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
