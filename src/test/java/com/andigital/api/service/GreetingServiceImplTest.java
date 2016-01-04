package com.andigital.api.service;

import com.andigital.api.model.Greeting;
import com.andigital.api.repository.GreetingRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by ppop on 04/01/2016.
 */
public class GreetingServiceImplTest {

    @Mock private GreetingRepository greetingRepository;
    @Mock private Greeting greeting;

    @InjectMocks
    private GreetingServiceImpl greetingService = new GreetingServiceImpl();

    @Before
    public void before() {
        initMocks(this);
    }

    @Test
     public void whenNullParametersProvidedThenReturnNullResponse() {
        when(greetingRepository.findByWhatAndTo(null, null)).thenReturn(null);

        Greeting result = greetingService.findByWhatAndTo(null, null);

        assertNull(result);
    }

    @Test
    public void whenValidParametersProvidedThenReturnCorrectResponse() {
        when(greetingRepository.findByWhatAndTo("Hello", "Antonio")).thenReturn(greeting);

        Greeting result = greetingService.findByWhatAndTo("Hello", "Antonio");

        assertEquals(result.getWhat(), greeting.getWhat());
        assertEquals(result.getTo(), greeting.getTo());
    }

}
