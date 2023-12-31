package com.roua.roua.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.roua.roua.repository.UserRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ServiceDetails  implements UserDetailsService{
    private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with username: " + username));
	}
    
}
