package com.tothenew.sharda.springsecurity1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Springsecurity1Application {

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		System.out.println("hello world, I have just started up");
	}

	public static void main(String[] args) {
		SpringApplication.run(Springsecurity1Application.class, args);
	}

}
