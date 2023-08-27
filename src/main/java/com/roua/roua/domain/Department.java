package com.roua.roua.domain;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name ="department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false
    , unique = true)
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "site_id",
    referencedColumnName = "id")
    private Site site;
    @OneToOne
    @JoinColumn(name = "manager_id",
    referencedColumnName = "id")
    private User manager;
    @OneToMany
    @JoinColumn(name = "parent_id",
    referencedColumnName = "id")
    private List<User> users;

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    
}
