package com.nuvalence.demospringbootkube.controller;

import com.nuvalence.demospringbootkube.rectangle.Rectangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.micrometer.core.instrument.MeterRegistry;

import java.util.Arrays;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestController.class);

    @Autowired
    private MeterRegistry meterRegistry;

    @Value("${greeting.message:defaultConfigValue}")
    String greetingMessage;

    @GetMapping("/")
    public ResponseEntity<String> greeting(){
        meterRegistry.counter("greeting_rest_requests_total").increment();
        return new ResponseEntity<>("welcome to Will's demo of springboot & kubernetes!", HttpStatus.OK);
    }

    @GetMapping("/testConfig")
    public ResponseEntity<String> testConfig(){
        return new ResponseEntity<>(greetingMessage, HttpStatus.OK);
    }

    @PostMapping("/checkRectangle")
    public ResponseEntity<String> checkRectangle(@PathVariable Integer[] coordinates){
        try{
            Rectangle recA = Rectangle.getRectangle(Arrays.copyOfRange(coordinates, 0, coordinates.length+1/2));
            Rectangle recB = Rectangle.getRectangle(Arrays.copyOfRange(coordinates, coordinates.length+1/2, coordinates.length));
            return new ResponseEntity<>(recA.checkRectangleRelationship(recB), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }
}
