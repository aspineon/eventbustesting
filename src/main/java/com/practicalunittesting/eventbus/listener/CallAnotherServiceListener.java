package com.practicalunittesting.eventbus.listener;

import com.google.common.eventbus.Subscribe;
import com.practicalunittesting.eventbus.Event;
import com.practicalunittesting.eventbus.logic.AnotherService;
import org.springframework.beans.factory.annotation.Autowired;

public class CallAnotherServiceListener {

    private final AnotherService anotherService;

    public CallAnotherServiceListener(AnotherService anotherService) {
        this.anotherService = anotherService;
    }

    @Subscribe
    public void allEvents(Event event) {
        anotherService.doSomething();
    }
}
