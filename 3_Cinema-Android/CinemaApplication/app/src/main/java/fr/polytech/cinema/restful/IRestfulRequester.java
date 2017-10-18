package fr.polytech.cinema.restful;

import org.springframework.http.HttpHeaders;

public interface IRestfulRequester {

    public String getBaseUrl();

    public HttpHeaders getHeaders();

    public <T> T get(String resourcePath, Class<T> responseType);

    public <T> T head(String resourcePath, Class<T> responseType);

    public <T> T post(String resourcePath, Object object, Class<T> responseType);

    public <T> T put(String resourcePath, Object object, Class<T> responseType);

    public <T> T delete(String resourcePath, Class<T> responseType);

    public <T> T options(String resourcePath, Class<T> responseType);

    public <T> T trace(String resourcePath, Class<T> responseType);

    public <T> T patch(String resourcePath, Object object, Class<T> responseType);
}