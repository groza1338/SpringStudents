package com.groza.springstudents.controller;

import com.groza.springstudents.model.Student;
import com.groza.springstudents.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping
    public List<Student> findAllStudent() {
        return service.findAllStudents();
    }
    @PostMapping("save_student")
    public String saveStudent(@RequestBody Student student) {
        service.saveStudent(student);
        return "Student saved successfully";
    }
    @GetMapping("/{email}")
    public Student findStudentByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }
    @PutMapping("update_student")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }
    @DeleteMapping("delete_student/{email}")
    public void deleteStudent(@PathVariable String email) {
        service.deleteStudent(email);
    }
}
