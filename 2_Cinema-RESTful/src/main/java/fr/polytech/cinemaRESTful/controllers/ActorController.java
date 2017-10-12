package fr.polytech.cinemaRESTful.controllers;

import fr.polytech.cinemaRESTful.entities.Actor;
import fr.polytech.cinemaRESTful.forms.ActorForm;
import fr.polytech.cinemaRESTful.services.ActorDaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/actor")
public class ActorController extends AbstractController {

    @Autowired
    private ActorDaoServices actorDaoServices;

    @RequestMapping(value = "/overview", method = RequestMethod.POST)
    public String overview(@RequestBody String data) {
        final ActorForm actorForm = DESERIALIZER.from(data, ActorForm.class);
        return SERIALIZER.to(this.actorDaoServices.get(actorForm.getId()));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return SERIALIZER.to(this.actorDaoServices.getAll());
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
        return SERIALIZER.to(actor);
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
        return SERIALIZER.to(actor);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody String data) {
        final ActorForm actorForm = DESERIALIZER.from(data, ActorForm.class);
        this.actorDaoServices.delete(this.actorDaoServices.get(actorForm.getId()));
    }
}