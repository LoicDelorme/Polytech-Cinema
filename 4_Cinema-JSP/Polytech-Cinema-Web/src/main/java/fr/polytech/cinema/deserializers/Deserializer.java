package fr.polytech.cinema.deserializers;

public interface Deserializer<I> {

	public <O> O from(I in, Class<O> clazz);
}