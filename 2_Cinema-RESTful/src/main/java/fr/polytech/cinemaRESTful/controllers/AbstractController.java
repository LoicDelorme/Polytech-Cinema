package fr.polytech.cinemaRESTful.controllers;

import fr.polytech.cinemaRESTful.deserializers.Deserializer;
import fr.polytech.cinemaRESTful.deserializers.JsonDeserializer;
import fr.polytech.cinemaRESTful.serializers.JsonSerializer;
import fr.polytech.cinemaRESTful.serializers.Serializer;

public abstract class AbstractController {

    public static final Serializer<String> SERIALIZER = new JsonSerializer();

    public static final Deserializer<String> DESERIALIZER = new JsonDeserializer();
}