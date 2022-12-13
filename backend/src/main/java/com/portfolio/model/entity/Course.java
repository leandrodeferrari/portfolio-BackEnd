package com.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Table(name = "courses", uniqueConstraints =
@UniqueConstraint(columnNames = {"TITLE", "INSTITUTE_UNIVERSITY_ID"})
)
@Entity
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(length = 30, name = "TITLE", nullable = false)
    private String title;

    @Column(name = "IS_APPROVED", nullable = false)
    private boolean isApproved;

    @Column(name = "CERTIFICATE_URL")
    private String certificateUrl;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "INSTITUTE_UNIVERSITY_ID", nullable = false)
    private InstituteUniversity instituteUniversity;

}
