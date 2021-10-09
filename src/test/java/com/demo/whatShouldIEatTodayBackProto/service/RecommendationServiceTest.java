package com.demo.whatShouldIEatTodayBackProto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;




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

        Assertions.assertThat(returnValue).isEqualTo(EXPECTED_LATITUDE);
    }
}