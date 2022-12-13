package com.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "language_levels")
@Entity
public class LanguageLevel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(length = 2, name = "LANGUAGE_LEVEL_NAME", nullable = false, unique = true)
    private String name;

}
