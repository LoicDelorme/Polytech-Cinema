package fr.polytech.cinemaRESTful.controllers;

import fr.polytech.cinemaRESTful.controllers.forms.CategoryForm;
import fr.polytech.cinemaRESTful.controllers.responses.SuccessResponse;
import fr.polytech.cinemaRESTful.entities.Category;
import fr.polytech.cinemaRESTful.services.CategoryDaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/category")
public class CategoryController extends AbstractController {

    @Autowired
    private CategoryDaoServices categoryDaoServices;

    @RequestMapping(value = "/overview/{id}", method = RequestMethod.GET)
    public String overview(@PathVariable int id) {
        final Category category = this.categoryDaoServices.get(id);
        return SERIALIZER.to(new SuccessResponse(category));
    }

    @RequestMapping(value = "overview/{id}/movies", method = RequestMethod.GET)
    public String moviesOverview(@PathVariable int id) {
        final Category category = this.categoryDaoServices.get(id);
        return SERIALIZER.to(new SuccessResponse(category.getMovies()));
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String filter(@RequestBody String data) {
        final Map<String, String> parameters = DESERIALIZER.from(data, HashMap.class);

        final List<Category> categories = this.categoryDaoServices.filter(parameters);
        return SERIALIZER.to(new SuccessResponse(categories));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        final List<Category> categories = this.categoryDaoServices.getAll();
        return SERIALIZER.to(new SuccessResponse(categories));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody String data) {
        final CategoryForm categoryForm = DESERIALIZER.from(data, CategoryForm.class);

        final Category category = new Category();
        category.setRestrictedLabel(categoryForm.getRestrictedLabel());
        category.setFullLabel(categoryForm.getFullLabel());

        this.categoryDaoServices.insert(category);
        return SERIALIZER.to(new SuccessResponse(category));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody String data) {
        final CategoryForm categoryForm = DESERIALIZER.from(data, CategoryForm.class);

        final Category category = new Category();
        category.setId(categoryForm.getId());
        category.setRestrictedLabel(categoryForm.getRestrictedLabel());
        category.setFullLabel(categoryForm.getFullLabel());

        this.categoryDaoServices.update(category);
        return SERIALIZER.to(new SuccessResponse(category));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable int id) {
        final Category category = this.categoryDaoServices.get(id);
        this.categoryDaoServices.delete(category);
    }
}