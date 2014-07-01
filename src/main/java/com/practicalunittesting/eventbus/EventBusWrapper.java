package com.practicalunittesting.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * A thin wrapper over Guava's EventBus.
 */
public class EventBusWrapper {

    private final EventBus eventBus;

	public EventBusWrapper(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void post(Event event) {
        eventBus.post(event);
    }

    public void register(Object listener) {
        eventBus.register(listener);
    }
}
