package com.practicalunittesting.eventbus;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Registers all listeners to EventBus so all you need to do is to declare them in XML.
 * See http://stackoverflow.com/questions/13804295/register-beans-automatically-in-guava-eventbus-with-spring-ioc
 * http://pmeade.blogspot.com/2012/06/using-guava-eventbus-with-spring.html
 * http://pmeade.blogspot.com/2013/02/using-guava-eventbus-with-spring-part-2.html
 * http://nayidisha.com/techblog/the-guava-eventbus-and-spring-proxies
 */
public class EventBusRegisterBeanPostProcessor implements BeanPostProcessor {

	@Autowired
	private EventBusWrapper eventBus;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		eventBus.register(bean);
		return bean;
	}
}
