package by.mark.primitivevswrapper.objectmapper;

import by.mark.primitivevswrapper.objectmapper.blackbird.PrimitiveVsWrapperDeserializationBlackbirdBenchmarkByConstructor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

import static java.util.Objects.requireNonNull;

public class CommonFilesUtils {

    public static final String VALUES_WITHIN_BYTE_CACHE_JSON = readJson("object_with_values_within_byte_cache.json");
    public static final String VALUES_EXCEEDED_BYTE_CACHE_JSON = readJson("object_with_values_exceeded_byte_cache.json");

    public static final LotsOfWrappersByConstructor LOTS_OF_WRAPPERS_WITHIN_BYTE_CACHE =
            readValue(VALUES_WITHIN_BYTE_CACHE_JSON, LotsOfWrappersByConstructor.class);

    public static final LotsOPrimitivesByConstructor LOTS_OF_PRIMITIVES_WITHIN_BYTE_CACHE =
            readValue(VALUES_WITHIN_BYTE_CACHE_JSON, LotsOPrimitivesByConstructor.class);

    public static final LotsOfWrappersByConstructor LOTS_OF_WRAPPERS_EXCEEDED_BYTE_CACHE =
            readValue(VALUES_EXCEEDED_BYTE_CACHE_JSON, LotsOfWrappersByConstructor.class);

    public static final LotsOPrimitivesByConstructor LOTS_OF_PRIMITIVES_EXCEEDED_BYTE_CACHE =
            readValue(VALUES_EXCEEDED_BYTE_CACHE_JSON, LotsOPrimitivesByConstructor.class);

    private static String readJson(String fileName) {
        ClassLoader classLoader = PrimitiveVsWrapperDeserializationBlackbirdBenchmarkByConstructor.class.getClassLoader();

        try (InputStream is = requireNonNull(classLoader.getResourceAsStream(fileName))) {
            return new String(is.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> T readValue(String json, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
