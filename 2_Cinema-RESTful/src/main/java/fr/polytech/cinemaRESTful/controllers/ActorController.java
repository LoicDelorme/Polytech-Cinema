package fr.polytech.cinemaRESTful.controllers;

import fr.polytech.cinemaRESTful.controllers.forms.ActorForm;
import fr.polytech.cinemaRESTful.controllers.responses.SuccessResponse;
import fr.polytech.cinemaRESTful.entities.Actor;
import fr.polytech.cinemaRESTful.services.ActorDaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/actor")
public class ActorController extends AbstractController {

    @Autowired
    private ActorDaoServices actorDaoServices;

    @RequestMapping(value = "/overview/{id}", method = RequestMethod.GET)
    public String overview(@PathVariable int id) {
        final Actor actor = this.actorDaoServices.get(id);
        return SERIALIZER.to(new SuccessResponse(actor));
    }

    @RequestMapping(value = "overview/{id}/characters", method = RequestMethod.GET)
    public String charactersOverview(@PathVariable int id) {
        final Actor actor = this.actorDaoServices.get(id);
        return SERIALIZER.to(new SuccessResponse(actor.getCharacters()));
    }

    @RequestMapping(value = "overview/{id}/movies", method = RequestMethod.GET)
    public String moviesOverview(@PathVariable int id) {
        final Actor actor = this.actorDaoServices.get(id);
        return SERIALIZER.to(new SuccessResponse(actor.getMovies()));
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String filter(@RequestBody String data) {
        final Map<String, String> parameters = DESERIALIZER.from(data, HashMap.class);

        final List<Actor> actors = this.actorDaoServices.filter(parameters);
        return SERIALIZER.to(new SuccessResponse(actors));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        final List<Actor> actors = this.actorDaoServices.getAll();
        return SERIALIZER.to(new SuccessResponse(actors));
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public String count() {
        return SERIALIZER.to(new SuccessResponse(this.actorDaoServices.count()));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody String data) {
        final ActorForm actorForm = DESERIALIZER.from(data, ActorForm.class);

        final Actor actor = new Actor();
        actor.setLastname(actorForm.getLastname());
        actor.setFirstname(actorForm.getFirstname());
        actor.setBirthDate(actorForm.getBirthDate());
        actor.setDateOfDeath(actorForm.getDateOfDeath());

        this.actorDaoServices.insert(actor);
        return SERIALIZER.to(new SuccessResponse(actor));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody String data) {
        final ActorForm actorForm = DESERIALIZER.from(data, ActorForm.class);

        final Actor actor = new Actor();
        actor.setId(actorForm.getId());
        actor.setLastname(actorForm.getLastname());
        actor.setFirstname(actorForm.getFirstname());
        actor.setBirthDate(actorForm.getBirthDate());
        actor.setDateOfDeath(actorForm.getDateOfDeath());

        this.actorDaoServices.update(actor);
        return SERIALIZER.to(new SuccessResponse(actor));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        final Actor actor = this.actorDaoServices.get(id);
        this.actorDaoServices.delete(actor);
    }
}