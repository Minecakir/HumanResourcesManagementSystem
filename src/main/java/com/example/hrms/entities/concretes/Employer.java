package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id", referencedColumnName = "id")
public class Employer extends User {

    @NotNull
    @NotBlank
    @Column(name="company_name")
    private String companyName;

    @NotNull
    @NotBlank
    @Column(name="web_address")
    private String webAddress;

    @NotNull
    @NotBlank
    @Size(min = 11, max = 11)
    @Pattern(regexp = "^\\d{11}$")
    @Column(name = "phone_number")
    private String phoneNumber;

/*    @JsonIgnore
    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private User user;*/
}
