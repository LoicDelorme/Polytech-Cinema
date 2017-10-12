package fr.polytech.cinemaRESTful.controllers;

import fr.polytech.cinemaRESTful.entities.Movie;
import fr.polytech.cinemaRESTful.forms.MovieForm;
import fr.polytech.cinemaRESTful.services.CategoryDaoServices;
import fr.polytech.cinemaRESTful.services.DirectorDaoServices;
import fr.polytech.cinemaRESTful.services.MovieDaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/movie")
public class MovieController extends AbstractController {

    @Autowired
    private MovieDaoServices movieDaoServices;

    @Autowired
    private DirectorDaoServices directorDaoServices;

    @Autowired
    private CategoryDaoServices categoryDaoServices;

    @RequestMapping(value = "/overview", method = RequestMethod.POST)
    public String overview(@RequestBody String data) {
        final MovieForm movieForm = DESERIALIZER.from(data, MovieForm.class);
        return SERIALIZER.to(this.movieDaoServices.get(movieForm.getId()));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return SERIALIZER.to(this.movieDaoServices.getAll());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody String data) {
        final MovieForm movieForm = DESERIALIZER.from(data, MovieForm.class);
        final Movie movie = new Movie();
        movie.setTitle(movieForm.getTitle());
        movie.setDuration(movieForm.getDuration());
        movie.setReleaseDate(movieForm.getReleaseDate());
        movie.setBudget(movieForm.getBudget());
        movie.setAmontOfRevenue(movieForm.getAmontOfRevenue());
        movie.setDirector(this.directorDaoServices.get(movieForm.getDirectorId()));
        movie.setCategory(this.categoryDaoServices.get(movieForm.getCategoryId()));

        this.movieDaoServices.insert(movie);
        return SERIALIZER.to(movie);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody String data) {
        final MovieForm movieForm = DESERIALIZER.from(data, MovieForm.class);
        final Movie movie = new Movie();
        movie.setId(movieForm.getId());
        movie.setTitle(movieForm.getTitle());
        movie.setDuration(movieForm.getDuration());
        movie.setReleaseDate(movieForm.getReleaseDate());
        movie.setBudget(movieForm.getBudget());
        movie.setAmontOfRevenue(movieForm.getAmontOfRevenue());
        movie.setDirector(this.directorDaoServices.get(movieForm.getDirectorId()));
        movie.setCategory(this.categoryDaoServices.get(movieForm.getCategoryId()));

        this.movieDaoServices.update(movie);
        return SERIALIZER.to(movie);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody String data) {
        final MovieForm movieForm = DESERIALIZER.from(data, MovieForm.class);
        this.movieDaoServices.delete(this.movieDaoServices.get(movieForm.getId()));
    }
}