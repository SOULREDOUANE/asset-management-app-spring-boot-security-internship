package com.roua.roua.register;

import com.roua.roua.domain.Product;
import com.roua.roua.domain.State;
import com.roua.roua.domain.User;
import com.roua.roua.domain.Vendor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssetRequest {

    private Long id;
    private String name;
    private String description;
    private String purchassingDate;
    private String experingDate;

    private State assetType;

    private Product product;
    private Vendor vendor;
    private User user;
    
}
