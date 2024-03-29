package fr.polytech.cinemaRESTful.controllers;

import fr.polytech.cinemaRESTful.controllers.deserializers.Deserializer;
import fr.polytech.cinemaRESTful.controllers.deserializers.JsonDeserializer;
import fr.polytech.cinemaRESTful.controllers.serializers.JsonSerializer;
import fr.polytech.cinemaRESTful.controllers.serializers.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractController {

    public static final Logger LOGGER = LoggerFactory.getLogger(AbstractController.class);

    public static final Serializer<String> SERIALIZER = new JsonSerializer();

    public static final Deserializer<String> DESERIALIZER = new JsonDeserializer();
}