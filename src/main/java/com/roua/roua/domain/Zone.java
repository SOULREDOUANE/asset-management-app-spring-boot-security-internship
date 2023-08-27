package com.roua.roua.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name ="zone")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
// @Data
public class Zone {
    @Id
    @GeneratedValue()
    private Integer id;
    @Column(unique = true, nullable = false)
    private String name;
    private String description;
    @Column(unique = true, nullable = false)
    private String address;
    private String country;
    private String city;
    private Integer zipCode;

    public Zone(String name, String description, String address, String country, String city, Integer zipCode) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
    }
    
}
