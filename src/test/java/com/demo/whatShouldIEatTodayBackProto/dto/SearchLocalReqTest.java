package com.demo.whatShouldIEatTodayBackProto.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;


class SearchLocalReqTest {

    @Test
    @DisplayName("매핑이 정상적으로 진행됩니다.")
    void MappingIsWorkProperly() {
        String query = "한식";
        String x = "1";
        String y = "1";
        String radius = "1000";

        SearchLocalReq searchLocalReq = new SearchLocalReq(query, x, y, radius);
        LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        map.add("query", query);
        map.add("x", x);
        map.add("y", y);
        map.add("radius", radius);

        Assertions.assertThat(searchLocalReq.makeMultiValueMap()).isEqualTo(map);
    }

    @Test
    @DisplayName("매핑 변수 추가가 정상적으로 진행됩니다.")
    void AddMappingValueWorkProperly() {
        String query = "한식";
        String x = "1";
        String y = "1";
        String radius = "1000";
        int page = 10;

        SearchLocalReq searchLocalReq = new SearchLocalReq(query, x, y, radius);
        searchLocalReq.setPage(page);

        LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("query", query);
        map.add("x", x);
        map.add("y", y);
        map.add("radius", radius);
        map.add("page", String.valueOf(page));

        Assertions.assertThat(searchLocalReq.makeMultiValueMap()).isEqualTo(map);
    }
}