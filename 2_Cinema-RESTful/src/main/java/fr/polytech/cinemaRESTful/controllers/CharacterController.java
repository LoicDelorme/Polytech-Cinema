package fr.polytech.cinemaRESTful.controllers;

import fr.polytech.cinemaRESTful.entities.Character;
import fr.polytech.cinemaRESTful.entities.pks.CharacterPK;
import fr.polytech.cinemaRESTful.forms.CharacterForm;
import fr.polytech.cinemaRESTful.services.ActorDaoServices;
import fr.polytech.cinemaRESTful.services.CharacterDaoServices;
import fr.polytech.cinemaRESTful.services.MovieDaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/character")
public class CharacterController extends AbstractController {

    @Autowired
    private CharacterDaoServices characterDaoServices;

    @Autowired
    private MovieDaoServices movieDaoServices;

    @Autowired
    private ActorDaoServices actorDaoServices;

    @RequestMapping(value = "/overview", method = RequestMethod.POST)
    public String overview(@RequestBody String data) {
        final CharacterForm characterForm = DESERIALIZER.from(data, CharacterForm.class);

        final CharacterPK characterPK = new CharacterPK();
        characterPK.setActor(this.actorDaoServices.get(characterForm.getActorId()));
        characterPK.setMovie(this.movieDaoServices.get(characterForm.getMovieId()));

        return SERIALIZER.to(this.characterDaoServices.get(characterPK));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return SERIALIZER.to(this.characterDaoServices.getAll());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody String data) {
        final CharacterForm characterForm = DESERIALIZER.from(data, CharacterForm.class);
        final Character character = new Character();
        character.setMovie(this.movieDaoServices.get(characterForm.getMovieId()));
        character.setActor(this.actorDaoServices.get(characterForm.getActorId()));
        character.setName(characterForm.getName());

        this.characterDaoServices.insert(character);
        return SERIALIZER.to(character);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody String data) {
        final CharacterForm characterForm = DESERIALIZER.from(data, CharacterForm.class);
        final Character character = new Character();
        character.setMovie(this.movieDaoServices.get(characterForm.getMovieId()));
        character.setActor(this.actorDaoServices.get(characterForm.getActorId()));
        character.setName(characterForm.getName());

        this.characterDaoServices.update(character);
        return SERIALIZER.to(character);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody String data) {
        final CharacterForm characterForm = DESERIALIZER.from(data, CharacterForm.class);

        final CharacterPK characterPK = new CharacterPK();
        characterPK.setActor(this.actorDaoServices.get(characterForm.getActorId()));
        characterPK.setMovie(this.movieDaoServices.get(characterForm.getMovieId()));

        this.characterDaoServices.delete(this.characterDaoServices.get(characterPK));
    }
}