package com.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

@Data
@Table(name = "career_types")
@Entity
public class CareerType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(length = 30, name = "CAREER_TYPE_NAME", nullable = false, unique = true)
    private String name;

}
