package com.portfolio.repository;

import com.portfolio.model.entity.CareerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICareerTypeRepository extends JpaRepository<CareerType, Integer> {



}
