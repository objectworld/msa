package org.objectworld.book.customer.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Profile({"default", "local","dev"})
@PropertySources({
	@PropertySource("classpath:application.properties"),
	@PropertySource(value= "classpath:application-${spring-profiles-active:dev}.properties", ignoreResourceNotFound = true)
})
@Slf4j
public class ConfigurationLocal {
	
	@Primary
	@Bean(name = "datasource")
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource() {
		log.info("DataSoruce Configuration is for developement environment");
		return DataSourceBuilder.create().build();
	}
}
