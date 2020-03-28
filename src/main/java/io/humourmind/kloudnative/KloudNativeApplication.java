package io.humourmind.kloudnative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@KubernetesApplication(name = "kloudnative", readinessProbe = @Probe(httpActionPath = "/actuator/health/readiness"), livenessProbe = @Probe(httpActionPath = "/actuator/health/liveness"), labels = {
//		@Label(key = "kind", value = "k8s-native") }, version = "1.0.M1", group = "humourmind", imagePullPolicy = Always)
public class KloudNativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KloudNativeApplication.class, args);
	}

}
