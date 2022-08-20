package com.juggernauts.todoapp.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Task {

    // NON RELATIONAL FIELDS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int taskId;

    @Column(nullable = false, columnDefinition = "VARCHAR(32)")
    private String name;

    @Column(name = "is_done", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isDone;

    @Column(name = "complete_by", columnDefinition = "DATE")
    private Date completeBy;

    @Column(columnDefinition = "TEXT")
    private String description;

    // RELATIONAL FIELDS

    // used in previous version
//    @Column(name = "user_id",nullable = false, columnDefinition = "INTEGER")
//    private int userId;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", referencedColumnName = "user_id", columnDefinition = "INTEGER")
    private User user;

    // used in a previous version
//    @Column(name = "group_id", columnDefinition = "INTEGER")
//    private int groupId;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name="group_id", referencedColumnName = "group_id", columnDefinition = "INTEGER")
//    private Group group;


    // used in a previous version
//    @Column(name = "category_id", columnDefinition = "INTEGER")
//    private int categoryId;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="category_id", referencedColumnName = "category_id", columnDefinition = "INTEGER")
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "task")
    private List<Reminder> reminders;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    public Task(int taskId, String name) {
        this.taskId = taskId;
        this.name = name;
    }

    public Task(String name, Date completeBy, User user) {
        this.name = name;
        this.completeBy = completeBy;
        this.user = user;
    }

    public Task(String name, String description, User user) {
        this.name = name;
        this.description = description;
        this.user = user;
    }

    public Task(String name, Date completeBy, String description, User user) {
        this.name = name;
        this.completeBy = completeBy;
        this.description = description;
        this.user = user;
    }

    public Task(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public Task(int taskId, Category category) {
        this.taskId = taskId;
        this.category = category;
    }

    @Override
    public String toString() {
        return "{NAME: "+ this.name +
                ", UserID: " + getUser().getId()+"}";
    }
}
