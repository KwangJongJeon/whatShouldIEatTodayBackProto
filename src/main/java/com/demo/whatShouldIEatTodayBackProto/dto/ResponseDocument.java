package com.demo.whatShouldIEatTodayBackProto.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Kakao API로부터 받은 상점의 주요 정보를 저장하는 DTO
 * API의 규격에 따라 camelCase로 쓴게 아니라 언더바 표기법을 사용하였습니다.
 */
@Data
public class ResponseDocument {

    // document
    private String id; // 장소 id
    private String place_name; // 장소명, 업체명
    private String category_name; // 카테고리 이름
    private String category_group_code; // 중요 카테고리만 그룹핑한 카테고리 그룹 코드
    private String category_group_name; // 중요 카테고리만 그룹핑한 카테고리 그룹 명
    private String phone; // 전화 번호
    private String address_name; // 전체 지번 주소
    private String road_address_name; // 전체 도로명 주소
    private String x; // X좌표 값, 경위도인 경우 longitude(경도)
    private String y; // Y좌표 값, 경위도인 경우 latitude(위도)
    private String place_url; // 장소 상세페이지 URL
    private String distance; // 중심좌표까지의 거리(단 x, y 파라미터를 준 경우에만 존재) 단위: meter
}
