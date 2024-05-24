package com.example.demo;

import com.example.demo.controller.ExceptionHandler;
import com.example.demo.entity.Role;
import com.example.demo.entity.RoleEnum;
import com.example.demo.entity.User;
import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
@Configuration
public class Main implements WebMvcConfigurer {

	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
		WebMvcConfigurer.super.configureHandlerExceptionResolvers(resolvers);
		resolvers.add(new ExceptionHandler());

	}

	private void init() {
		Role admin = new Role(null, RoleEnum.ROLE_USER, null);
		User adminUser = new User(null, "admin", "idk@gmail.com", passwordEncoder.encode("admin"), List.of(admin));
		userRepository.save(adminUser);
	}

}
