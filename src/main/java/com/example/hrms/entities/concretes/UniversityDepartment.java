package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "university_departments")
@NoArgsConstructor
@AllArgsConstructor
public class UniversityDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @NotBlank
    @Column(name = "department_name")
    private String departmentName;

    @ManyToOne //Many department for one university
    @JsonIgnore
    @JoinColumn(name = "university_id")
    private University university;
}
