package by.mark.primitivevswrapper.objectmapper;

import by.mark.primitivevswrapper.objectmapper.blackbird.PrimitiveVsWrapperDeserializationBlackbirdBenchmark;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

import static java.util.Objects.requireNonNull;

public class CommonFilesUtils {

    public static final String VALUES_WITHIN_BYTE_CACHE_JSON = readJson("object_with_values_within_byte_cache.json");
    public static final String VALUES_EXCEEDED_BYTE_CACHE_JSON = readJson("object_with_values_exceeded_byte_cache.json");

    public static final LotsOfWrappers LOTS_OF_WRAPPERS_WITHIN_BYTE_CACHE =
            readValue(VALUES_WITHIN_BYTE_CACHE_JSON, LotsOfWrappers.class);

    public static final LotsOPrimitives LOTS_OF_PRIMITIVES_WITHIN_BYTE_CACHE =
            readValue(VALUES_WITHIN_BYTE_CACHE_JSON, LotsOPrimitives.class);

    public static final LotsOfWrappers LOTS_OF_WRAPPERS_EXCEEDED_BYTE_CACHE =
            readValue(VALUES_EXCEEDED_BYTE_CACHE_JSON, LotsOfWrappers.class);

    public static final LotsOPrimitives LOTS_OF_PRIMITIVES_EXCEEDED_BYTE_CACHE =
            readValue(VALUES_EXCEEDED_BYTE_CACHE_JSON, LotsOPrimitives.class);

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static String readJson(String fileName) {
        ClassLoader classLoader = PrimitiveVsWrapperDeserializationBlackbirdBenchmark.class.getClassLoader();

        try (InputStream is = requireNonNull(classLoader.getResourceAsStream(fileName))) {
            return new String(is.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> T readValue(String json, Class<T> clazz) {
        try {
            return MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
