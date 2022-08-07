package com.example.hrms.entities.concretes;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="id")
    @ApiModelProperty(hidden = true)
    private int id;

    @Column(name="email")
    @Email
    @NotBlank
    @NotNull
    private String email;

    @Column(name="password")
    @NotBlank
    @NotNull
    private String password;
}
