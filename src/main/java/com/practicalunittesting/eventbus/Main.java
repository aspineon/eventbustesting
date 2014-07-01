package com.practicalunittesting.eventbus;

import com.practicalunittesting.eventbus.logic.SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		SomeService service = context.getBean(SomeService.class);
		service.doThis();
		service.doThat();
		service.doThis();
	}
}
