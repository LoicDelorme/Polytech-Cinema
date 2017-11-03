package fr.polytech.cinema.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.polytech.cinema.forms.CharacterForm;
import fr.polytech.cinema.responses.ActorsResponse;
import fr.polytech.cinema.responses.CharacterResponse;
import fr.polytech.cinema.responses.CharactersResponse;
import fr.polytech.cinema.responses.MoviesResponse;

@Controller
@RequestMapping("/CharacterController")
public class CharacterController extends AbstractController {

	public static final String OVERVIEW_URL = "character/overview/%d/%d";

	public static final String LIST_URL = "character/list";

	public static final String INSERT_URL = "character/insert";

	public static final String UPDATE_URL = "character/update";

	public static final String DELETE_URL = "character/delete/%d/%d";

	@RequestMapping(value = "/overview", method = RequestMethod.GET)
	public ModelAndView overview(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "movieId") int movieId, @RequestParam(value = "actorId") int actorId) throws Exception {
		final CharacterResponse characterResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(String.format(OVERVIEW_URL, movieId, actorId), String.class), CharacterResponse.class);
		if (!characterResponse.isSuccess()) {
			throw new Exception("Failed to recover character...");
		}

		request.setAttribute("character", characterResponse.getData());
		return new ModelAndView("pages/characters/overview");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final CharactersResponse charactersResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(LIST_URL, String.class), CharactersResponse.class);
		if (!charactersResponse.isSuccess()) {
			throw new Exception("Failed to recover characters...");
		}

		request.setAttribute("characters", charactersResponse.getData());
		return new ModelAndView("pages/characters/list");
	}

	@RequestMapping(value = "/add-form", method = RequestMethod.GET)
	public ModelAndView addForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final MoviesResponse moviesResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(MovieController.LIST_URL, String.class), MoviesResponse.class);
		if (!moviesResponse.isSuccess()) {
			throw new Exception("Failed to recover movies...");
		}

		final ActorsResponse actorsResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(ActorController.LIST_URL, String.class), ActorsResponse.class);
		if (!actorsResponse.isSuccess()) {
			throw new Exception("Failed to recover actors...");
		}

		request.setAttribute("movies", moviesResponse.getData());
		request.setAttribute("actors", actorsResponse.getData());
		return new ModelAndView("pages/characters/add-form");
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final CharacterForm characterForm = new CharacterForm();
		characterForm.setActorId(Integer.parseInt(request.getParameter("actorId")));
		characterForm.setMovieId(Integer.parseInt(request.getParameter("movieId")));
		characterForm.setName(request.getParameter("name"));

		final CharacterResponse characterResponse = DESERIALIZER.from(RESTFUL_REQUESTER.post(INSERT_URL, characterForm, String.class), CharacterResponse.class);
		if (!characterResponse.isSuccess()) {
			throw new Exception("Failed to insert character...");
		}

		request.setAttribute("message", "The character was successfully added!");
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/update-form", method = RequestMethod.GET)
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "movieId") int movieId, @RequestParam(value = "actorId") int actorId) throws Exception {
		final CharacterResponse characterResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(String.format(OVERVIEW_URL, movieId, actorId), String.class), CharacterResponse.class);
		if (!characterResponse.isSuccess()) {
			throw new Exception("Failed to recover character...");
		}

		request.setAttribute("character", characterResponse.getData());
		return new ModelAndView("pages/characters/update-form");
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final CharacterForm characterForm = new CharacterForm();
		characterForm.setActorId(Integer.parseInt(request.getParameter("actorId")));
		characterForm.setMovieId(Integer.parseInt(request.getParameter("movieId")));
		characterForm.setName(request.getParameter("name"));

		final CharacterResponse characterResponse = DESERIALIZER.from(RESTFUL_REQUESTER.put(UPDATE_URL, characterForm, String.class), CharacterResponse.class);
		if (!characterResponse.isSuccess()) {
			throw new Exception("Failed to update character...");
		}

		request.setAttribute("message", "The character was successfully updated!");
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "movieId") int movieId, @RequestParam(value = "actorId") int actorId) throws Exception {
		final CharacterResponse characterResponse = DESERIALIZER.from(RESTFUL_REQUESTER.delete(String.format(DELETE_URL, movieId, actorId), String.class), CharacterResponse.class);
		if (!characterResponse.isSuccess()) {
			throw new Exception("Failed to delete character...");
		}

		request.setAttribute("message", "The character was successfully deleted!");
		return new ModelAndView("index");
	}
}