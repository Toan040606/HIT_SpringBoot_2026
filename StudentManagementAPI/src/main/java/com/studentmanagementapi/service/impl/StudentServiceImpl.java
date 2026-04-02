package com.studentmanagementapi.service.impl;

import com.studentmanagementapi.dto.request.CreateStudentRequest;
import com.studentmanagementapi.dto.request.UpdateStudentRequest;
import com.studentmanagementapi.exception.DuplicateResourceException;
import com.studentmanagementapi.exception.ResourceNotFoundException;
import com.studentmanagementapi.model.Student;
import com.studentmanagementapi.service.StudentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentServiceImpl implements StudentService {
    private final List<Student> students = new ArrayList<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public StudentServiceImpl() {
        fakeData();
    }

    public List<Student> getAll() {
        return students;
    }

    private void fakeData() {
        students.add(Student.builder()
                .id(idGen.getAndIncrement())
                .studentCode("SV001")
                .name("Nguyễn Văn A")
                .email("nguyenvanahehe@gmail.com")
                .phone("0123456789")
                .dateOfBirth(LocalDate.of(2006, 1, 3))
                .gpa(2.5)
                .major("CNTT")
                .year(2)
                .build());

        students.add(Student.builder()
                .id(idGen.getAndIncrement())
                .studentCode("SV002")
                .name("Nguyễn Văn B")
                .email("nguyenvanbhehe@gmail.com")
                .phone("0123456788")
                .dateOfBirth(LocalDate.of(2007, 2,3))
                .gpa(3.7)
                .major("CNTT")
                .year(1)
                .build());

        students.add(Student.builder()
                .id(idGen.getAndIncrement())
                .studentCode("SV003")
                .name("Nguyễn Văn B")
                .email("nguyenvanahehe@gmail.com")
                .phone("0123457789")
                .dateOfBirth(LocalDate.of(2005, 1, 2))
                .gpa(4.0)
                .major("KeToan")
                .year(3)
                .build());
    }

    public Student getById(Long id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
    }

    public Student create(CreateStudentRequest req) {
        if (students.stream().anyMatch(s -> s.getStudentCode().equals(req.getStudentCode()))) {
            throw new DuplicateResourceException("Student", "studentCode", req.getStudentCode());
        }

        if (students.stream().anyMatch(s -> s.getEmail().equals(req.getEmail()))) {
            throw new DuplicateResourceException("Student", "email", req.getEmail());
        }

        Student s = Student.builder()
                .id(idGen.getAndIncrement())
                .studentCode(req.getStudentCode())
                .name(req.getName())
                .email(req.getEmail())
                .phone(req.getPhone())
                .dateOfBirth(req.getDateOfBirth())
                .gpa(req.getGpa())
                .major(req.getMajor())
                .year(req.getYear())
                .build();

        students.add(s);
        return s;
    }

    public Student update(Long id, UpdateStudentRequest req) {
        Student s = getById(id);

        if (students.stream().anyMatch(student ->
                !student.getId().equals(id) && student.getEmail().equals(req.getEmail()))) {
            throw new DuplicateResourceException("Student", "email", req.getEmail());
        }

        s.setName(req.getName());
        s.setEmail(req.getEmail());
        s.setPhone(req.getPhone());
        s.setDateOfBirth(req.getDateOfBirth());
        s.setGpa(req.getGpa());
        s.setMajor(req.getMajor());
        s.setYear(req.getYear());

        return s;
    }

    public void delete(Long id) {
        Student s = getById(id);
        students.remove(s);
    }

    public List<Student> getByMajor(String major) {
        return students.stream()
                .filter(s -> s.getMajor().equalsIgnoreCase(major))
                .toList();
    }

    public List<Student> getHonors() {
        return students.stream()
                .filter(s -> s.getGpa() >= 3.6)
                .toList();
    }
}
