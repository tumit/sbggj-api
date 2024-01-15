package dev.isa.tumit.sbggjapi.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class ModelUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static <T> T copy(T o, Class<T> c) {
        return objectMapper.readValue(objectMapper.writeValueAsString(o), c);
    }
}
