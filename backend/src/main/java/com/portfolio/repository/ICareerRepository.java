package com.portfolio.repository;

import com.portfolio.model.entity.Career;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICareerRepository extends JpaRepository<Career, Integer> {
}
