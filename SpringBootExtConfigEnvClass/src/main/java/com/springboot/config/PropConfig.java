package com.springboot.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import oracle.jdbc.pool.OracleDataSource;

@SpringBootConfiguration
@PropertySource("file:///D:/Abhijeet/Computer Science/workspace/FrameWorks/Spring/Boot/config.properties")
public class PropConfig {
	@Autowired
	Environment env;

	@Bean
	DataSource dataSource() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser(env.getProperty("oracle.username"));
		dataSource.setPassword(env.getProperty("oracle.password"));
		dataSource.setURL(env.getProperty("oracle.url"));
		dataSource.setImplicitCachingEnabled(true);
		dataSource.setFastConnectionFailoverEnabled(true);

		return dataSource;
	}
}