package com.SEPTeam04.Admin;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.time.format.DateTimeFormatter;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AdminApplication {

	private  static final String dateFormat = "dd-MM-yyyy";

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);

	}

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer customizer () {
		return builder -> {
			builder.simpleDateFormat(dateFormat);
			builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateFormat)));
			builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)));
		};
	}

}
