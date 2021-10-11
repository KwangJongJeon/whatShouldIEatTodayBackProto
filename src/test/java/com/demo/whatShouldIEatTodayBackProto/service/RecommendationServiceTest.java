package com.demo.whatShouldIEatTodayBackProto.service;

import com.demo.whatShouldIEatTodayBackProto.dto.RecommendServiceReq;
import com.demo.whatShouldIEatTodayBackProto.dto.ResponseDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class RecommendationServiceTest {

    @Autowired
    RecommendationService recommendationService;

    @Test
    @DisplayName("정상적으로 위도가 계산된다")
    void calculateRadius() {
        double distanceInput = 1000;
        double latitude = 36.3376482;
        final double EXPECTED_LATITUDE = Math.abs(latitude - 36.3378051);

        double returnValue = recommendationService.calculateRadius(distanceInput, latitude);

        assertThat(returnValue).isEqualTo(EXPECTED_LATITUDE);
    }

    @Test
    @DisplayName("정상적으로 RecommendationService가 작동된다.")
    void getLocalRestaurantDataFromKaKaoAPI() {
        RecommendServiceReq<String> recommendServiceReq = new RecommendServiceReq<>();
        List<String> categories = new LinkedList<>();
        categories.add("ChineseFood");
        categories.add("JapaneseFood");

        recommendServiceReq.setCategories(categories);
        recommendServiceReq.setLatitude("36.3376482");
        recommendServiceReq.setLongitude("127.3933957");
        recommendServiceReq.setRange("1000");

        ResponseDocument responseDocument = recommendationService.recommendationService(recommendServiceReq);
        System.out.println(responseDocument.toString());

        assertThat(responseDocument).isNotNull();
    }
}