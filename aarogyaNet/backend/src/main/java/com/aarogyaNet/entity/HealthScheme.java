package com.aarogyaNet.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "health_schemes")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class HealthScheme {
    @Id private String id;
    private String name;
    private String nameHindi;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String eligibilityCriteria;

    @Column(columnDefinition = "TEXT")
    private String benefits;

    private String applyingUrl;

    @Column(columnDefinition = "TEXT")
    private String documentsRequired;

    private String state;
    private Boolean isActive;

    @PrePersist
    void onCreate() {
        if (isActive == null) isActive = true;
    }
}