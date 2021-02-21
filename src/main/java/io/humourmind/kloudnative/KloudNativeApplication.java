package io.humourmind.kloudnative;

import java.util.function.Supplier;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication(proxyBeanMethods = false)
@ConfigurationPropertiesScan
// @KubernetesApplication(name = "kloudnative", readinessProbe = @Probe(httpActionPath =
// "/actuator/health/readiness"), livenessProbe = @Probe(httpActionPath =
// "/actuator/health/liveness"), labels = {
// @Label(key = "kind", value = "k8s-native") }, version = "1.0.M1", group = "humourmind",
// imagePullPolicy = Always)
public class KloudNativeApplication {

	private final StarterService starterService;

	KloudNativeApplication(StarterService starterService) {
		this.starterService = starterService;
	}

	public static void main(String[] args) {
		SpringApplication.run(KloudNativeApplication.class, args);
	}

	@Bean
	RouterFunction<ServerResponse> routeHandler() {
//		return route().GET("/hello", request -> ok().body(Mono.just(starterService.hello()), String.class)).build();
		return route().GET("/hello", request -> ok().body(Mono.fromSupplier(() -> {
			try {
				Thread.sleep(5000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Hi there!";
		}), String.class)).build();
	}

}
