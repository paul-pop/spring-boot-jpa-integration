package com.andigital.api.controller;

import com.andigital.api.model.Greeting;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Tests for {@link SaySomethingController}
 *
 * Created by Paul Pop on 27/10/2015.
 */
public class SaySomethingControllerTest {

    private SaySomethingController controller;

    @Before
    public void before() {
        controller = new SaySomethingController();
    }

    @Test
     public void saySomethingNiceAndValid() {
        Greeting result = controller.say("Love", "you!");

        assertEquals(result.getWhat(), "Love");
        assertEquals(result.getTo(), "you!");
    }

    @Test
    public void saySomethingInvalid() {
        Greeting result = controller.say(null, null);

        assertNull(result.getWhat());
        assertNull(result.getTo());
    }

}
