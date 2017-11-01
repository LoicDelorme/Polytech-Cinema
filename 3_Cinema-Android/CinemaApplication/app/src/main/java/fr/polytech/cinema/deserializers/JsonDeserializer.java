package fr.polytech.cinema.deserializers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonDeserializer implements Deserializer<String> {

    public static final Gson GSON_BUILDER = new GsonBuilder().serializeNulls().create();

    @Override
    public <O> O from(String in, TypeToken<O> typeToken) {
        return GSON_BUILDER.fromJson(in, typeToken.getType());
    }
}