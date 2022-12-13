package com.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "project_types")
@Entity
public class ProjectType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(length = 50, name = "PROJECT_TYPE_NAME", nullable = false, unique = true)
    private String name;

}
