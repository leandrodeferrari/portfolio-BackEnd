package com.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "cities")
@Entity
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(length = 30, name = "CITY_NAME", nullable = false, unique = true)
    private String name;

}
