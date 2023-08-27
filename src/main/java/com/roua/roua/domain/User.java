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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;
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
	private String phone;
	private String urlImage;
	private String  joinDate;
	private String  dateOfBird;
	private String  lastLogin;
	private String  designation;
	private String  address;
	private String state;
	@ManyToOne
	@JoinColumn(
			name = "department_id",
			referencedColumnName = "id",
			foreignKey = @ForeignKey(name = "department_user_fk")
	)
	private Department department;

	public User( String firstName, String lastName, String email, String password, Role role, String phone,
			String urlImage, String joinDate, String dateOfBird, String lastLogin, String designation, String address,
			String state, Department department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.phone = phone;
		this.urlImage = urlImage;
		this.joinDate = joinDate;
		this.dateOfBird = dateOfBird;
		this.lastLogin = lastLogin;
		this.designation = designation;
		this.address = address;
		this.state = state;
		this.department = department;
	}	
	



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
