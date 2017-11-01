package fr.polytech.cinema.restful;

import com.google.gson.reflect.TypeToken;

public interface RestfulRequester {

    public String getBaseUrl();

    public <T> T get(String resourcePath, TypeToken<T> responseType) throws Exception;

    public <T> T post(String resourcePath, Object object, TypeToken<T> responseType) throws Exception;

    public <T> T put(String resourcePath, Object object, TypeToken<T> responseType) throws Exception;

    public <T> T delete(String resourcePath, TypeToken<T> responseType) throws Exception;
}