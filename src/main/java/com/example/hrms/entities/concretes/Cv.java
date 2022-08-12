package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cvs")
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @OneToOne
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @OneToMany(mappedBy = "cv")
    private List<Education> education;

    @OneToMany(mappedBy = "cv")
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "cv")
    private List<LanguageForCv> languageForCvs;

    @OneToMany(mappedBy = "cv")
    private List<Link> links;

    @OneToMany(mappedBy = "cv")
    private List<Skill> skills;

    @OneToMany(mappedBy = "cv")
    private List<Image> images;

    @OneToMany(mappedBy = "cv")
    private List<CoverLetter> coverLetters;
}
