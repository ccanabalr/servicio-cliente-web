package com.servicioclienteweb.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ServicioClienteWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioClienteWebApplication.class, args);
	}

}
