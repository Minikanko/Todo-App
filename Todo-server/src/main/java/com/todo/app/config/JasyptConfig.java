package com.todo.app.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ulisesbocchio.jasyptspringboot.properties.JasyptEncryptorConfigurationProperties;

@Configuration
public class JasyptConfig {
	
	@Value("${jasypt.encryptor.password}")
	private String password;
	
	@Bean("jasyptStringEncryptor")
	public StringEncryptor StringEncryptor() {
		JasyptEncryptorConfigurationProperties properties = new JasyptEncryptorConfigurationProperties();
		
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		config.setPassword(password);
		config.setAlgorithm(properties.getAlgorithm());
		config.setKeyObtentionIterations(properties.getKeyObtentionIterations());
		config.setPoolSize(properties.getPoolSize());
		config.setSaltGeneratorClassName(properties.getSaltGeneratorClassname());
		config.setIvGeneratorClassName(properties.getIvGeneratorClassname());
		config.setStringOutputType(properties.getStringOutputType());
		
		PooledPBEStringEncryptor poolEnc = new PooledPBEStringEncryptor();
		poolEnc.setConfig(config);
		
		return poolEnc;
	}
}
