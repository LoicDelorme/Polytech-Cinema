package fr.polytech.cinema.restful;

import org.springframework.http.HttpHeaders;

import fr.polytech.cinema.serializers.JsonSerializer;

public class JsonRestfulRequester extends AbstractRestfulRequester {

    public JsonRestfulRequester(String baseUrl) {
        super(baseUrl, new JsonSerializer());
    }

    @Override
    public HttpHeaders getHeaders() {
        return new HttpHeaders();
    }
}