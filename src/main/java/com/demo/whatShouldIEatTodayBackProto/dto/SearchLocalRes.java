package com.demo.whatShouldIEatTodayBackProto.dto;

import lombok.Getter;

import java.util.List;

/**
 * 2021-10-10
 * 카카오에서 받아온 Response를 저장하는 객체
 * 쿼리 파라미터들은 밑의 사이트에서 참고했습니다.
 * https://developers.kakao.com/docs/latest/ko/local/dev-guide#search-by-keyword
 * API의 규격에 따라 camelCase로 쓴게 아니라 언더바 표기법을 사용하였습니다.
 */
@Getter
public class SearchLocalRes {

    private ResponseMeta meta;
    private List<ResponseDocument> documents;

}
