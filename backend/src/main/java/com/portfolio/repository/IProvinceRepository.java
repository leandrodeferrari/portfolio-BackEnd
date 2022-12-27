package com.portfolio.repository;

import com.portfolio.model.entity.Province;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProvinceRepository extends JpaRepository<Province, Integer> {

    Optional<Province> findByName(String name);

}
