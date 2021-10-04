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

}
