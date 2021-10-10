package com.demo.whatShouldIEatTodayBackProto.dto;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KakaoClient {

    @Value("${kakao.secret.restAPIKey}")
    private String kakaoRestAPIKey;

    @Value("${kakao.url.search.local}")
    private String kakaoLocalSearchUrl;

    public String getKakaoRestAPIKey() {
        return kakaoRestAPIKey;
    }

    public void setKakaoRestAPIKey(String kakaoRestAPIKey) {
        this.kakaoRestAPIKey = kakaoRestAPIKey;
    }

    public String getKakaoLocalSearchUrl() {
        return kakaoLocalSearchUrl;
    }

    public void setKakaoLocalSearchUrl(String kakaoLocalSearchUrl) {
        this.kakaoLocalSearchUrl = kakaoLocalSearchUrl;
    }
}
