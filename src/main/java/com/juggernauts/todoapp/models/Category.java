package com.juggernauts.todoapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", columnDefinition = "INTEGER")
    private int categoryId;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(32) CHECK (name != 'Complete')")
    private String categoryName;

    // This is from a previous "version"
//    @Column(name = "user_id", nullable = false, columnDefinition = "INTEGER")
//    private int userId;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", columnDefinition = "INTEGER")
    @JsonIgnore
    private User user;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "category")
    @JsonIgnore
    private List<Task> tasks;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", user=" + user +
                ", tasks=" + tasks +
                '}';
    }
}