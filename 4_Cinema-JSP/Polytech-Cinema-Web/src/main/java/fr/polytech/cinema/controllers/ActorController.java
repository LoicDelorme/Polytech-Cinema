package fr.polytech.cinema.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.polytech.cinema.entities.Actor;
import fr.polytech.cinema.forms.ActorForm;
import fr.polytech.cinema.responses.ActorResponse;
import fr.polytech.cinema.responses.ActorsResponse;
import fr.polytech.cinema.responses.CharactersResponse;
import fr.polytech.cinema.responses.MoviesResponse;

@Controller
@RequestMapping("/ActorController")
public class ActorController extends AbstractController {

	public static final String OVERVIEW_URL = "actor/overview/%d";

	public static final String OVERVIEW_CHARACTERS_URL = "actor/overview/%d/characters";

	public static final String OVERVIEW_MOVIES_URL = "actor/overview/%d/movies";

	public static final String FILTER_URL = "actor/filter";

	public static final String LIST_URL = "actor/list";

	public static final String INSERT_URL = "actor/insert";

	public static final String UPDATE_URL = "actor/update";

	public static final String DELETE_URL = "actor/delete/%d";

	@RequestMapping(value = "/overview", method = RequestMethod.GET)
	public ModelAndView overview(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "id") int id) throws Exception {
		final ActorResponse actorResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(String.format(OVERVIEW_URL, id), String.class), ActorResponse.class);
		if (!actorResponse.isSuccess()) {
			throw new Exception("Failed to recover actor...");
		}
		final Actor actor = actorResponse.getData();

		final CharactersResponse charactersResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(String.format(OVERVIEW_CHARACTERS_URL, id), String.class), CharactersResponse.class);
		if (!charactersResponse.isSuccess()) {
			throw new Exception("Failed to recover characters of the actor...");
		}
		actor.setCharacters(charactersResponse.getData());

		final MoviesResponse moviesResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(String.format(OVERVIEW_MOVIES_URL, id), String.class), MoviesResponse.class);
		if (!moviesResponse.isSuccess()) {
			throw new Exception("Failed to recover movies of the actor...");
		}
		actor.setMovies(moviesResponse.getData());

		request.setAttribute("actor", actor);
		return new ModelAndView("pages/actors/overview");
	}

	@RequestMapping(value = "/filter-form", method = RequestMethod.GET)
	public ModelAndView filterForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("pages/actors/filter-form");
	}

	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public ModelAndView filter(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final ActorForm actorForm = new ActorForm();
		actorForm.setLastname(request.getParameter("lastname"));
		actorForm.setFirstname(request.getParameter("firstname"));

		final ActorsResponse actorsResponse = DESERIALIZER.from(RESTFUL_REQUESTER.post(FILTER_URL, actorForm, String.class), ActorsResponse.class);
		if (!actorsResponse.isSuccess()) {
			throw new Exception("Failed to filter actors...");
		}

		request.setAttribute("actors", actorsResponse.getData());
		return new ModelAndView("pages/actors/list");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final ActorsResponse actorsResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(LIST_URL, String.class), ActorsResponse.class);
		if (!actorsResponse.isSuccess()) {
			throw new Exception("Failed to recover actors...");
		}

		request.setAttribute("actors", actorsResponse.getData());
		return new ModelAndView("pages/actors/list");
	}

	@RequestMapping(value = "/add-form", method = RequestMethod.GET)
	public ModelAndView addForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("pages/actors/add-form");
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final ActorForm actorForm = new ActorForm();
		actorForm.setLastname(request.getParameter("lastname"));
		actorForm.setFirstname(request.getParameter("firstname"));
		actorForm.setBirthDate(request.getParameter("birthDate"));
		actorForm.setDateOfDeath(request.getParameter("dateOfDeath"));

		final ActorResponse actorResponse = DESERIALIZER.from(RESTFUL_REQUESTER.post(INSERT_URL, actorForm, String.class), ActorResponse.class);
		if (!actorResponse.isSuccess()) {
			throw new Exception("Failed to insert actor...");
		}

		request.setAttribute("message", "The actor was successfully added!");
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/update-form", method = RequestMethod.GET)
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "id") int id) throws Exception {
		final ActorResponse actorResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(String.format(OVERVIEW_URL, id), String.class), ActorResponse.class);
		if (!actorResponse.isSuccess()) {
			throw new Exception("Failed to recover actor...");
		}

		request.setAttribute("actor", actorResponse.getData());
		return new ModelAndView("pages/actors/update-form");
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final ActorForm actorForm = new ActorForm();
		actorForm.setId(Integer.parseInt(request.getParameter("id")));
		actorForm.setLastname(request.getParameter("lastname"));
		actorForm.setFirstname(request.getParameter("firstname"));
		actorForm.setBirthDate(request.getParameter("birthDate"));
		actorForm.setDateOfDeath(request.getParameter("dateOfDeath"));

		final ActorResponse actorResponse = DESERIALIZER.from(RESTFUL_REQUESTER.put(UPDATE_URL, actorForm, String.class), ActorResponse.class);
		if (!actorResponse.isSuccess()) {
			throw new Exception("Failed to update actor...");
		}

		request.setAttribute("message", "The actor was successfully updated!");
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "id") int id) throws Exception {
		final ActorResponse actorResponse = DESERIALIZER.from(RESTFUL_REQUESTER.delete(String.format(DELETE_URL, id), String.class), ActorResponse.class);
		if (!actorResponse.isSuccess()) {
			throw new Exception("Failed to delete actor...");
		}

		request.setAttribute("message", "The actor was successfully deleted!");
		return new ModelAndView("index");
	}
}