package com.portfolio.repository;

import com.portfolio.model.entity.LanguageLevel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILanguageLevelRepository extends JpaRepository<LanguageLevel, Integer> {
}
