package io.humourmind.kloudnative;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@SpringBootApplication(proxyBeanMethods = false)
@ConfigurationPropertiesScan
// @KubernetesApplication(name = "kloudnative", readinessProbe = @Probe(httpActionPath =
// "/actuator/health/readiness"), livenessProbe = @Probe(httpActionPath =
// "/actuator/health/liveness"), labels = {
// @Label(key = "kind", value = "k8s-native") }, version = "1.0.M1", group = "humourmind",
// imagePullPolicy = Always)
public class KloudNativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KloudNativeApplication.class, args);
	}

	@Bean
	RouterFunction<ServerResponse> routeHandler(final StarterConfig config) {
		return route().GET("/hello", request -> ok().body(Mono.fromSupplier(() -> {
			 try {
			 	Thread.sleep(config.getDelay());
			 }
			 catch (InterruptedException e) {
			 	// do nothing
			 }
			return config.getHello() + " with a delay of " + config.getDelay() + "ms";
		}), String.class)).build();
	}

}
