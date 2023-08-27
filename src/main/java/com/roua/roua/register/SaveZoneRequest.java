package com.roua.roua.register;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveZoneRequest {
    
    private String description;
    private String name;
    private String address;
    private String country;
    private String city;
    private Integer zipCode;
}
