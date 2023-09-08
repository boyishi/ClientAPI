package com.boyishi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@SuppressWarnings("unused")
	private static void checkBeansPresence(String... beans) {
		for (String beanName : beans) {
			System.out
					.println("Is " + beanName + " in ApplicationContext: " + applicationContext.containsBean(beanName));
		}
	}

}
