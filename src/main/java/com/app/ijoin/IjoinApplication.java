package com.app.ijoin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("com.app.ijoin")
@SpringBootApplication
public class IjoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(IjoinApplication.class, args);
	}
}
