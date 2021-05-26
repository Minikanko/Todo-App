package com.todo.app.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "com.todo.app.mvc.repository")
public class MybatisConfig {

	@Bean
	//DB작업당 세션이 필요했던 상황을 sqlSessionFactory에 의해서 한개를 가지고 여려번 사용하게끔한다. 추가적으로 mapper.xml를 읽는다.
	public SqlSessionFactory sqlSessionFactory(@Autowired DataSource dataSource, ApplicationContext applicationContext) throws Exception {
		Resource myBatisConfig = new PathMatchingResourcePatternResolver().getResource("classpath:config/mybatis-config.xml");
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setConfigLocation(myBatisConfig);		
		factory.setDataSource(dataSource);
		//mapper.xml의 위치 지정
		factory.setMapperLocations(applicationContext.getResources("classpath:mapper/*.xml"));
		return factory.getObject();
	}
	
	//해당 세션의 라이프사이클 즉 open, close하는 기능을 지원해준다.
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(@Autowired SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
