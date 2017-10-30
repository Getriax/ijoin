package com.hack.yeah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("com.hack.yeah")
@SpringBootApplication
public class HackyeahApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackyeahApplication.class, args);
	}
}
