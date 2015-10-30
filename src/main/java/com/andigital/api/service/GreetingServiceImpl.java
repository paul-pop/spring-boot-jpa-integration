package com.andigital.api.service;

import com.andigital.api.model.Greeting;
import com.andigital.api.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ppop on 30/10/2015.
 */
@Component
public class GreetingServiceImpl implements GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public Greeting findByWhatAndTo(String what, String to) {
        return greetingRepository.findByWhatAndTo(what, to);
    }
}
