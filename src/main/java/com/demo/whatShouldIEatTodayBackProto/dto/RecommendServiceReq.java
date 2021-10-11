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

//    public MultiValueMap<String, T> getMultiValueMap() {
//        LinkedMultiValueMap<String, T> map = new LinkedMultiValueMap<>();
//
//        map.add("latitude", latitude);
//        map.add("longitude", longitude);
//        map.add("range", range);
//        for (T category : categories) {
//            map.add("categories", category);
//        }
//
//        return map;
//    }

}
