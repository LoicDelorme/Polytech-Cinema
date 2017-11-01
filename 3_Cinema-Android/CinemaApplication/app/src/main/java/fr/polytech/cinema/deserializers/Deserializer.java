package fr.polytech.cinema.deserializers;

import com.google.gson.reflect.TypeToken;

public interface Deserializer<I> {

    public <O> O from(I in, TypeToken<O> typeToken);
}