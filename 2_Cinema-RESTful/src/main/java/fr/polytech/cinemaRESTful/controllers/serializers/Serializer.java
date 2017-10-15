package fr.polytech.cinemaRESTful.controllers.serializers;

public interface Serializer<O> {

    public <I> O to(I in);
}