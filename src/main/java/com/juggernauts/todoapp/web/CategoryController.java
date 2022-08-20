package com.juggernauts.todoapp.web;

import com.juggernauts.todoapp.models.Category;
import com.juggernauts.todoapp.models.Task;
import com.juggernauts.todoapp.models.User;
import com.juggernauts.todoapp.repos.TaskRepo;
import com.juggernauts.todoapp.repos.UserRepo;
import com.juggernauts.todoapp.services.CategoryService;
import com.juggernauts.todoapp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("category")
public class CategoryController {
    CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewCategory(@RequestBody Category category) {
        // This will be DELETED once currentUser is available from userSession
        User currentUser = new User(1, "testpass1", "test1");
//        System.out.println("Made user: " + currentUser);


        // This will all STAY once currentUser is available from userSession
        category.setUser(currentUser);

        try {
            categoryService.addCategory(category);
            return ResponseEntity.ok(category);
        }
        catch (InvalidParameterException e) {
            return ResponseEntity.badRequest().body("Invalid category name");
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCategories() {
        // Testing
        User currentUser = new User(1, "testpass1", "test1");

        List<Category> categories = categoryService.getAllCategoriesForUser(currentUser);
        return ResponseEntity.ok(categories);
    }

}
