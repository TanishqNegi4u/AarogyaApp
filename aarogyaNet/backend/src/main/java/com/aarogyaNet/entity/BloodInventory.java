package com.aarogyaNet.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "blood_inventory")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class BloodInventory {
    @Id private String id;
    private String healthCenterId;
    private String bloodGroup;
    private Integer unitsAvailable;
    private LocalDateTime lastUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "healthCenterId",
        insertable = false, updatable = false)
    private HealthCenter healthCenter;
}