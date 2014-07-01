package com.practicalunittesting.eventbus.listener;

import com.google.common.eventbus.Subscribe;
import com.practicalunittesting.eventbus.event.DoneThisEvent;

public class DoneThisEventsListener {

    @Subscribe
    public void doneThisEvent(DoneThisEvent event) {
        System.out.println("done this: " + event);
    }
}
