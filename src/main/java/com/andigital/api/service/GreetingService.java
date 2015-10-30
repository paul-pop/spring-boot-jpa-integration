package com.andigital.api.service;

import com.andigital.api.model.Greeting;

/**
 * Created by ppop on 30/10/2015.
 */
public interface GreetingService {

    Greeting findByWhatAndTo(String what, String to);

}
