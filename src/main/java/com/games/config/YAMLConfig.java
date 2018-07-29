package com.games.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@EnableConfigurationProperties
public class YAMLConfig{
	
	@Value("${spring.datasource.url}")
	private String url;
	
	public String getURL() {
		return url;
	}
	
}