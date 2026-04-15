package com.aarogyaNet.repository;

import com.aarogyaNet.entity.BloodInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BloodInventoryRepository
    extends JpaRepository<BloodInventory, String> {

    List<BloodInventory> findByHealthCenterId(String healthCenterId);

    List<BloodInventory> findByBloodGroupAndUnitsAvailableGreaterThan(
        String bloodGroup, int units);

    @Query("SELECT b FROM BloodInventory b JOIN b.healthCenter h " +
           "WHERE b.bloodGroup = :bg AND h.state = :state " +
           "AND h.district = :district AND b.unitsAvailable > 0")
    List<BloodInventory> findByBloodGroupAndStateAndDistrict(
        String bg, String state, String district);
}