package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "job_experiences")
@NoArgsConstructor
@AllArgsConstructor
public class JobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private Cv cv;

    @Column(name = "work_place")
    private String workPlace;

    @Column(name = "job_position")
    private String jobPosition;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "quit_date")
    private  Date quitDate;
}
