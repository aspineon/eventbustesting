package com.practicalunittesting.eventbus.listener;

import com.google.common.eventbus.Subscribe;
import com.practicalunittesting.eventbus.Event;
import com.practicalunittesting.eventbus.event.DoneThatEvent;

public class DoneThatEventListener {

    @Subscribe
    public void doneThatEvent(DoneThatEvent event) {
        System.out.println("done that: " + event);
    }
}
