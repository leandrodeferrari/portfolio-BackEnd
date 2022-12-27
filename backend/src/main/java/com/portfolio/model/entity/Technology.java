package com.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

@Data
@Table(name = "technologies")
@Entity
public class Technology implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(length = 30, name = "TECHNOLOGY_NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "LOGO_URL", nullable = false)
    private String logoUrl;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID", nullable = false)
    private Person person;

}
