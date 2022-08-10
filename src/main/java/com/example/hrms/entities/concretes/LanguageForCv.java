package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidatecv_languages")
public class LanguageForCv {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private Cv cv;

    @ManyToOne
    @JoinColumn(name = "foreign_language_id")
    private ForeignLanguage foreignLanguage;
}
