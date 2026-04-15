package com.aarogyaNet.repository;

import com.aarogyaNet.entity.HealthScheme;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HealthSchemeRepository
    extends JpaRepository<HealthScheme, String> {
    List<HealthScheme> findByIsActiveTrue();
    List<HealthScheme> findByStateOrStateIsNull(String state);
}