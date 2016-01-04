package com.andigital.api.controller;

import com.andigital.api.model.Greeting;
import com.andigital.api.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring REST controller that just returns a serialized JSON object made out of the request parameters.
 *
 * Created by Paul Pop on 27/10/2015.
 */
@RestController
@RequestMapping("/say")
class GreetingController {

    @Autowired
    private GreetingService service;

    @Transactional(readOnly = true)
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Greeting say(@RequestParam(value = "what", required = true) String what,
                        @RequestParam(value = "to", required = true) String to) {


        return service.findByWhatAndTo(what, to);
    }

}
