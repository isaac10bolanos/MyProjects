package com.skillstorm;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={XADataSourceAutoConfiguration.class})
public class MusicBackend2Application {

	public static void main(String[] args) {
		SpringApplication.run(MusicBackend2Application.class, args);
	}

}
