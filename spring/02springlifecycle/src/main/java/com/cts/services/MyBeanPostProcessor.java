package com.cts.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object obj, String arg1) throws BeansException {
		System.out.println("After BPP for " + obj);
//		obj.
		return obj;
	}

	@Override
	public Object postProcessBeforeInitialization(Object obj, String arg1) throws BeansException {
		System.out.println("Before BPP for " + obj);
		return obj;
	}

}
