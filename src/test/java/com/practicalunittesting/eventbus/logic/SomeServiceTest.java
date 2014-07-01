package com.practicalunittesting.eventbus.logic;

import com.practicalunittesting.eventbus.EventBusWrapper;
import com.practicalunittesting.eventbus.event.DoneThatEvent;
import com.practicalunittesting.eventbus.event.DoneThisEvent;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class SomeServiceTest {

	private EventBusWrapper eventBus;

	@BeforeMethod
	public void createMocks() {
		eventBus = mock(EventBusWrapper.class);
	}

	@Test
	public void shouldSendDoneThisEvent() {
		// given
		SomeService service = new SomeService(eventBus);

		// when
		service.doThis();

		// then
		verify(eventBus).post(isA(DoneThisEvent.class));
		verifyNoMoreInteractions(eventBus);
	}

	@Test
	public void shouldSendDoneThatEvent() {
		// given
		SomeService service = new SomeService(eventBus);

		// when
		service.doThat();

		// then
		verify(eventBus).post(isA(DoneThatEvent.class));
		verifyNoMoreInteractions(eventBus);
	}
}
