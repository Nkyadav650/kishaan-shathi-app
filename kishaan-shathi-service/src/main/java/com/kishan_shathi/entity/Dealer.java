package com.kishan_shathi.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Dealer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dealerId;

    private String name;
    private String email;
    private String phoneNumber;
    private String address;

//    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<ShellingRequest> shellingRequests;

}
