package fr.polytech.cinemaRESTful.controllers;

import fr.polytech.cinemaRESTful.controllers.forms.DirectorForm;
import fr.polytech.cinemaRESTful.controllers.responses.SuccessResponse;
import fr.polytech.cinemaRESTful.entities.Director;
import fr.polytech.cinemaRESTful.services.DirectorDaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/director")
public class DirectorController extends AbstractController {

    @Autowired
    private DirectorDaoServices directorDaoServices;

    @RequestMapping(value = "/overview/{id}", method = RequestMethod.GET)
    public String overview(@PathVariable int id) {
        final Director director = this.directorDaoServices.get(id);
        return SERIALIZER.to(new SuccessResponse(director));
    }

    @RequestMapping(value = "overview/{id}/movies", method = RequestMethod.GET)
    public String moviesOverview(@PathVariable int id) {
        final Director director = this.directorDaoServices.get(id);
        return SERIALIZER.to(new SuccessResponse(director.getMovies()));
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String filter(@RequestBody String data) {
        final Map<String, String> parameters = DESERIALIZER.from(data, HashMap.class);

        final List<Director> directors = this.directorDaoServices.filter(parameters);
        return SERIALIZER.to(new SuccessResponse(directors));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        final List<Director> directors = this.directorDaoServices.getAll();
        return SERIALIZER.to(new SuccessResponse(directors));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody String data) {
        final DirectorForm directorForm = DESERIALIZER.from(data, DirectorForm.class);

        final Director director = new Director();
        director.setLastname(directorForm.getLastname());
        director.setFirstname(directorForm.getFirstname());

        this.directorDaoServices.insert(director);
        return SERIALIZER.to(new SuccessResponse(director));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody String data) {
        final DirectorForm directorForm = DESERIALIZER.from(data, DirectorForm.class);

        final Director director = new Director();
        director.setId(directorForm.getId());
        director.setLastname(directorForm.getLastname());
        director.setFirstname(directorForm.getFirstname());

        this.directorDaoServices.update(director);
        return SERIALIZER.to(new SuccessResponse(director));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable int id) {
        final Director director = this.directorDaoServices.get(id);
        this.directorDaoServices.delete(director);
    }
}