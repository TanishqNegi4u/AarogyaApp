package com.aarogyaNet.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "health_centers")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class HealthCenter {
    // ... rest unchanged
}

@Entity
@Table(name = "health_centers")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class HealthCenter {
    @Id private String id;
    private String name;
    private String type;
    private String address;
    private String state;
    private String district;
    private String village;
    private String pincode;
    private String phone;
    private String email;
    private Double latitude;
    private Double longitude;
    private Integer totalBeds;
    private Integer availableBeds;
    private Boolean hasIcu;
    private Boolean hasBloodBank;
    private Boolean hasAmbulance;
    private Integer ambulanceCount;
    private Boolean is24x7;
    private Boolean verified;
}