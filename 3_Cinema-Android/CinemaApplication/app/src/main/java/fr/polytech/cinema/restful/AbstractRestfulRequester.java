package fr.polytech.cinema.restful;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import fr.polytech.cinema.serializers.Serializer;

public abstract class AbstractRestfulRequester implements IRestfulRequester {

    private final String baseUrl;

    private final RestTemplate restTemplate;

    private final Serializer<String> serializer;

    public AbstractRestfulRequester(String baseUrl, Serializer<String> serializer) {
        this.baseUrl = baseUrl;
        this.restTemplate = new RestTemplate();
        this.serializer = serializer;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public <T> T get(String resourcePath, Class<T> responseType) {
        return execute(resourcePath, HttpMethod.GET, responseType).getBody();
    }

    public <T> T head(String resourcePath, Class<T> responseType) {
        return execute(resourcePath, HttpMethod.HEAD, responseType).getBody();
    }

    public <T> T post(String resourcePath, Object object, Class<T> responseType) {
        return execute(resourcePath, HttpMethod.POST, this.serializer.to(object), responseType).getBody();
    }

    public <T> T put(String resourcePath, Object object, Class<T> responseType) {
        return execute(resourcePath, HttpMethod.PUT, this.serializer.to(object), responseType).getBody();
    }

    public <T> T delete(String resourcePath, Class<T> responseType) {
        return execute(resourcePath, HttpMethod.DELETE, responseType).getBody();
    }

    public <T> T options(String resourcePath, Class<T> responseType) {
        return execute(resourcePath, HttpMethod.OPTIONS, responseType).getBody();
    }

    public <T> T trace(String resourcePath, Class<T> responseType) {
        return execute(resourcePath, HttpMethod.TRACE, responseType).getBody();
    }

    public <T> T patch(String resourcePath, Object object, Class<T> responseType) {
        return execute(resourcePath, HttpMethod.PATCH, this.serializer.to(object), responseType).getBody();
    }

    private <T> ResponseEntity<T> execute(String resourcePath, HttpMethod httpMethod, Class<T> responseType) {
        return execute(resourcePath, httpMethod, "", responseType);
    }

    private <T> ResponseEntity<T> execute(String resourcePath, HttpMethod httpMethod, String requestBody, Class<T> responseType) {
        return restTemplate.exchange(getBaseUrl() + resourcePath, httpMethod, new HttpEntity<String>(requestBody, getHeaders()), responseType);
    }
}