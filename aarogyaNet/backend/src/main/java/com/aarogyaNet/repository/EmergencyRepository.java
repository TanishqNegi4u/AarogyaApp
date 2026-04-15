package com.aarogyaNet.repository;

import com.aarogyaNet.entity.EmergencyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmergencyRepository
    extends JpaRepository<EmergencyRequest, String> {
    List<EmergencyRequest> findByStatus(String status);
    List<EmergencyRequest> findByCallerPhone(String phone);
}