package io.humourmind.kloudnative;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = "starter")
@ConstructorBinding
public class StarterConfig {

	private String hello;
	private long delay;

	StarterConfig() {
	}

	StarterConfig(@DefaultValue("hi") String hello, long delay) {
		this.hello = hello;
		this.delay = delay;
	}

	String getHello() {
		return hello;
	}

	void setHello(String hello) {
		this.hello = hello;
	}

	long getDelay() {
		return delay;
	}

	void setDelay(long delay) {
		this.delay = delay;
	}
}
