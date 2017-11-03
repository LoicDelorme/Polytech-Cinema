package fr.polytech.cinema.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.polytech.cinema.entities.Category;
import fr.polytech.cinema.forms.CategoryForm;
import fr.polytech.cinema.responses.CategoriesResponse;
import fr.polytech.cinema.responses.CategoryResponse;
import fr.polytech.cinema.responses.MoviesResponse;

@Controller
@RequestMapping("/CategoryController")
public class CategoryController extends AbstractController {

	public static final String OVERVIEW_URL = "category/overview/%d";

	public static final String OVERVIEW_MOVIES_URL = "category/overview/%d/movies";

	public static final String FILTER_URL = "category/filter";

	public static final String LIST_URL = "category/list";

	public static final String INSERT_URL = "category/insert";

	public static final String UPDATE_URL = "category/update";

	public static final String DELETE_URL = "category/delete/%d";

	@RequestMapping(value = "/overview", method = RequestMethod.GET)
	public ModelAndView overview(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "id") int id) throws Exception {
		final CategoryResponse categoryResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(String.format(OVERVIEW_URL, id), String.class), CategoryResponse.class);
		if (!categoryResponse.isSuccess()) {
			throw new Exception("Failed to recover category...");
		}
		final Category category = categoryResponse.getData();

		final MoviesResponse moviesResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(String.format(OVERVIEW_MOVIES_URL, id), String.class), MoviesResponse.class);
		if (!moviesResponse.isSuccess()) {
			throw new Exception("Failed to recover movies of the category...");
		}
		category.setMovies(moviesResponse.getData());

		request.setAttribute("category", category);
		return new ModelAndView("pages/categories/overview");
	}

	@RequestMapping(value = "/filter-form", method = RequestMethod.GET)
	public ModelAndView filterForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("pages/categories/filter-form");
	}

	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public ModelAndView filter(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final CategoryForm categoryForm = new CategoryForm();
		categoryForm.setFullLabel(request.getParameter("fullLabel"));
		categoryForm.setRestrictedLabel(request.getParameter("restrictedLabel"));

		final CategoriesResponse categoriesResponse = DESERIALIZER.from(RESTFUL_REQUESTER.post(FILTER_URL, categoryForm, String.class), CategoriesResponse.class);
		if (!categoriesResponse.isSuccess()) {
			throw new Exception("Failed to filter categories...");
		}

		request.setAttribute("categories", categoriesResponse.getData());
		return new ModelAndView("pages/categories/list");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final CategoriesResponse categoriesResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(LIST_URL, String.class), CategoriesResponse.class);
		if (!categoriesResponse.isSuccess()) {
			throw new Exception("Failed to recover categories...");
		}

		request.setAttribute("categories", categoriesResponse.getData());
		return new ModelAndView("pages/categories/list");
	}

	@RequestMapping(value = "/add-form", method = RequestMethod.GET)
	public ModelAndView addForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("pages/categories/add-form");
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final CategoryForm categoryForm = new CategoryForm();
		categoryForm.setFullLabel(request.getParameter("fullLabel"));
		categoryForm.setRestrictedLabel(request.getParameter("restrictedLabel"));

		final CategoryResponse categoryResponse = DESERIALIZER.from(RESTFUL_REQUESTER.post(INSERT_URL, categoryForm, String.class), CategoryResponse.class);
		if (!categoryResponse.isSuccess()) {
			throw new Exception("Failed to insert category...");
		}

		request.setAttribute("message", "The category was successfully added!");
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/update-form", method = RequestMethod.GET)
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "id") int id) throws Exception {
		final CategoryResponse categoryResponse = DESERIALIZER.from(RESTFUL_REQUESTER.get(String.format(OVERVIEW_URL, id), String.class), CategoryResponse.class);
		if (!categoryResponse.isSuccess()) {
			throw new Exception("Failed to recover category...");
		}

		request.setAttribute("category", categoryResponse.getData());
		return new ModelAndView("pages/categories/update-form");
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		final CategoryForm categoryForm = new CategoryForm();
		categoryForm.setId(Integer.parseInt(request.getParameter("id")));
		categoryForm.setFullLabel(request.getParameter("fullLabel"));
		categoryForm.setRestrictedLabel(request.getParameter("restrictedLabel"));

		final CategoryResponse categoryResponse = DESERIALIZER.from(RESTFUL_REQUESTER.put(UPDATE_URL, categoryForm, String.class), CategoryResponse.class);
		if (!categoryResponse.isSuccess()) {
			throw new Exception("Failed to update category...");
		}

		request.setAttribute("message", "The category was successfully updated!");
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "id") int id) throws Exception {
		final CategoryResponse categoryResponse = DESERIALIZER.from(RESTFUL_REQUESTER.delete(String.format(DELETE_URL, id), String.class), CategoryResponse.class);
		if (!categoryResponse.isSuccess()) {
			throw new Exception("Failed to delete category...");
		}

		request.setAttribute("message", "The category was successfully deleted!");
		return new ModelAndView("index");
	}
}