package com.az.mykowel;

import com.az.mykowel.model.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class MyKowelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyKowelApplication.class, args);
	}
}
