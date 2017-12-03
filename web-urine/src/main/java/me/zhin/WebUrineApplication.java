package me.zhin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@MapperScan("me.zhin.web.weburine.dao")
public class WebUrineApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebUrineApplication.class, args);
	}
}
