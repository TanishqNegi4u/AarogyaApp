package com.aarogyaNet.service;

import com.aarogyaNet.entity.BloodInventory;
import com.aarogyaNet.repository.BloodInventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BloodBankService {
    private final BloodInventoryRepository bloodRepo;

    public List<BloodInventory> searchBlood(
        String bloodGroup, String state, String district) {
        if (state != null && district != null) {
            return bloodRepo
                .findByBloodGroupAndStateAndDistrict(
                    bloodGroup, state, district);
        }
        return bloodRepo.findByBloodGroupAndUnitsAvailableGreaterThan(
            bloodGroup, 0);
    }

    public List<BloodInventory> getInventoryByHospital(String hospitalId) {
        return bloodRepo.findByHealthCenterId(hospitalId);
    }
}