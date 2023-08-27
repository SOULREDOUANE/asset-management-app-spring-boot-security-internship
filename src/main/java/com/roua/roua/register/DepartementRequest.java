package com.roua.roua.register;

import com.roua.roua.domain.Site;
import com.roua.roua.domain.User;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartementRequest {
    private Integer id;
    private String name;
    private String description;
    private Site site;
    private User manager;

    
    
}
