package com.roua.roua.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name ="site")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Site {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false
    , unique = true)
    private String name;
    private String description;
    private String adresse;
    @ManyToOne
    @JoinColumn(name = "zone_id",
    nullable = false,
    referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "zone_site_fk")
    )
    private Zone zone;

    public Site(String name, String description, String adresse) {
        this.name = name;
        this.description = description;
        this.adresse = adresse;
    }
    

    
}
