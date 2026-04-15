package com.aarogyaNet.controller;

import com.aarogyaNet.dto.ApiResponse;
import com.aarogyaNet.entity.BloodInventory;
import com.aarogyaNet.service.BloodBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/blood")
@RequiredArgsConstructor
public class BloodBankController {
    private final BloodBankService bloodBankService;

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<BloodInventory>>> search(
        @RequestParam String bloodGroup,
        @RequestParam(required = false) String state,
        @RequestParam(required = false) String district) {
        return ResponseEntity.ok(
            ApiResponse.success(
                bloodBankService.searchBlood(bloodGroup, state, district)));
    }

    @GetMapping("/hospital/{hospitalId}")
    public ResponseEntity<ApiResponse<List<BloodInventory>>> getByHospital(
        @PathVariable String hospitalId) {
        return ResponseEntity.ok(
            ApiResponse.success(
                bloodBankService.getInventoryByHospital(hospitalId)));
    }
}