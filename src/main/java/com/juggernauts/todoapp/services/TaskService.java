package com.juggernauts.todoapp.services;

import com.juggernauts.todoapp.models.Category;
import com.juggernauts.todoapp.models.Task;
import com.juggernauts.todoapp.models.User;
import com.juggernauts.todoapp.repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private TaskRepo taskRepo;

    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public void addTask(Task task) throws RuntimeException {
        taskRepo.save(task);
    }

    public List<Task> getTasks(User user) throws NoSuchElementException {

        List<Task> allTasks = taskRepo.findAll();

        List<Task> usersTasks = allTasks.stream()
                .filter(task -> task.getUser().getId() == user.getId())
                .collect(Collectors.toList());
        if (usersTasks.isEmpty()) {
            throw new NoSuchElementException();
        }
        return usersTasks;
    }

    public HashMap<String, List<Task>> getAllTasksPerCategory(User currentUser) {
        // testing
        System.out.println("!*!*!*!*!*!*!*!*!*!*ENTERED TASK SERVICE!*!*!*!*!*!*!*!*!");

        List<Task> usersTasks = getTasks(currentUser);

        HashMap<String, List<Task>> tasksToCategory = new HashMap<>();

        // Put all incomplete tasks without category into None category
        List<Task> incompleteTasks = usersTasks.stream().filter(task -> task.getCategory() == null && !task.isDone()).collect(Collectors.toList());
        System.out.println("======================================INCOMPLETE TASKS:============================");
        incompleteTasks.forEach(System.out::println);
        tasksToCategory.put("None", incompleteTasks);
        System.out.println("INCOMPLETE TASKS ADDED TO HASHMAP");

        System.out.println(tasksToCategory);

        // Put all complete tasks into Complete category
        List<Task> completeTasks = usersTasks.stream().filter(task -> task.isDone()).collect(Collectors.toList());
        System.out.println("======================================COMPLETE TASKS:============================");
        completeTasks.forEach(System.out::println);

        tasksToCategory.put("Complete", completeTasks);
        System.out.println("COMPLETE TASKS ADDED TO HASHMAP");

        System.out.println(tasksToCategory);

        Set<String> categoryNames = new HashSet<>();
        List<Task> incompleteCategorizedTasks = usersTasks.stream().filter(task -> !task.isDone() && task.getCategory() != null).collect(Collectors.toList());
        incompleteCategorizedTasks.forEach(task -> categoryNames.add(task.getCategory().getCategoryName()));


        System.out.println("========================================CATEGORY NAMES:===========================");
        categoryNames.forEach(System.out::println);

        // go through all of users tasks putting each list of tasks per category in its appropriate category.
        categoryNames.forEach(
                categoryName -> {
                    System.out.println("Category name: " +categoryName);
                    List<Task> tasksPerCategory = incompleteCategorizedTasks.stream()
                            .filter(task -> task.getCategory().getCategoryName().equals(categoryName))
                            .collect(Collectors.toList());
                    System.out.println("******************CATEGORY NAME:****************");
                    tasksPerCategory.forEach(System.out::println);
                    tasksToCategory.put(categoryName, tasksPerCategory);
                }
        );

        return tasksToCategory;
    }

    public void resolveTask(int taskId) throws NoSuchElementException {
        Task task = taskRepo.findById(taskId).orElseThrow(NoSuchElementException::new);

        task.setDone(true);

        taskRepo.save(task);
    }

    public void changeCategory(int taskId, String categoryName) throws NoSuchElementException {
        Task task = taskRepo.findById(taskId).orElseThrow(NoSuchElementException::new);
        task.setCategory(new Category());
    }
}