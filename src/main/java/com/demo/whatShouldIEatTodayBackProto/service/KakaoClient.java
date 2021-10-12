package com.demo.whatShouldIEatTodayBackProto.service;


import com.demo.whatShouldIEatTodayBackProto.dto.SearchLocalReq;
import com.demo.whatShouldIEatTodayBackProto.dto.SearchLocalRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class KakaoClient {

    @Value("${kakao.secret.restAPIKey}")
    private String kakaoRestAPIKey;

    @Value("${kakao.url.search.local}")
    private String kakaoLocalSearchUrl;

    public SearchLocalRes localSearch(SearchLocalReq searchLocalReq) {
        URI uri = UriComponentsBuilder
                .fromUriString(kakaoLocalSearchUrl)
                .queryParams(searchLocalReq.makeMultiValueMap())
                .build()
                .encode()
                .toUri();



        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", kakaoRestAPIKey);

        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
        ParameterizedTypeReference<SearchLocalRes> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<SearchLocalRes> responseEntity = new RestTemplate()
                .exchange(
                        uri,
                        HttpMethod.GET,
                        httpEntity,
                        responseType
                );


        return responseEntity.getBody();
    }
}
