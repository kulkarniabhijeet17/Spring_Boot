package com.springboot.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import oracle.jdbc.pool.OracleDataSource;

@SpringBootConfiguration
@PropertySource("file:///D:/Abhijeet/Computer Science/workspace/FrameWorks/Spring/Boot/config.properties")
public class PropConfig {
	@Value("${oracle.url}")
	private String url;

	@Value("${oracle.username}")
	private String username;

	@Value("${oracle.password}")
	private String password;

	@Bean
	DataSource dataSource() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser(username);
		dataSource.setPassword(password);
		dataSource.setURL(url);
		dataSource.setImplicitCachingEnabled(true);
		dataSource.setFastConnectionFailoverEnabled(true);

		return dataSource;
	}
}