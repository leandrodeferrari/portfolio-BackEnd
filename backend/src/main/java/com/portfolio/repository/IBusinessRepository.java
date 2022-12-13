package com.portfolio.repository;

import com.portfolio.model.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBusinessRepository extends JpaRepository<Business, Integer> {



}
