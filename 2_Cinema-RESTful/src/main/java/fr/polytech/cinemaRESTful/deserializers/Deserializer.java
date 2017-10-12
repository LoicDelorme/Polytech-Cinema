package fr.polytech.cinemaRESTful.deserializers;

public interface Deserializer<I> {

    public <O> O from(I in, Class<O> clazz);
}