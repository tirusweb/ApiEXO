package com.Exo_Web.Exo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.Exo_Web.Exo.mapper")
public class ExoApplication {

	public static void main(String[] args) {

		SpringApplication.run(ExoApplication.class, args);
	}

}
