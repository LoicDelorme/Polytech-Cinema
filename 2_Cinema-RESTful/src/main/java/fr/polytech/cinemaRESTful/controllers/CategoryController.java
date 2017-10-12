package fr.polytech.cinemaRESTful.controllers;

import fr.polytech.cinemaRESTful.entities.Category;
import fr.polytech.cinemaRESTful.forms.CategoryForm;
import fr.polytech.cinemaRESTful.services.CategoryDaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/category")
public class CategoryController extends AbstractController {

    @Autowired
    private CategoryDaoServices categoryDaoServices;

    @RequestMapping(value = "/overview", method = RequestMethod.POST)
    public String overview(@RequestBody String data) {
        final CategoryForm categoryForm = DESERIALIZER.from(data, CategoryForm.class);
        return SERIALIZER.to(this.categoryDaoServices.get(categoryForm.getId()));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return SERIALIZER.to(this.categoryDaoServices.getAll());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody String data) {
        final CategoryForm categoryForm = DESERIALIZER.from(data, CategoryForm.class);
        final Category category = new Category();
        category.setRestrictedLabel(categoryForm.getRestrictedLabel());
        category.setFullLabel(categoryForm.getFullLabel());

        this.categoryDaoServices.insert(category);
        return SERIALIZER.to(category);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody String data) {
        final CategoryForm categoryForm = DESERIALIZER.from(data, CategoryForm.class);
        final Category category = new Category();
        category.setId(categoryForm.getId());
        category.setRestrictedLabel(categoryForm.getRestrictedLabel());
        category.setFullLabel(categoryForm.getFullLabel());

        this.categoryDaoServices.update(category);
        return SERIALIZER.to(category);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody String data) {
        final CategoryForm categoryForm = DESERIALIZER.from(data, CategoryForm.class);
        this.categoryDaoServices.delete(this.categoryDaoServices.get(categoryForm.getId()));
    }
}