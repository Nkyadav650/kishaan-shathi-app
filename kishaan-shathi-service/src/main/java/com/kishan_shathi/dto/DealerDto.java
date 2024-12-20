package com.kishan_shathi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealerDto {


    private String dealerId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;


}
