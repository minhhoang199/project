package com.example.webSocketDemo.test.subject;

import com.example.webSocketDemo.test.StudentRepository;
import com.example.webSocketDemo.test.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    @PostMapping
    Subject createSubject(@RequestBody Subject subject) {
        return subjectRepository.save(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    Subject addStudentToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long studentId
    ) {
        Subject subject = subjectRepository.findById(subjectId).get();
        Student student = studentRepository.findById(studentId).get();
        subject.enrolledStudents.add(student);
        return subjectRepository.save(subject);
    }

    @GetMapping("/students")
    public ResponseEntity<Page<Subject>> getAllByStudentName(
            @RequestParam("name") String name,
            @RequestParam("pageNo")Optional<Integer> pageNo,
            @RequestParam("pageSize")Optional<Integer> pageSize){
        Pageable pageable = PageRequest.of(pageNo.orElse(0), pageNo.orElse(10));
        return ResponseEntity.ok(subjectRepository.getAllBySubjectName(name, pageable));
    }
}