package com.roua.roua.domain;



import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Asset {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String purchassingDate;
    private String experingDate;
    @Enumerated(
            value = EnumType.STRING
    )
    private State assetType;
    @ManyToOne
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "id"
    )
    private Product product;
    @ManyToOne
    @JoinColumn(
            name = "vendor_id",
            referencedColumnName = "id"
    )
    private Vendor vendor;
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private User user;

    public Asset(String name, String description, String purchassingDate, String experingDate, State assetType) {
        this.name = name;
        this.description = description;
        this.purchassingDate = purchassingDate;
        this.experingDate = experingDate;
        this.assetType = assetType;
    }

}
