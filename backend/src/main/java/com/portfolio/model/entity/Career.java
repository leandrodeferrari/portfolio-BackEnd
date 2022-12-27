package com.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

import java.time.LocalDate;

@Data
@Table(name = "careers", uniqueConstraints =
@UniqueConstraint(columnNames = {"CAREER_NAME", "INSTITUTE_UNIVERSITY_ID"})
)
@Entity
public class Career implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(length = 50, name = "CAREER_NAME", nullable = false)
    private String name;

    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "IS_FINISHED", nullable = false)
    private boolean isFinished;

    @Column(name = "APPROVED_SUBJECTS", nullable = false)
    private Byte approvedSubjects;

    @Column(name = "TOTAL_SUBJECTS", nullable = false)
    private Byte totalSubjects;

    @Column(name = "STUDY_PLAN_URL", nullable = false)
    private String studyPlanUrl;

    @Column(name = "DESCRIPT", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "INSTITUTE_UNIVERSITY_ID", nullable = false)
    private InstituteUniversity instituteUniversity;

    @ManyToOne
    @JoinColumn(name = "CAREER_TYPE_ID", nullable = false)
    private CareerType careerType;

}
