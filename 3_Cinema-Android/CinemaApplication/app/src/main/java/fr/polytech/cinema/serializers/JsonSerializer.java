package fr.polytech.cinema.serializers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonSerializer implements Serializer<String> {

    public static final Gson GSON_BUILDER = new GsonBuilder().serializeNulls().create();

    @Override
    public <I> String to(I in) {
        return GSON_BUILDER.toJson(in);
    }
}