package fr.polytech.cinema.serializers;

public interface Serializer<O> {

	public <I> O to(I in);
}