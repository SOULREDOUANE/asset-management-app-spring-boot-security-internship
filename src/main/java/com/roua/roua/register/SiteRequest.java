package com.roua.roua.register;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SiteRequest {

    private Integer id;
    private String name;
    private String description;
    private String adresse;
}
