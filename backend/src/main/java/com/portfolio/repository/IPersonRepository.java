package com.portfolio.repository;

import com.portfolio.model.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByEmail(String email);

}
