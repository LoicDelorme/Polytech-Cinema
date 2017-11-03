package fr.polytech.cinema.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.polytech.cinema.entities.Director;
import fr.polytech.cinema.forms.DirectorForm;
import fr.polytech.cinema.responses.DirectorResponse;
import fr.polytech.cinema.responses.DirectorsResponse;
import fr.polytech.cinema.responses.MoviesResponse;

@Controller
@RequestMapping("/DirectorController")
public class DirectorController extends AbstractController {

	public static final String OVERVIEW_URL = "director/overview/%d";

	public static final String OVERVIEW_MOVIES_URL = "director/overview/%d/movies";

	public static final String FILTER_URL = "director/filter";

	public static final String LIST_URL = "director/list";

	public static final String INSERT_URL = "director/insert";

	public static final String UPDATE_URL = "director/update";

	public static final String DELETE_URL = "director/delete/%d";

	@RequestMapping(value = "/overview", method = RequestMethod.GET)
	public ModelAndView overview(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "id") int id) throws Exception {
		final DirectorResponse directorResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(String.format(OVERVIEW_URL, id), String.class), DirectorResponse.class);
		if (!directorResponse.isSuccess()) {
			throw new Exception("Failed to recover director...");
		}
		final Director director = directorResponse.getData();

		final MoviesResponse moviesResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(String.format(OVERVIEW_MOVIES_URL, id), String.class), MoviesResponse.class);
		if (!moviesResponse.isSuccess()) {
			throw new Exception("Failed to recover movies of the director...");
		}
		director.setMovies(moviesResponse.getData());

		request.setAttribute("director", director);
		return new ModelAndView("pages/directors/overview");
	}

	@RequestMapping(value = "/filter-form", method = RequestMethod.GET)
	public ModelAndView filterForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("pages/directors/filter-form");
	}

	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public ModelAndView filter(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final DirectorForm directorForm = new DirectorForm();
		directorForm.setLastname(request.getParameter("lastname"));
		directorForm.setFirstname(request.getParameter("firstname"));

		final DirectorsResponse directorsResponse = DESERIALIZER.from(RESTFUL_REQUESTER.post(FILTER_URL, directorForm, String.class), DirectorsResponse.class);
		if (!directorsResponse.isSuccess()) {
			throw new Exception("Failed to filter directors...");
		}

		request.setAttribute("directors", directorsResponse.getData());
		return new ModelAndView("pages/directors/list");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final DirectorsResponse directorsResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(LIST_URL, String.class), DirectorsResponse.class);
		if (!directorsResponse.isSuccess()) {
			throw new Exception("Failed to recover directors...");
		}

		request.setAttribute("directors", directorsResponse.getData());
		return new ModelAndView("pages/directors/list");
	}

	@RequestMapping(value = "/add-form", method = RequestMethod.GET)
	public ModelAndView addForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("pages/directors/add-form");
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final DirectorForm directorForm = new DirectorForm();
		directorForm.setLastname(request.getParameter("lastname"));
		directorForm.setFirstname(request.getParameter("firstname"));

		final DirectorResponse directorResponse = DESERIALIZER.from(RESTFUL_REQUESTER.post(INSERT_URL, directorForm, String.class), DirectorResponse.class);
		if (!directorResponse.isSuccess()) {
			throw new Exception("Failed to insert director...");
		}

		request.setAttribute("message", "The director was successfully added!");
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/update-form", method = RequestMethod.GET)
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "id") int id) throws Exception {
		final DirectorResponse directorResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(String.format(OVERVIEW_URL, id), String.class), DirectorResponse.class);
		if (!directorResponse.isSuccess()) {
			throw new Exception("Failed to recover director...");
		}

		request.setAttribute("director", directorResponse.getData());
		return new ModelAndView("pages/directors/update-form");
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final DirectorForm directorForm = new DirectorForm();
		directorForm.setId(Integer.parseInt(request.getParameter("id")));
		directorForm.setLastname(request.getParameter("lastname"));
		directorForm.setFirstname(request.getParameter("firstname"));

		final DirectorResponse directorResponse = DESERIALIZER.from(RESTFUL_REQUESTER.put(UPDATE_URL, directorForm, String.class), DirectorResponse.class);
		if (!directorResponse.isSuccess()) {
			throw new Exception("Failed to update director...");
		}

		request.setAttribute("message", "The director was successfully updated!");
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "id") int id) throws Exception {
		final DirectorResponse directorResponse = DESERIALIZER.from(RESTFUL_REQUESTER.delete(String.format(DELETE_URL, id), String.class), DirectorResponse.class);
		if (!directorResponse.isSuccess()) {
			throw new Exception("Failed to delete director...");
		}

		request.setAttribute("message", "The director was successfully deleted!");
		return new ModelAndView("index");
	}
}