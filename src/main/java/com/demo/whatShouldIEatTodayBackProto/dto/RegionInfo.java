package com.demo.whatShouldIEatTodayBackProto.dto;

import lombok.Getter;
import lombok.Setter;

/** 카카오 API의 응답의 meta 데이터 중 same_name 파라미터를 표기하기 위한 객체입니다. */
@Getter @Setter
public class RegionInfo {
    private String[] region;
    private String keyword;
    private String selected_region;
}
