package com.studentmanagementapi.controller;

import com.studentmanagementapi.dto.request.CreateStudentRequest;
import com.studentmanagementapi.dto.request.UpdateStudentRequest;
import com.studentmanagementapi.dto.response.ApiResponse;
import com.studentmanagementapi.model.Student;
import com.studentmanagementapi.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {
        List<Student> students = studentService.getAll();
        return ResponseEntity.ok(ApiResponse.success(students));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(
            @PathVariable Long id) {
        Student student = studentService.getById(id);
        return ResponseEntity.ok(ApiResponse.success(student));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> createStudent(
            @Valid @RequestBody CreateStudentRequest student) {
        Student saved = studentService.create(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.created(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody UpdateStudentRequest student) {
        Student updated = studentService.update(id, student);
        return ResponseEntity
                .ok(ApiResponse.success("Cập nhật thành công", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteStudent(
            @PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity
                .ok(ApiResponse.success("Xoá thành công", null));
    }

    @GetMapping("/major/{major}")
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudentsByMajor(
            @PathVariable String major
    ) {
        List<Student> students = studentService.getByMajor(major);
        return ResponseEntity.ok(ApiResponse.success(students));
    }

    @GetMapping("/honors")
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudentsByHonor() {
        List<Student> students = studentService.getHonors();
        return ResponseEntity.ok(ApiResponse.success(students));
    }
}
