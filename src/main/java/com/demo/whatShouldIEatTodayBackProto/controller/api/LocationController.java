package com.demo.whatShouldIEatTodayBackProto.controller.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.*;
import com.demo.whatShouldIEatTodayBackProto.service.RecommendationService;

import java.util.HashMap;
import java.util.Map;


@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api")
public class LocationController {

    private final RecommendationService recommendationService;

    @RequestMapping(value = "/recommend")
    public String  routeToRecommendService(@RequestBody HashMap<String, Object> userData) {

        String curLatitude = userData.get("_curLatitude").toString();
        String curLongitude = userData.get("_curLongitude").toString();

        log.info("curLatitude : {}", curLatitude);
        log.info("curLongitude : {}", curLongitude);

        recommendationService.test(curLatitude, curLongitude);
        return "OK";
    }
}

