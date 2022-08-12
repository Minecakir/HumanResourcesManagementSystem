package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@Table(name = "links")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})

public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @NotNull
    @NotBlank
    @Column(name = "link_name")
    private String linkName;

    @NotNull
    @NotBlank
    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private Cv cv;
}
