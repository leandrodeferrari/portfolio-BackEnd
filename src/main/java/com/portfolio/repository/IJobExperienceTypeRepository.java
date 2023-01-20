package com.portfolio.repository;

import com.portfolio.model.entity.JobExperienceType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobExperienceTypeRepository extends JpaRepository<JobExperienceType, Integer> {
}
