package io.humourmind.kloudnative;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = "starter")
@ConstructorBinding
public class StarterConfig {

	private String hello;

	StarterConfig(@DefaultValue("hi") String hello) {
		this.hello = hello;
		System.out.println(hello);
	}

	String getHello() {
		return hello;
	}

	void setHello(String hello) {
		this.hello = hello;
	}
}