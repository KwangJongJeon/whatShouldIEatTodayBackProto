package com.demo.whatShouldIEatTodayBackProto.dto;


public class ResponseMeta {
    private int total_count; // 검색된 문서 수
    private int pageable_count; // total_count 중 노출 가능 문서 수
    private boolean is_end; // 현재 페이지가 마지막 페이지인지 여부, 값이 false면 page를 증가시켜 다음 페이지를 요청 할 수 있음
    private RegionInfo same_number; // 질의어의 지역 및 키워드 분석 정보
}
