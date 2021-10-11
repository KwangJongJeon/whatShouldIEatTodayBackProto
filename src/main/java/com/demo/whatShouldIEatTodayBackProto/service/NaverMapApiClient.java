package com.demo.whatShouldIEatTodayBackProto.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Slf4j
@RequiredArgsConstructor
@Component
public class NaverMapApiClient {
    private final String CLIENT_ID = "zJX7BHjBpprA_7KTpoc8";
    private final String CLIENT_SECRET = "EiFd2L8aYt";

    public String searchPlace(String keyword) {

        final int SEARCH_RESULT_NUM_OF = 1;
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", CLIENT_ID);
        httpHeaders.add("X-Naver-Client-Secret", CLIENT_SECRET);


        String apiURL = "https://openapi.naver.com/v1/search/local.json?query="
                +keyword+"&display="+SEARCH_RESULT_NUM_OF+"&start=1";

        ResponseEntity<String> responseEntity = restTemplate.exchange(apiURL, HttpMethod.GET, new HttpEntity<String>(httpHeaders), String.class);

        return responseEntity.getBody();
    }


    public String getAddrFromGpsJsonResult(String latitude, String longitude) {
        log.info("Map API Address: {}, {}", latitude, longitude);

        RestTemplate restTemplate = new RestTemplate();

        // 헤더 세팅
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-NCP-APIGW-API-KEY-ID", CLIENT_ID);
        httpHeaders.add("X-NCP-APIGW-API-KEY", CLIENT_SECRET);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        String url = "https://naveropenapi.apigw.ntruss.com/map-reversegeocode/v2/gc?" +
                "coords="+longitude + "," + latitude;


        ResponseEntity<String> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET,
                new HttpEntity<String>(httpHeaders),
                String.class
        );

        return responseEntity.getBody();
    }

}
