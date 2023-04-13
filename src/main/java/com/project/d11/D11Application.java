package com.project.d11;

import com.project.d11.impl.D11RepoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.project.d11")
@EnableJpaRepositories(repositoryBaseClass = D11RepoImpl.class)
public class D11Application {

	public static void main(String[] args) {
		SpringApplication.run(D11Application.class, args);
	}

}
