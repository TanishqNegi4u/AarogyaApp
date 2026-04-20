package com.aarogyaNet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "emergency_requests")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class EmergencyRequest {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "caller_name")
    private String callerName;

    @Column(name = "caller_phone", nullable = false)
    @NotBlank(message = "Caller phone is required")
    private String callerPhone;

    @Column(name = "emergency_type", nullable = false)
    @NotBlank(message = "Emergency type is required")
    private String emergencyType;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "status")
    private String status;

    @Column(name = "nearest_hospital_id")
    private String nearestHospitalId;

    @Column(name = "responder_id")
    private String responderId;

    @Column(name = "response_time_minutes")
    private Integer responseTimeMinutes;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "resolved_at")
    private LocalDateTime resolvedAt;

    @PrePersist
    void onCreate() {
        // Prevent client from injecting their own id
        if (id == null || id.isBlank()) {
            id = java.util.UUID.randomUUID().toString();
        }
        if (status == null) status = "PENDING";
        createdAt = LocalDateTime.now();
    }
}