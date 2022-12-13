package com.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "institutes_universities")
@Entity
public class InstituteUniversity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(length = 60, name = "INSTITUTE_UNIVERSITY_NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "LOGO_URL")
    private String logoUrl;

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID", nullable = false)
    private Address address;

}
