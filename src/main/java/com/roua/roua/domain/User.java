package com.roua.roua.domain;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name ="user_security")
@Table(name = "user_security")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User  implements UserDetails{
    
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
	@Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
	@Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Create a SimpleGrantedAuthority for the single role and return it as a collection
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
        return email;
	}
	@Override
	public boolean isAccountNonExpired() {
        return true;
	}
	@Override
	public boolean isAccountNonLocked() {
        return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
        return true;
	}
	@Override
	public boolean isEnabled() {
        return true;
	}


}
