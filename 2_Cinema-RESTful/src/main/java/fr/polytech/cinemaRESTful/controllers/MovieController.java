package fr.polytech.cinemaRESTful.controllers;

import fr.polytech.cinemaRESTful.controllers.forms.MovieForm;
import fr.polytech.cinemaRESTful.controllers.responses.SuccessResponse;
import fr.polytech.cinemaRESTful.entities.Movie;
import fr.polytech.cinemaRESTful.services.CategoryDaoServices;
import fr.polytech.cinemaRESTful.services.DirectorDaoServices;
import fr.polytech.cinemaRESTful.services.MovieDaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/overview/{id}", method = RequestMethod.GET)
    public String overview(@PathVariable int id) {
        final Movie movie = this.movieDaoServices.get(id);
        return SERIALIZER.to(new SuccessResponse(movie));
    }

    @RequestMapping(value = "overview/{id}/actors", method = RequestMethod.GET)
    public String actorsOverview(@PathVariable int id) {
        final Movie movie = this.movieDaoServices.get(id);
        return SERIALIZER.to(new SuccessResponse(movie.getActors()));
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String filter(@RequestBody String data) {
        final Map<String, String> parameters = DESERIALIZER.from(data, HashMap.class);

        final List<Movie> movies = this.movieDaoServices.filter(parameters);
        return SERIALIZER.to(new SuccessResponse(movies));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        final List<Movie> movies = this.movieDaoServices.getAll();
        return SERIALIZER.to(new SuccessResponse(movies));
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public String count() {
        return SERIALIZER.to(new SuccessResponse(this.movieDaoServices.count()));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody String data) {
        final MovieForm movieForm = DESERIALIZER.from(data, MovieForm.class);

        final Movie movie = new Movie();
        movie.setTitle(movieForm.getTitle());
        movie.setDuration(movieForm.getDuration());
        movie.setReleaseDate(movieForm.getReleaseDate());
        movie.setBudget(movieForm.getBudget());
        movie.setAmountOfRevenue(movieForm.getAmountOfRevenue());
        movie.setDirector(this.directorDaoServices.get(movieForm.getDirectorId()));
        movie.setCategory(this.categoryDaoServices.get(movieForm.getCategoryId()));

        this.movieDaoServices.insert(movie);
        return SERIALIZER.to(new SuccessResponse(movie));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody String data) {
        final MovieForm movieForm = DESERIALIZER.from(data, MovieForm.class);

        final Movie movie = this.movieDaoServices.get(movieForm.getId());
        movie.setTitle(movieForm.getTitle());
        movie.setDuration(movieForm.getDuration());
        movie.setReleaseDate(movieForm.getReleaseDate());
        movie.setBudget(movieForm.getBudget());
        movie.setAmountOfRevenue(movieForm.getAmountOfRevenue());
        movie.setDirector(this.directorDaoServices.get(movieForm.getDirectorId()));
        movie.setCategory(this.categoryDaoServices.get(movieForm.getCategoryId()));

        this.movieDaoServices.update(movie);
        return SERIALIZER.to(new SuccessResponse(movie));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable int id) {
        final Movie movie = this.movieDaoServices.get(id);
        this.movieDaoServices.delete(movie);

        return SERIALIZER.to(new SuccessResponse(null));
    }
}