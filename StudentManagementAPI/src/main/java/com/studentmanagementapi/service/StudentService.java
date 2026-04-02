package com.studentmanagementapi.service;

import com.studentmanagementapi.dto.request.CreateStudentRequest;
import com.studentmanagementapi.dto.request.UpdateStudentRequest;
import com.studentmanagementapi.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student getById(Long id);
    Student create(CreateStudentRequest req);
    Student update(Long id, UpdateStudentRequest req);
    void delete(Long id);
    List<Student> getByMajor(String major);
    List<Student> getHonors();
}
