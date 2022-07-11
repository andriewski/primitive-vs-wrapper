package by.mark.primitivevswrapper.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

import static java.util.Objects.requireNonNull;

public class BenchmarkUtils {

    static final String VALUES_WITHIN_BYTE_CACHE_JSON = readJson("object_with_values_within_byte_cache.json");
    static final String VALUES_EXCEEDED_BYTE_CACHE_JSON = readJson("object_with_values_exceeded_byte_cache.json");
    static final ObjectMapper MAPPER = new ObjectMapper();

    static final LotsOfWrappers LOTS_OF_WRAPPERS_WITHIN_BYTE_CACHE = readValue(VALUES_WITHIN_BYTE_CACHE_JSON, LotsOfWrappers.class);
    static final LotsOPrimitives LOTS_OF_PRIMITIVES_WITHIN_BYTE_CACHE = readValue(VALUES_WITHIN_BYTE_CACHE_JSON, LotsOPrimitives.class);

    static final LotsOfWrappers LOTS_OF_WRAPPERS_EXCEEDED_BYTE_CACHE = readValue(VALUES_EXCEEDED_BYTE_CACHE_JSON, LotsOfWrappers.class);
    static final LotsOPrimitives LOTS_OF_PRIMITIVES_EXCEEDED_BYTE_CACHE = readValue(VALUES_EXCEEDED_BYTE_CACHE_JSON, LotsOPrimitives.class);

    static String readJson(String fileName) {
        ClassLoader classLoader = PrimitiveVsWrapperDeserializationBenchmark.class.getClassLoader();

        try (InputStream is = requireNonNull(classLoader.getResourceAsStream(fileName))) {
            return new String(is.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static <T> T readValue(String json, Class<T> clazz) {
        try {
            return MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    static String writeValue(Object o) {
        try {
            return MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
