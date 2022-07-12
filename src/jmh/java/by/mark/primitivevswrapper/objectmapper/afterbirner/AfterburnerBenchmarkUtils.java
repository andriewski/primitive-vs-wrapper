package by.mark.primitivevswrapper.objectmapper.afterbirner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;

class AfterburnerBenchmarkUtils {

    static final ObjectMapper MAPPER = new ObjectMapper()
            .registerModule(new AfterburnerModule());

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
