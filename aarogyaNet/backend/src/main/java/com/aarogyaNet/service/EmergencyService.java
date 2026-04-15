package com.aarogyaNet.service;

import com.aarogyaNet.entity.EmergencyRequest;
import com.aarogyaNet.repository.EmergencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmergencyService {
    private final EmergencyRepository emergencyRepo;

    public EmergencyRequest createEmergency(EmergencyRequest req) {
        req.setId(UUID.randomUUID().toString());
        req.setStatus("PENDING");
        req.setCreatedAt(LocalDateTime.now());
        return emergencyRepo.save(req);
    }

    public List<EmergencyRequest> getActiveEmergencies() {
        return emergencyRepo.findByStatus("PENDING");
    }

    public void resolveEmergency(String id) {
        emergencyRepo.findById(id).ifPresent(e -> {
            e.setStatus("RESOLVED");
            e.setResolvedAt(LocalDateTime.now());
            emergencyRepo.save(e);
        });
    }
}