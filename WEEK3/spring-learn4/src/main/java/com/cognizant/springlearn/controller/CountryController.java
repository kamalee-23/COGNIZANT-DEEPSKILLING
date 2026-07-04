package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    @RequestMapping("/country")
    public Country getCountryIndia() {

        LOGGER.info("Loading country details.");

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml");

        Country india = context.getBean("indiaCountry", Country.class);

        LOGGER.info("Country information returned successfully.");

        context.close();

        return india;
    }
}