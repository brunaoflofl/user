package com.instituto.atlantico.conections;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DataSourceBean {

	@Bean(name = "teste.ia.datasource.url")
	public DataSource getDataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.h2.Driver");
		dataSourceBuilder.url("jdbc:h2:mem:testUsers");
		dataSourceBuilder.username("sa");
		dataSourceBuilder.password("password");

		return dataSourceBuilder.build();
	}

}
