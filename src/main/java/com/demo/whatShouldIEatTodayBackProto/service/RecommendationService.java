package com.demo.whatShouldIEatTodayBackProto.service;

import com.demo.whatShouldIEatTodayBackProto.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class RecommendationService {

    private final KakaoClient kakaoClient;

    public void test(String latitude, String longitude) {
        log.info("test API Address: {}, {}", latitude, longitude);
//        ResponseEntity<String> res = mapApiClient.getAddrFromGpsJsonResult(latitude, longitude);
//        log.info(res.getBody());
    }

    public <T> ResponseDocument recommendationService(RecommendServiceReq<T> recommendServiceReq) {

        ArrayList<ResponseDocument> restaurantDocuments = getLocalRestaurantDataFromKakaoAPI(recommendServiceReq);
        return getRandomRestaurantDocument(restaurantDocuments);
    }

    private ArrayList<ResponseDocument> getLocalRestaurantDataFromKakaoAPI(RecommendServiceReq recommendServiceReq) {

        ArrayList<ResponseDocument> resultDocuments = new ArrayList<>();
        ResponseMeta responseMeta = new ResponseMeta();

        String query = selectCategoryRandomly(recommendServiceReq.getCategories());
        String x = recommendServiceReq.getLongitude().toString();
        String y = recommendServiceReq.getLatitude().toString();
        String radius = recommendServiceReq.getRange().toString();


        int page = 1;

        while(!responseMeta.is_end() && page < 10) {
            SearchLocalReq searchLocalReq = new SearchLocalReq(query, x, y, radius);
            searchLocalReq.setPage(page++);
            SearchLocalRes searchLocalRes = kakaoClient.localSearch(searchLocalReq);


            resultDocuments.addAll(searchLocalRes.getDocuments());


            responseMeta = searchLocalRes.getMeta();
        }

        return resultDocuments;
    }

    private ResponseDocument getRandomRestaurantDocument(List<ResponseDocument> responseDocumentList) {
        int randomValue = (int)(Math.random()*responseDocumentList.size());

        return responseDocumentList.get(randomValue);
    }

    private <T> String selectCategoryRandomly(List<T> categories) {
        int randomValue = (int)(Math.random()*categories.size());

        String category = categories.get(randomValue).toString();

        switch (category) {
            case "KoreanFood":
                return "한식";
            case "JapaneseFood":
                return "일식";
            case "ChineseFood":
                return "중식";
            default:
                return "";
        }
    }

    public double calculateRadius(double distanceInput, double latitude) {

        final double EARTH_RADIUS =  6371009;
        final double DISTANCE = distanceInput;

        final double LATITUDE_CENTER = latitude;

        // longitude의 차이가 없을 때 원의 중심으로부터 DISTANCE 만큼 떨어져있는 위치의 경도
        double latitudeOther = DISTANCE/EARTH_RADIUS + LATITUDE_CENTER;

        // 여덟번째 소숫점 버림
        double roundedLatitude = Math.floor(latitudeOther*10000000)/10000000.0;

        final double radius = Math.abs(latitude - roundedLatitude);

        return radius;
    }

}
