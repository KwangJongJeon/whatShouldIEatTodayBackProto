package com.demo.whatShouldIEatTodayBackProto.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

/** Jackson 라이브러리 활용한 Parser */
public class JsonParser {

    private static ObjectMapper mapper = getObjectMapper();

    private static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return mapper;
    }

    public static JsonNode parse(String src) throws JsonProcessingException {
        return mapper.readTree(src);
    }

    public static <E> E fromJson(JsonNode node, Class<E> classType) throws JsonProcessingException {
        return mapper.treeToValue(node, classType);
    }

    public JsonNode toJson(Object obj) {
        return mapper.valueToTree(obj);
    }

    public static String stringify(JsonNode node) throws JsonProcessingException {
        return generateString(node, false);
    }

    public static String prettyPrint(JsonNode node) throws JsonProcessingException {
        return generateString(node, true);
    }

    private static String generateString(JsonNode node, boolean pretty) throws JsonProcessingException {
        ObjectWriter writer = mapper.writer();
        if(pretty) {
            writer = writer.with(SerializationFeature.INDENT_OUTPUT);
        }

        return writer.writeValueAsString(node);
    }
}
