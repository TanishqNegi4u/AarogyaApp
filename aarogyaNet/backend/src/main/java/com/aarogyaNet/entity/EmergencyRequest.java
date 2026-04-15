package com.aarogyaNet.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "emergency_requests")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class EmergencyRequest {
    @Id private String id;
    private String callerName;
    private String callerPhone;
    private String emergencyType;
    private String description;
    private Double latitude;
    private Double longitude;
    private String address;
    private String status;
    private String nearestHospitalId;
    private String responderId;
    private Integer responseTimeMinutes;
    private LocalDateTime createdAt;
    private LocalDateTime resolvedAt;
}