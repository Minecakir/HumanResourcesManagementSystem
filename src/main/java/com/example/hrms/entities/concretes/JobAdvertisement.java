package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisements")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPos","city","employer"})
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "job_positions_id")
    private Job jobPos;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name="city_id")
    private City city;

    @NotNull
    @NotBlank
    @Column(name = "job_description")
    private String jobDescription;

    @NotNull
    @Column(name = "open_positions_num")
    private int openPosNum;

    @NotNull
    @Future
    @Column(name = "last_apply_date")
    private Date lastApplyDate;

    @NotNull
    @PastOrPresent
    @Column(name = "publish_date", columnDefinition = "Date default " + "CURRENT_TIMESTAMP")
    private Date publishDate;

    @PositiveOrZero
    @Column(name = "min_salary")
    private int minSalary;

    @PositiveOrZero
    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "is_active")
    private Boolean isActive;
}
