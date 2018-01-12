package com.tirmizee.core.security;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author tirmizee
 *
 */
public class UserDetailsImpl implements UserDetails {
	
	private static final long serialVersionUID = -3739827555840905814L;
	
	private static Logger LOG = Logger.getLogger(UserProfile.class);
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserDetailsImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		LOG.debug("a");
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public String getUsername() {
		return username;
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
