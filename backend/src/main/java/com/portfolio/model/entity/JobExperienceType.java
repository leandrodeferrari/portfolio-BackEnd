package com.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

@Data
@Table(name = "job_experience_types")
@Entity
public class JobExperienceType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(length = 30, name = "JOB_EXPERIENCE_TYPE_NAME", nullable = false, unique = true)
    private String name;

}
