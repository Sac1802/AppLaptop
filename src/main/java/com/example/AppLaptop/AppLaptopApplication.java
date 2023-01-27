package com.example.AppLaptop;

import com.example.AppLaptop.Repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AppLaptopApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AppLaptopApplication.class, args);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);
	}

}
