package com.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "addresses", uniqueConstraints =
    @UniqueConstraint(columnNames = {"CITY_ID", "LOCALITY_ID", "PROVINCE_ID", "COUNTRY_ID"})
)
@Entity
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CITY_ID", nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "LOCALITY_ID", nullable = false)
    private Locality locality;

    @ManyToOne
    @JoinColumn(name = "PROVINCE_ID")
    private Province province;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", nullable = false)
    private Country country;

}
