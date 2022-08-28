package com.example.webSocketDemo.test.subject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Query("SELECT s FROM Subject s LEFT JOIN s.enrolledStudents e WHERE e.name LIKE %?1%")
    Page<Subject> getAllBySubjectName(String name, Pageable pageable);
}
