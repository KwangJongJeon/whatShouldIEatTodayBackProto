package com.demo.whatShouldIEatTodayBackProto.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class RecommendationService {
    private final MapApiClient mapApiClient;

    public void test(String latitude, String longitude) {
        log.info("test API Address: {}, {}", latitude, longitude);
        ResponseEntity<String> res = mapApiClient.getAddrFromGpsJsonResult(latitude, longitude);
        log.info(res.getBody());
    }

    public double calculateRadius(double distanceInput, double latitude) {
        final double EARTH_RADIUS =  6371009;
        final double DISTANCE = distanceInput;

        final double LATITUDE_CENTER = latitude;

        // longitude의 차이가 없을 때 원의 중심으로부터 DISTANCE 만큼 떨어져있는 위치의 경도
        double latitudeOther = DISTANCE/EARTH_RADIUS + LATITUDE_CENTER;

        // 여덟번째 소숫점 버림
        double roundedLatitude = Math.floor(latitudeOther*10000000)/10000000.0;

        final double radius = Math.abs(latitude - roundedLatitude);

        return radius;
    }

}
