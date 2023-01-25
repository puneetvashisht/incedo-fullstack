package com.cts.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0) throws BeansException {
		System.out.println("My bean factory post processor!!");
		String[] beanNames = arg0.getBeanDefinitionNames();
		for(String beanName: beanNames){
			System.out.println("Bean Name is: " + beanName);
		}
	}

}
