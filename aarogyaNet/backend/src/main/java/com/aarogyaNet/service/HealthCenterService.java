package com.aarogyaNet.service;

import com.aarogyaNet.entity.HealthCenter;
import com.aarogyaNet.repository.HealthCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HealthCenterService {
    private final HealthCenterRepository repo;

    public List<HealthCenter> getAll() {
        return repo.findAll();
    }

    public List<HealthCenter> getByState(String state) {
        return repo.findByState(state);
    }

    public List<HealthCenter> getByStateAndDistrict(
        String state, String district) {
        return repo.findByStateAndDistrict(state, district);
    }

    public List<HealthCenter> getWithAmbulance() {
        return repo.findByHasAmbulanceTrue();
    }

    public HealthCenter getById(String id) {
        return repo.findById(id).orElseThrow(
            () -> new RuntimeException("Not found: " + id));
    }
}