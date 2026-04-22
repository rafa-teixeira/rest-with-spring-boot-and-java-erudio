package br.com.erudio.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class GenderSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String gender, JsonGenerator gen,
                          SerializerProvider serializers) throws IOException {
        String formatedGender = "Female".equals(gender) ? "F" : "M";
        gen.writeString(formatedGender);
    }
}
