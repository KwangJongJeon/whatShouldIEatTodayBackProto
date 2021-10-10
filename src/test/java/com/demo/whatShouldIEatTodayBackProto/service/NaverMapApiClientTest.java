package com.demo.whatShouldIEatTodayBackProto.service;

import org.junit.jupiter.api.Test;

class NaverMapApiClientTest {

    NaverMapApiClient naverMapApiClient = new NaverMapApiClient();

    @Test
    void searchPlace() {
        // given
        String keyword = "갈비집";
        String val = naverMapApiClient.searchPlace(keyword);

        // when
        System.out.println(val);

        // then
    }
}