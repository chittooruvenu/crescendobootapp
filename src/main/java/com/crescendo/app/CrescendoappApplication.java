package com.crescendo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.crescendo.app.core.repository.EnquiryRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = EnquiryRepository.class)
public class CrescendoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrescendoappApplication.class, args);
	}

}
 