package com.maijijun.springboot.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;

@Configurable
public class TestConfig  {
	@Bean
	public JdbcTemplate getJdbcTemplate(){
		JdbcTemplate jdbc = new JdbcTemplate();
		jdbc.setDataSource(dataSource());
		return jdbc;
	}

	@Bean(name="dataSource")
	@Qualifier(value = "dataSource")
	@Primary
	@ConfigurationProperties(prefix ="c3p0")
	public DataSource dataSource(){
		return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
	}

	//跨域

}
