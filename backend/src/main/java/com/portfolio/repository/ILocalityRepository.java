package com.portfolio.repository;

import com.portfolio.model.entity.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocalityRepository extends JpaRepository<Locality, Integer> {



}
