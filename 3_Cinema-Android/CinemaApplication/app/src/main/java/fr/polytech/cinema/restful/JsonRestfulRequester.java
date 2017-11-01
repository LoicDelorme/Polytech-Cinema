package fr.polytech.cinema.restful;

import android.content.Context;

import fr.polytech.cinema.deserializers.JsonDeserializer;
import fr.polytech.cinema.serializers.JsonSerializer;

public class JsonRestfulRequester extends AbstractRestfulRequester {

    public JsonRestfulRequester(String baseUrl, Context context) {
        super(baseUrl, new JsonSerializer(), new JsonDeserializer(), context);
    }
}