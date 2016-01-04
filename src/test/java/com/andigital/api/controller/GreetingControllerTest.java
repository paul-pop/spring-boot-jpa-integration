package com.andigital.api.controller;

import com.andigital.api.model.Greeting;
import com.andigital.api.service.GreetingService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Tests for {@link GreetingController}
 *
 * Created by Paul Pop on 27/10/2015.
 */
public class GreetingControllerTest {

    @Mock private GreetingService greetingService;
    @Mock private Greeting greeting;

    @InjectMocks
    private GreetingController controller = new GreetingController();

    @Before
    public void before() {
        initMocks(this);
    }

    @Test
     public void whenValidParametersProvidedReturnCorrectResponse() {
        when(greetingService.findByWhatAndTo("Hello", "Antonio")).thenReturn(greeting);

        Greeting result = controller.say("Hello", "Antonio");

        assertEquals(result.getWhat(), greeting.getWhat());
        assertEquals(result.getTo(), greeting.getTo());
    }

    @Test
    public void whenNullParametersProvidedReturnNullResponse() {
        when(greetingService.findByWhatAndTo(null, null)).thenReturn(null);

        Greeting result = controller.say(null, null);

        assertNull(result);
    }

}
