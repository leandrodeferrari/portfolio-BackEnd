package com.portfolio.security.model.entity;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

import java.time.LocalDateTime;

@Data
@Table(name = "users")
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(length = 50, name = "USER_NAME", nullable = false, unique = true)
    private String userName;

    @Column(length = 50, name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "USER_PASSWORD", nullable = false)
    private String password;

    @Column(name = "CREATION_DATE", nullable = false)
    private LocalDateTime creationDate;

    @OneToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;

}
