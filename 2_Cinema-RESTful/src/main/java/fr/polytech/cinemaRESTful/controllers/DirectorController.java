package fr.polytech.cinemaRESTful.controllers;

import fr.polytech.cinemaRESTful.entities.Director;
import fr.polytech.cinemaRESTful.forms.DirectorForm;
import fr.polytech.cinemaRESTful.services.DirectorDaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/director")
public class DirectorController extends AbstractController {

    @Autowired
    private DirectorDaoServices directorDaoServices;

    @RequestMapping(value = "/overview", method = RequestMethod.POST)
    public String overview(@RequestBody String data) {
        final DirectorForm directorForm = DESERIALIZER.from(data, DirectorForm.class);
        return SERIALIZER.to(this.directorDaoServices.get(directorForm.getId()));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return SERIALIZER.to(this.directorDaoServices.getAll());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody String data) {
        final DirectorForm directorForm = DESERIALIZER.from(data, DirectorForm.class);
        final Director director = new Director();
        director.setLastname(directorForm.getLastname());
        director.setFirstname(directorForm.getFirstname());

        this.directorDaoServices.insert(director);
        return SERIALIZER.to(director);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody String data) {
        final DirectorForm directorForm = DESERIALIZER.from(data, DirectorForm.class);
        final Director director = new Director();
        director.setId(directorForm.getId());
        director.setLastname(directorForm.getLastname());
        director.setFirstname(directorForm.getFirstname());

        this.directorDaoServices.update(director);
        return SERIALIZER.to(director);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody String data) {
        final DirectorForm directorForm = DESERIALIZER.from(data, DirectorForm.class);
        this.directorDaoServices.delete(this.directorDaoServices.get(directorForm.getId()));
    }
}