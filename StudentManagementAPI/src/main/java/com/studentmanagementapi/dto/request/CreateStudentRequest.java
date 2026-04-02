package com.studentmanagementapi.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateStudentRequest {
    @NotBlank
    @Pattern(regexp = "^SV\\d{3}$", message = "Mã SV phải dạng SVxxx (VD: SV001)")
    private String studentCode;

    @NotBlank
    @Size(min=2, max=50, message = "Tên phải dài nhỏ nhất 2 ký tự và dài nhất 50 ký tự")
    private String name;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotBlank
    @Pattern(regexp="^\\d{10}$", message = "phải có 10 chữ số, bắt đầu bằng 0")
    private String phone;

    @Past
    private LocalDate dateOfBirth;

    @Max(value = 4, message = "GPA cao nhất là 4")
    @Min(value = 0, message = "GPA nhỏ nhất là 0")
    @DecimalMax("4.0")
    @DecimalMin("0.0")
    private Double gpa;

    @NotBlank
    private String major;

    @Min(1)
    @Max(6)
    private Integer year;
}
