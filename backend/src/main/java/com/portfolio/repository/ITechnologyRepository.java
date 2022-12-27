package com.portfolio.repository;

import com.portfolio.model.entity.Technology;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITechnologyRepository extends JpaRepository<Technology, Integer> {
}
