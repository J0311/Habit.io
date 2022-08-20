package com.juggernauts.todoapp.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TaskTest {
    /**
     * Method under test: {@link Task#Task(int)}
     */
    @Test
    void testConstructor() {
        Task actualTask = new Task(123);
        assertNull(actualTask.getCategory());
        assertFalse(actualTask.isDone());
        assertNull(actualTask.getUser());
        assertEquals(123, actualTask.getTaskId());
       // assertEquals(0, actualTask.getRepeatEvery());
        assertNull(actualTask.getReminders());
        assertNull(actualTask.getName());
        assertNull(actualTask.getDescription());
        assertNull(actualTask.getCompleteBy());
    }

    /**
     * Method under test: {@link Task#Task(int, Category)}
     */
    @Test
    void testConstructor2() {
        User user = new User();
        ArrayList<Category> categoryList = new ArrayList<>();
        user.setCategories(categoryList);
        user.setEmail("jane.doe@example.org");
        user.setEmailVerified(true);
        user.setId(1);
        user.setPassword("iloveyou");

        Category category = new Category();
        category.setCategoryId(123);
        category.setCategoryName("Category Name");
        ArrayList<Task> taskList = new ArrayList<>();
        category.setTasks(taskList);
        category.setUser(user);
        Task actualTask = new Task(123, category);

        Category category1 = actualTask.getCategory();
        assertSame(category, category1);
        assertFalse(actualTask.isDone());
        assertNull(actualTask.getCompleteBy());
        assertNull(actualTask.getName());
        assertNull(actualTask.getUser());
        assertNull(actualTask.getReminders());
        assertNull(actualTask.getDescription());
        assertEquals(123, actualTask.getTaskId());
       // assertEquals(0, actualTask.getRepeatEvery());
        assertEquals("Category Name", category1.getCategoryName());
        List<Task> tasks = category1.getTasks();
        assertSame(taskList, tasks);
        assertTrue(tasks.isEmpty());
        User user1 = category1.getUser();
        assertSame(user, user1);
        assertEquals(123, category1.getCategoryId());
        assertTrue(user1.isEmailVerified());
        assertEquals("iloveyou", user1.getPassword());
        assertEquals(1, user1.getId());
        assertEquals("jane.doe@example.org", user1.getEmail());
        List<Category> categories = user1.getCategories();
        assertSame(categoryList, categories);
        assertTrue(categories.isEmpty());
    }
}

