package com.todo.app.config;


import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author  	: Mr.K
 * @Date 		: 2021. 5. 22.
 * @Version 	: 
 * @Info 		: Datasource 설정
 */
@Configuration
public class DatabaseConfig {
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	//스프링부트에서 자동적으로  configure를 불러올때 속성을 prefix에서 찾겠다.
	//dbcp pool은 hikari, h2, tomcat 중 hikari 사용 
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
}
