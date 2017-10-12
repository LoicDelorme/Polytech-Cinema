package fr.polytech.cinemaRESTful.serializers;

public interface Serializer<O> {

    public <I> O to(I in);
}