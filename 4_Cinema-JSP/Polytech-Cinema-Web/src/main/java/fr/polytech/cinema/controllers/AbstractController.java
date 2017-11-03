package fr.polytech.cinema.controllers;

import java.util.logging.Logger;

import fr.polytech.cinema.deserializers.Deserializer;
import fr.polytech.cinema.deserializers.JsonDeserializer;
import fr.polytech.cinema.restful.JsonRestfulRequester;
import fr.polytech.cinema.restful.RestfulRequester;

public class AbstractController {

	public static final Logger LOGGER = Logger.getLogger(AbstractController.class.getSimpleName());

	public static final Deserializer<String> DESERIALIZER = new JsonDeserializer();

	public static final RestfulRequester RESTFUL_REQUESTER = new JsonRestfulRequester("http://localhost:8090/api/");
}