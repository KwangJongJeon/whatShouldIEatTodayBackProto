package com.demo.whatShouldIEatTodayBackProto.controller.api;

import com.demo.whatShouldIEatTodayBackProto.dto.RecommendServiceReq;
import com.demo.whatShouldIEatTodayBackProto.dto.ResponseDocument;
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
    public <T> ResponseDocument  routeToRecommendService(@RequestBody RecommendServiceReq<T> userData) {

        return recommendationService.recommendationService(userData);
    }
}

