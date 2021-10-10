package com.demo.whatShouldIEatTodayBackProto.dto;

import com.demo.whatShouldIEatTodayBackProto.service.KakaoClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class KakaoClientTest {

    @Autowired
    KakaoClient kakaoClient;

    String latitude = "36.3376482";
    String longitude = "127.3933957";
    String radius = "2000";

    @Test
    @DisplayName("searchLocalRes 객체에 Api에서 받아온 값이 저장된다.")
    void localSearch()  {
        SearchLocalReq searchLocalReq = new SearchLocalReq("한식", longitude, latitude, radius);
        SearchLocalRes searchLocalRes = kakaoClient.localSearch(searchLocalReq);
        Assertions.assertThat(searchLocalRes).isNotNull();
    }
}