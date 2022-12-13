package com.portfolio.repository;

import com.portfolio.model.entity.SeniorityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeniorityTypeRepository extends JpaRepository<SeniorityType, Integer> {



}
