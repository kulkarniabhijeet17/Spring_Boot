package com.springboot.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class OracleConfiguration {
	@ConfigurationProperties(prefix = "oracle")
	@Bean
	@Primary
	public DataSource getDataSource() {
		return DataSourceBuilder.create().build();
	}

	/*@Bean
	@Primary
	public DataSource getDataSource() {
		return DataSourceBuilder.create()
				.url("jdbc:oracle:thin:@localhost:1521:xe")
				.username("system")
				.password("Pulsor@150cc")
				.driverClassName("oracle.jdbc.driver.OracleDriver")
				.build();
	}*/
}