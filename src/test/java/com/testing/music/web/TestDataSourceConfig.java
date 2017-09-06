package com.testing.music.web;

import javax.sql.DataSource;

import liquibase.integration.spring.SpringLiquibase;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@TestConfiguration
@Profile("test")
public class TestDataSourceConfig {

	@Bean
	@Primary
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
			.generateUniqueName(true)
			.setType(EmbeddedDatabaseType.HSQL)
			.setScriptEncoding("UTF-8")
			.ignoreFailedDrops(true).build();
	}

	@Bean
	public SpringLiquibase springLiquibase() {
		SpringLiquibase springLiquibase = new SpringLiquibase();
		springLiquibase.setDataSource(dataSource());
		springLiquibase.setChangeLog("classpath:/db/changelog/db.changelog-master.xml");
		return springLiquibase;
	}

}
