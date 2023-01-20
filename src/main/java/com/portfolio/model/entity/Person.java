package com.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

@Data
@Table(name = "persons")
@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(length = 30, name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(length = 30, name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "PROFILE_PHOTO_URL", nullable = false)
    private String profilePhotoUrl;

    @Column(length = 30, name = "TITLE", nullable = false)
    private String title;

    @Column(name = "ABOUT_ME", nullable = false)
    private String aboutMe;

    @Column(length = 50, name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "BANNER_URL", nullable = false)
    private String bannerUrl;

    @Column(name = "LINKEDIN_URL", nullable = false)
    private String linkedInUrl;

    @Column(name = "GITHUB_URL", nullable = false)
    private String gitHubUrl;

    @Column(name = "CV_URL", nullable = false)
    private String cvUrl;

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID", nullable = false)
    private Address address;

}
