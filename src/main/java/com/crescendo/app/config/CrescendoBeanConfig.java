package com.crescendo.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class CrescendoBeanConfig {

	
	  @Bean 
	  public ResourceBundleMessageSource messageSource() {
	  ResourceBundleMessageSource messageSource = new
	  ResourceBundleMessageSource();
	  messageSource.setBasename("classpath:message"); return messageSource; }
	 
	  @Bean
	  public javax.validation.Validator validator() {
	      final LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
	      factory.setValidationMessageSource(messageSource());
	      return factory;
	  }
	/*
	 * @Bean public MessageSource messageSource() {
	 * ReloadableResourceBundleMessageSource messageSource = new
	 * ReloadableResourceBundleMessageSource();
	 * 
	 * messageSource.setBasename("classpath:message");
	 * messageSource.setDefaultEncoding("UTF-8"); return messageSource; }
	 */
	
}
