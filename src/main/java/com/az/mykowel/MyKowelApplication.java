package com.az.mykowel;

import com.az.mykowel.model.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class MyKowelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyKowelApplication.class, args);
	}
}
