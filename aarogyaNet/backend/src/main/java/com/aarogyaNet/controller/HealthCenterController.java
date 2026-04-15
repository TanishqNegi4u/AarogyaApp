package com.aarogyaNet.controller;

import com.aarogyaNet.entity.HealthCenter;
import com.aarogyaNet.service.HealthCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hospitals")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class HealthCenterController {
    private final HealthCenterService service;

    @GetMapping
    public ResponseEntity<List<HealthCenter>> getAll(
        @RequestParam(required = false) String state,
        @RequestParam(required = false) String district) {
        if (state != null && district != null)
            return ResponseEntity.ok(
                service.getByStateAndDistrict(state, district));
        if (state != null)
            return ResponseEntity.ok(service.getByState(state));
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthCenter> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/ambulance")
    public ResponseEntity<List<HealthCenter>> withAmbulance() {
        return ResponseEntity.ok(service.getWithAmbulance());
    }
}