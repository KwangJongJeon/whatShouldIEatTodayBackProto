package com.demo.whatShouldIEatTodayBackProto.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Slf4j
@RequiredArgsConstructor
@Component
public class MapApiClient {
    private final String CLIENT_ID = "38z32bcgcb";
    private final String CLIENT_SECRET = "ICjBduivJboH2iDSs0KhI0vSCzGv3RZvEr3kugmw";

    public ResponseEntity<String> getAddrFromGpsJsonResult(String latitude, String longitude) {
        log.info("Map API Address: {}, {}", latitude, longitude);

        RestTemplate restTemplate = new RestTemplate();

        // 헤더 세팅
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-NCP-APIGW-API-KEY-ID", CLIENT_ID);
        httpHeaders.add("X-NCP-APIGW-API-KEY", CLIENT_SECRET);

        String url = "https://naveropenapi.apigw.ntruss.com/map-reversegeocode/v2/gc?" +
                "coords="+longitude + "," + latitude;



        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(httpHeaders), String.class);

    }

}
