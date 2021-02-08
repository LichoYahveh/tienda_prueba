package com.prueba.root.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ConfigurationHelp {

	@Bean
	public BCryptPasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}
}
