package fr.polytech.cinemaRESTful.controllers;

import fr.polytech.cinemaRESTful.controllers.forms.CharacterForm;
import fr.polytech.cinemaRESTful.controllers.responses.SuccessResponse;
import fr.polytech.cinemaRESTful.entities.Character;
import fr.polytech.cinemaRESTful.entities.pks.CharacterPK;
import fr.polytech.cinemaRESTful.services.ActorDaoServices;
import fr.polytech.cinemaRESTful.services.CharacterDaoServices;
import fr.polytech.cinemaRESTful.services.MovieDaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/overview/{movieId}/{actorId}", method = RequestMethod.GET)
    public String overview(@PathVariable int movieId, @PathVariable int actorId) {
        final CharacterPK characterPK = new CharacterPK();
        characterPK.setActor(this.actorDaoServices.get(actorId));
        characterPK.setMovie(this.movieDaoServices.get(movieId));

        final Character character = this.characterDaoServices.get(characterPK);
        return SERIALIZER.to(new SuccessResponse(character));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        final List<Character> characters = this.characterDaoServices.getAll();
        return SERIALIZER.to(new SuccessResponse(characters));
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public String count() {
        return SERIALIZER.to(new SuccessResponse(this.characterDaoServices.count()));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody String data) {
        final CharacterForm characterForm = DESERIALIZER.from(data, CharacterForm.class);

        final Character character = new Character();
        character.setMovie(this.movieDaoServices.get(characterForm.getMovieId()));
        character.setActor(this.actorDaoServices.get(characterForm.getActorId()));
        character.setName(characterForm.getName());

        this.characterDaoServices.insert(character);
        return SERIALIZER.to(new SuccessResponse(character));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody String data) {
        final CharacterForm characterForm = DESERIALIZER.from(data, CharacterForm.class);

        final Character character = new Character();
        character.setMovie(this.movieDaoServices.get(characterForm.getMovieId()));
        character.setActor(this.actorDaoServices.get(characterForm.getActorId()));
        character.setName(characterForm.getName());

        this.characterDaoServices.update(character);
        return SERIALIZER.to(new SuccessResponse(character));
    }

    @RequestMapping(value = "/delete/{movieId}/{actorId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable int movieId, @PathVariable int actorId) {
        final CharacterPK characterPK = new CharacterPK();
        characterPK.setActor(this.actorDaoServices.get(actorId));
        characterPK.setMovie(this.movieDaoServices.get(movieId));

        final Character character = this.characterDaoServices.get(characterPK);
        this.characterDaoServices.delete(character);

        return SERIALIZER.to(new SuccessResponse(null));
    }
}