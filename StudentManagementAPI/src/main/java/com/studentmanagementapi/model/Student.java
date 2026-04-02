package com.studentmanagementapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private Long id;
    private String studentCode;
    private String name;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private Double gpa;
    private String major;
    private Integer year;
}
