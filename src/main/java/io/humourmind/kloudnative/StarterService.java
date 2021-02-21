package io.humourmind.kloudnative;

import org.springframework.stereotype.Service;

@Service
public class StarterService {

	public String hello() {
		try {
			Thread.sleep(10000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Hello there!";
	}

}
