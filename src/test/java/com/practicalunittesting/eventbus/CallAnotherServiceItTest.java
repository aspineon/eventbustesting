package com.practicalunittesting.eventbus;

import com.practicalunittesting.eventbus.event.DoneThisEvent;
import com.practicalunittesting.eventbus.logic.AnotherService;
import org.kubek2k.springockito.annotations.ReplaceWithMock;
import org.kubek2k.springockito.annotations.SpringockitoContextLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.mockito.Mockito.verify;

@ContextConfiguration(
        loader = SpringockitoContextLoader.class,
        locations = {"classpath:listeners.xml"})
public class CallAnotherServiceItTest extends AbstractTestNGSpringContextTests {

    @ReplaceWithMock
    @Autowired
    private AnotherService anotherService;

	@Autowired
	EventBusWrapper eventBus;

	@Test
	public void shouldCallAnotherService() {
		// given
		// when
        eventBus.post(new DoneThisEvent());

		// then
        verify(anotherService).doSomething();
	}
}
