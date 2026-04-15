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
    private String description;
    private String eligibilityCriteria;
    private String benefits;
    private String applyingUrl;
    private String documentsRequired;
    private String state;
    private Boolean isActive;
}