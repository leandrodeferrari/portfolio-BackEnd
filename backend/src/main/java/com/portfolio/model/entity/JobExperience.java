package com.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Table(name = "job_experiences", uniqueConstraints =
@UniqueConstraint(columnNames = {"JOB_POSITION_NAME", "BUSINESS_ID"})
)
@Entity
public class JobExperience implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(length = 30, name = "JOB_POSITION_NAME", nullable = false)
    private String name;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "IS_CURRENT_JOB", nullable = false)
    private boolean isCurrentJob;

    @Column(name = "DESCRIPT", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "SENIORITY_TYPE_ID", nullable = false)
    private SeniorityType seniorityType;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "JOB_EXPERIENCE_TYPE_ID", nullable = false)
    private JobExperienceType jobExperienceType;

    @ManyToOne
    @JoinColumn(name = "BUSINESS_ID")
    private Business business;

}
