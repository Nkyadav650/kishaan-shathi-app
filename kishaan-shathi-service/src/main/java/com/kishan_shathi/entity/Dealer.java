package com.kishan_shathi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Dealer {
    

    @Id
    private String dealerId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

//    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<ShellingRequest> shellingRequests;

}
