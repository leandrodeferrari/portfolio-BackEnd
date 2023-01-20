package com.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

@Data
@Table(name = "languages")
@Entity
public class Language implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(length = 30, name = "LANGUAGE_NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "CERTIFICATE_URL")
    private String certificateUrl;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "LANGUAGE_LEVEL_ID", nullable = false)
    private LanguageLevel languageLevel;

}
