package com.practicalunittesting.eventbus;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;
import com.practicalunittesting.eventbus.event.DoneThatEvent;
import com.practicalunittesting.eventbus.event.DoneThisEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(locations = {"classpath:listeners.xml"})
public class EventsItTest extends AbstractTestNGSpringContextTests {

	@Autowired
	EventBusWrapper eventBus;

	@Test
	public void shouldCatchAllImportantBusinessEvents() {
		// given
        // another option would be to create another XML config file
        // tests-listeners.xml with this DeadEventListener so it is registered with eventBus
        // and pass it to @ContextConfiguration
        DeadEventListener deadEventsCollector =  new DeadEventListener();
		eventBus.register(deadEventsCollector);

		// when
        eventBus.post(new DoneThisEvent());
        eventBus.post(new DoneThatEvent());

		// then
        assertThat(deadEventsCollector.getEvents()).isEmpty();
	}

    private class DeadEventListener {

        private Set<DeadEvent> events = new HashSet<DeadEvent>();

        @Subscribe
        public void fetchDeadEvents(DeadEvent event) {
            events.add(event);
        }

        public Set<DeadEvent> getEvents() {
            return events;
        }
    }
}
