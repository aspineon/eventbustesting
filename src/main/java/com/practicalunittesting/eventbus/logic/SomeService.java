package com.practicalunittesting.eventbus.logic;

import com.practicalunittesting.eventbus.EventBusWrapper;
import com.practicalunittesting.eventbus.event.DoneThatEvent;
import com.practicalunittesting.eventbus.event.DoneThisEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeService {

	private final EventBusWrapper eventBus;

	@Autowired
	public SomeService(EventBusWrapper eventBus) {
		this.eventBus = eventBus;
	}

	public void doThis() {
		System.out.println("doing this");
		eventBus.post(new DoneThisEvent());
	}

	public void doThat() {
		System.out.println("doing that");
		eventBus.post(new DoneThatEvent());
	}
}
