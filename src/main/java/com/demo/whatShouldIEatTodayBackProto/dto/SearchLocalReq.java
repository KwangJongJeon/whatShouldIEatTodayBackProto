package com.demo.whatShouldIEatTodayBackProto.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;

/**
 * 2021-10-09
 * 객체 생성시 아래의 파라미터들은 만드는 앱에서 필수로 들어가야 합니다.
 * query, x, y, radius
 * 쿼리문을 저장하는 dto
 * Request parameter들은 https://developers.kakao.com/docs/latest/ko/local/dev-guide#search-by-keyword를 참고했습니다.
 */
@RequiredArgsConstructor
@Getter @Setter
public class SearchLocalReq {

    private final String query; // 검색을 원하는 질의어
    private final String x; // 중심좌표의 x값 혹은 longitude, 특정 지역을 중심으로 검색하려고 할 경우 radius와 함께 사용
    private final String y; // 중심좌표의 y값 혹은 latitude
    private final String radius; // 중심 좌표로부터의 반경거리, 단위 meter 0~20000사이의 값
    private String categoryGroupCode; // 카테고리 그룹 코드, 결과를 카테고리로 필터링을 원하는 경우 사용
    private String rect; // 사각형 범위 내에서 제한 검색을 위한 좌표, 좌측 X좌표, 좌측 Y좌표, 우측X 좌표, 우측 Y좌표 형식
    private String page; // 결과 페이지 번호 1~45 사이의 값
    private String size; // 한 페이지에 보여질 문서의 개수 1~15사이의 값
    private String sort; // 결과 정렬 순서 distance 혹은 accuracy


    public MultiValueMap<String, String> makeMultiValueMap() {
        LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        map.add("query", query);
        map.add("x", x);
        map.add("y", y);
        map.add("radius", radius);

        if(rect != null) {
            map.add("rect", rect);
        }

        if(page != null) {
            map.add("page", String.valueOf(page));
        }

        if(size != null) {
            map.add("size", String.valueOf(size));
        }

        if(sort != null) {
            map.add("sort", sort);
        }

        if(categoryGroupCode != null) {
            map.add("sort", sort);
        }


        return map;
    }
}
