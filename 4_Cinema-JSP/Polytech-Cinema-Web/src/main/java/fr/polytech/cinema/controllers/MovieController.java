package fr.polytech.cinema.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.polytech.cinema.entities.Movie;
import fr.polytech.cinema.forms.MovieForm;
import fr.polytech.cinema.responses.ActorsResponse;
import fr.polytech.cinema.responses.CategoriesResponse;
import fr.polytech.cinema.responses.DirectorsResponse;
import fr.polytech.cinema.responses.MovieResponse;
import fr.polytech.cinema.responses.MoviesResponse;

@Controller
@RequestMapping("/MovieController")
public class MovieController extends AbstractController {

	public static final String OVERVIEW_URL = "movie/overview/%d";

	public static final String OVERVIEW_ACTORS_URL = "movie/overview/%d/actors";

	public static final String FILTER_URL = "movie/filter";

	public static final String LIST_URL = "movie/list";

	public static final String INSERT_URL = "movie/insert";

	public static final String UPDATE_URL = "movie/update";

	public static final String DELETE_URL = "movie/delete/%d";

	@RequestMapping(value = "/overview", method = RequestMethod.GET)
	public ModelAndView overview(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "id") int id) throws Exception {
		final MovieResponse movieResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(String.format(OVERVIEW_URL, id), String.class), MovieResponse.class);
		if (!movieResponse.isSuccess()) {
			throw new Exception("Failed to recover movie...");
		}
		final Movie movie = movieResponse.getData();

		final ActorsResponse actorsResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(String.format(OVERVIEW_ACTORS_URL, id), String.class), ActorsResponse.class);
		if (!actorsResponse.isSuccess()) {
			throw new Exception("Failed to recover actors of the movie...");
		}
		movie.setActors(actorsResponse.getData());

		request.setAttribute("movie", movie);
		return new ModelAndView("pages/movies/overview");
	}

	@RequestMapping(value = "/filter-form", method = RequestMethod.GET)
	public ModelAndView filterForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("pages/movies/filter-form");
	}

	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public ModelAndView filter(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final MovieForm movieForm = new MovieForm();
		movieForm.setTitle(request.getParameter("title"));

		final MoviesResponse moviesResponse = DESERIALIZER.from(RESTFUL_REQUESTER.post(FILTER_URL, movieForm, String.class), MoviesResponse.class);
		if (!moviesResponse.isSuccess()) {
			throw new Exception("Failed to filter movies...");
		}

		request.setAttribute("movies", moviesResponse.getData());
		return new ModelAndView("pages/movies/list");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final MoviesResponse moviesResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(LIST_URL, String.class), MoviesResponse.class);
		if (!moviesResponse.isSuccess()) {
			throw new Exception("Failed to recover movies...");
		}

		request.setAttribute("movies", moviesResponse.getData());
		return new ModelAndView("pages/movies/list");
	}

	@RequestMapping(value = "/add-form", method = RequestMethod.GET)
	public ModelAndView addForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final DirectorsResponse directorsResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(DirectorController.LIST_URL, String.class), DirectorsResponse.class);
		if (!directorsResponse.isSuccess()) {
			throw new Exception("Failed to recover directors...");
		}

		final CategoriesResponse categoriesResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(CategoryController.LIST_URL, String.class), CategoriesResponse.class);
		if (!categoriesResponse.isSuccess()) {
			throw new Exception("Failed to recover categories...");
		}

		request.setAttribute("directors", directorsResponse.getData());
		request.setAttribute("categories", categoriesResponse.getData());
		return new ModelAndView("pages/movies/add-form");
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final MovieForm movieForm = new MovieForm();
		movieForm.setTitle(request.getParameter("title"));
		movieForm.setDuration(Integer.parseInt(request.getParameter("duration")));
		movieForm.setReleaseDate(request.getParameter("releaseDate"));
		movieForm.setBudget(Integer.parseInt(request.getParameter("budget")));
		movieForm.setAmountOfRevenue(Integer.parseInt(request.getParameter("amountOfRevenue")));
		movieForm.setDirectorId(Integer.parseInt(request.getParameter("directorId")));
		movieForm.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));

		final MovieResponse movieResponse = DESERIALIZER.from(RESTFUL_REQUESTER.post(INSERT_URL, movieForm, String.class), MovieResponse.class);
		if (!movieResponse.isSuccess()) {
			throw new Exception("Failed to insert movie...");
		}

		request.setAttribute("message", "The movie was successfully added!");
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/update-form", method = RequestMethod.GET)
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "id") int id) throws Exception {
		final MovieResponse movieResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(String.format(OVERVIEW_URL, id), String.class), MovieResponse.class);
		if (!movieResponse.isSuccess()) {
			throw new Exception("Failed to recover movie...");
		}

		final DirectorsResponse directorsResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(DirectorController.LIST_URL, String.class), DirectorsResponse.class);
		if (!directorsResponse.isSuccess()) {
			throw new Exception("Failed to recover directors...");
		}

		final CategoriesResponse categoriesResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(CategoryController.LIST_URL, String.class), CategoriesResponse.class);
		if (!categoriesResponse.isSuccess()) {
			throw new Exception("Failed to recover categories...");
		}

		request.setAttribute("movie", movieResponse.getData());
		request.setAttribute("directors", directorsResponse.getData());
		request.setAttribute("categories", categoriesResponse.getData());
		return new ModelAndView("pages/movies/update-form");
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final MovieForm movieForm = new MovieForm();
		movieForm.setId(Integer.parseInt(request.getParameter("id")));
		movieForm.setTitle(request.getParameter("title"));
		movieForm.setDuration(Integer.parseInt(request.getParameter("duration")));
		movieForm.setReleaseDate(request.getParameter("releaseDate"));
		movieForm.setBudget(Integer.parseInt(request.getParameter("budget")));
		movieForm.setAmountOfRevenue(Integer.parseInt(request.getParameter("amountOfRevenue")));
		movieForm.setDirectorId(Integer.parseInt(request.getParameter("directorId")));
		movieForm.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));

		final MovieResponse movieResponse = DESERIALIZER.from(RESTFUL_REQUESTER.put(UPDATE_URL, movieForm, String.class), MovieResponse.class);
		if (!movieResponse.isSuccess()) {
			throw new Exception("Failed to update movie...");
		}

		request.setAttribute("message", "The movie was successfully updated!");
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "id") int id) throws Exception {
		final MovieResponse movieResponse = DESERIALIZER.from(RESTFUL_REQUESTER.delete(String.format(DELETE_URL, id), String.class), MovieResponse.class);
		if (!movieResponse.isSuccess()) {
			throw new Exception("Failed to delete movie...");
		}

		request.setAttribute("message", "The movie was successfully deleted!");
		return new ModelAndView("index");
	}
}