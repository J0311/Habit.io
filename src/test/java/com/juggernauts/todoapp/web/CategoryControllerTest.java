package com.juggernauts.todoapp.web;

import static org.junit.jupiter.api.Assertions.assertSame;

import com.juggernauts.todoapp.services.CategoryService;
import org.junit.jupiter.api.Test;

class CategoryControllerTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link CategoryController}
     *   <li>{@link CategoryController#setCategoryService(CategoryService)}
     * </ul>
     */
    @Test
    void testConstructor() {
        CategoryController actualCategoryController = new CategoryController();
        CategoryService categoryService = new CategoryService();
        actualCategoryController.setCategoryService(categoryService);
        assertSame(categoryService, actualCategoryController.categoryService);
    }
}

