package com.aarogyaNet.controller;

import com.aarogyaNet.dto.ApiResponse;
import com.aarogyaNet.entity.EmergencyRequest;
import com.aarogyaNet.service.EmergencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/emergency")
@RequiredArgsConstructor
public class EmergencyController {
    private final EmergencyService emergencyService;

    @PostMapping("/request")
    public ResponseEntity<ApiResponse<EmergencyRequest>> createEmergency(
        @RequestBody EmergencyRequest request) {
        return ResponseEntity.ok(
            ApiResponse.success(emergencyService.createEmergency(request)));
    }

    @GetMapping("/active")
    public ResponseEntity<ApiResponse<List<EmergencyRequest>>> getActive() {
        return ResponseEntity.ok(
            ApiResponse.success(emergencyService.getActiveEmergencies()));
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<ApiResponse<String>> resolve(@PathVariable String id) {
        emergencyService.resolveEmergency(id);
        return ResponseEntity.ok(ApiResponse.success("Resolved"));
    }
}