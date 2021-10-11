package com.demo.whatShouldIEatTodayBackProto.controller.api;

import com.demo.whatShouldIEatTodayBackProto.dto.RecommendServiceReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;
import com.demo.whatShouldIEatTodayBackProto.service.RecommendationService;



@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api")
public class LocationController {

    private final RecommendationService recommendationService;

    @RequestMapping(value = "/recommend")
    public <T> String  routeToRecommendService(@RequestBody RecommendServiceReq<T> userData) {


        log.info(userData.getLongitude().toString());


        return "OK";
    }
}

