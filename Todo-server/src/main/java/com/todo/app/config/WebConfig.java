package com.todo.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.todo.app.mvc.domain.BaseCodeLabelEnum;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(BaseCodeLabelEnum.class,new BaseCodeLabelEnumJsonSerializer());
		objectMapper.registerModule(simpleModule);
		return objectMapper;
	}
	
	/*
	 * 클라이언트의 요청을 받은 결과값으로 View이름을 전달한다. 이 View이름으로 ViewObject를 찾아서 전달할 View 내용을
	 * 생성한다 View 이름을 전달하면서 데이터도 같이 전달하게 된다. 이 때 ajax를 사용 중이라면 값을 전달할 때 마다 일일이 json으로
	 * 바꿔야 한다 MappingJaxkson2JsonView를 사용하면 간단하게 전달할 수 있다.
	 * ModelAndView가 json형식으로 변한다 => 일일이 json 변환하지 않아도 됨
	 */
	
	@SuppressWarnings("deprecation")
	@Bean
	public MappingJackson2JsonView mappingJackson2JsonView() {
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		jsonView.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);			// return application/json"
		jsonView.setObjectMapper(objectMapper());
		return jsonView;
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*");
	}
	
}
