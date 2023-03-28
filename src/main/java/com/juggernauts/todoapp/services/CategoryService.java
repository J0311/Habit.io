package com.juggernauts.todoapp.services;

import com.juggernauts.todoapp.models.Category;
import com.juggernauts.todoapp.models.Task;
import com.juggernauts.todoapp.models.User;
import com.juggernauts.todoapp.repos.CategoryRepo;
import com.juggernauts.todoapp.repos.TaskRepo;
import com.juggernauts.todoapp.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    public User currentUser;
    private CategoryRepo categoryRepo;

    @Autowired
    public void setCategoryRepo(CategoryRepo categoryRepo) {this.categoryRepo = categoryRepo;}


    public void addCategory(Category category) throws InvalidParameterException {
        try {
            categoryRepo.save(category);
        }
        catch (Exception e) {
            throw new InvalidParameterException();
        }
    }

    public List<Category> getAllCategoriesForUser(User currentUser) {
        List<Category> allCategories = categoryRepo.findAll();

        return allCategories.stream()
                .filter(category -> category.getUser().getId() == currentUser.getId())
                .collect(Collectors.toList());
    }
}
