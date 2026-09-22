package org.TripScheduleSerialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class TripJsonSerializer {

    private static final ObjectMapper objectMapper = new ObjectMapper();


    public static String toJson(List<Trip> trips)
            throws JsonProcessingException {

        return objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(trips);
    }


    public static List<Trip> fromJson(String json)
            throws JsonProcessingException {

        return objectMapper.readValue(
                json,
                new TypeReference<List<Trip>>() {}
        );
    }
}

