package io.humourmind.kloudnative;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest
@Import(StarterConfig.class)
class KloudNativeApplicationTests {

	@Autowired
	private StarterConfig config;

	@Autowired
	private WebTestClient testClient;

	@BeforeEach
	public void setUp() {
		testClient = testClient.mutate().responseTimeout(Duration.ofMillis(30000))
				.build();
	}

	@Test
	void delayEndPoint() throws Exception {
		testClient.get().uri("/hello").exchange().expectStatus().isOk()
				.expectBody(String.class).isEqualTo(config.getHello());
	}

}
