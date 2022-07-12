package by.mark.primitivevswrapper.objectmapper.blackbird;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.blackbird.BlackbirdModule;

class BlackbirdBenchmarkUtils {

    static final ObjectMapper MAPPER = new ObjectMapper()
            .registerModule(new BlackbirdModule());

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
