package fr.polytech.cinema.restful;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import fr.polytech.cinema.deserializers.Deserializer;
import fr.polytech.cinema.serializers.Serializer;

public abstract class AbstractRestfulRequester implements RestfulRequester {

    private final String baseUrl;

    private final Serializer<String> serializer;

    private final Deserializer<String> deserializer;

    private final Context context;

    public AbstractRestfulRequester(String baseUrl, Serializer<String> serializer, Deserializer<String> deserializer, Context context) {
        this.baseUrl = baseUrl;
        this.serializer = serializer;
        this.deserializer = deserializer;
        this.context = context;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public <T> T get(String resourcePath, TypeToken<T> responseType) throws Exception {
        return sendBasicRequest(resourcePath, Request.Method.GET, responseType);
    }

    public <T> T post(String resourcePath, Object object, TypeToken<T> responseType) throws Exception {
        return sendEnhancedRequest(resourcePath, Request.Method.POST, object, responseType);
    }

    public <T> T put(String resourcePath, Object object, TypeToken<T> responseType) throws Exception {
        return sendEnhancedRequest(resourcePath, Request.Method.PUT, object, responseType);
    }

    public <T> T delete(String resourcePath, TypeToken<T> responseType) throws Exception {
        return sendBasicRequest(resourcePath, Request.Method.DELETE, responseType);
    }

    private <T> T sendBasicRequest(String resourcePath, int httpMethod, TypeToken<T> responseType) throws ExecutionException, InterruptedException {
        final RequestQueue queue = Volley.newRequestQueue(this.context);
        final RequestFuture<String> future = RequestFuture.newFuture();
        final StringRequest request = new StringRequest(httpMethod, getBaseUrl() + resourcePath, future, future);
        queue.add(request);

        return this.deserializer.from(future.get(), responseType);
    }

    private <T> T sendEnhancedRequest(String resourcePath, int httpMethod, final Object object, TypeToken<T> responseType) throws ExecutionException, InterruptedException {
        final RequestQueue queue = Volley.newRequestQueue(this.context);
        final RequestFuture<String> future = RequestFuture.newFuture();
        final StringRequest request = new StringRequest(httpMethod, getBaseUrl() + resourcePath, future, future) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                return serializer.to(object).getBytes();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }
        };
        queue.add(request);

        return this.deserializer.from(future.get(), responseType);
    }
}