package com.bossabox.vuttr.api.infra.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bossabox.vuttr.api.domain.user.Role;
import com.bossabox.vuttr.api.domain.user.User;
import com.bossabox.vuttr.api.domain.user.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final User user = userRepository.findByUsername(username).orElse(null);
		if (user == null) {
			throw new UsernameNotFoundException("User not found to: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.getActive(), true, true, true, getAuthority(user.getRole()));
	}

	private List<GrantedAuthority> getAuthority(Role... userRoles) {
		final Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();

		// all users only have one role
		roles.add(new SimpleGrantedAuthority(userRoles[0].toString()));
		final List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		return grantedAuthorities;
	}

}
