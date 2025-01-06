package com.TaskWise.taskWise.repository;

import com.TaskWise.taskWise.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByUserId(Long userId);
}
