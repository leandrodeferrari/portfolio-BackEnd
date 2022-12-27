package com.portfolio.repository;

import com.portfolio.model.entity.Locality;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILocalityRepository extends JpaRepository<Locality, Integer> {

    Optional<Locality> findByName(String name);

}
