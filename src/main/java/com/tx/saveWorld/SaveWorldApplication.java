package com.tx.saveWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目的启动入口
 */
@RestController
@SpringBootApplication
public class SaveWorldApplication {

	@RequestMapping("/")
	String index(){
		return "save world";
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SaveWorldApplication.class);
		app.run(args);
	}
}
