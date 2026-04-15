package com.aarogyaNet.repository;

import com.aarogyaNet.entity.HealthCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HealthCenterRepository
    extends JpaRepository<HealthCenter, String> {
    List<HealthCenter> findByState(String state);
    List<HealthCenter> findByStateAndDistrict(String state, String district);
    List<HealthCenter> findByHasAmbulanceTrue();
}