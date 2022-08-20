package com.juggernauts.todoapp.repos;

import com.juggernauts.todoapp.models.Category;
import com.juggernauts.todoapp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TaskRepo extends JpaRepository<Task, Integer> {
}
