package com.example.toDo.repeository;

import com.example.toDo.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    Page<Task> findByTitleContainingAndDate(String title, LocalDate date, Pageable pageable);
    Page<Task> findByTitleContaining(String title, Pageable pageable);
    Page<Task> findByDate(LocalDate date, Pageable pageable);
}
