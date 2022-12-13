package com.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "businesses")
@Entity
public class Business implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(length = 30, name = "BUSINESS_NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "LOGO_URL")
    private String logoUrl;

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID", nullable = false)
    private Address address;

}
