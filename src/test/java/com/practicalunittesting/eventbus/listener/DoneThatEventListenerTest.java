package com.practicalunittesting.eventbus.listener;


import com.practicalunittesting.eventbus.event.DoneThatEvent;
import org.testng.annotations.Test;

@Test
public class DoneThatEventListenerTest {

    public void testListener() {
        //given
        DoneThatEventListener listener = new DoneThatEventListener();

        // when
        listener.doneThatEvent(new DoneThatEvent());

        // then
        // do some testing here of whatever DoneThatEventListener should do
    }
}
