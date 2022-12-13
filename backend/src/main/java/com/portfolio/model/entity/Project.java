package com.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Table(name = "projects")
@Entity
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(length = 50, name = "PROJECT_NAME", nullable = false)
    private String name;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "DESCRIPT", nullable = false)
    private String description;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "EVIDENCE_URL", nullable = false)
    private String evidenceUrl;

    @ManyToOne
    @JoinColumn(name = "PROJECT_TYPE_ID", nullable = false)
    private ProjectType projectType;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "BUSINESS_ID")
    private Business business;

}
