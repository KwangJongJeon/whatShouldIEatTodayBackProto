package com.demo.whatShouldIEatTodayBackProto.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class RecommendServiceReq <T> {
    public  T latitude;
    private T longitude;
    private T range;
    private List<T> categories;
}
