package com.tirmizee.core.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.tirmizee.backend.dao.PermissionDao;
import com.tirmizee.backend.dao.UserDao;
import com.tirmizee.repository.entities.Permission;
import com.tirmizee.repository.entities.User;

/**
 * @author tirmizee
 *
 */

public class UserDetailsServiceImpl implements UserDetailsService {

	private static final Logger LOGGER = Logger.getLogger(UserDetailsServiceImpl.class);

	private UserDao userDao;
	private PermissionDao permissionDao;
	private UserProfile userProfile;
	
	public UserDetailsServiceImpl(UserDao userDao, PermissionDao permissionDao) {
		this.userDao = userDao;
		this.permissionDao = permissionDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if (user == null) {	return null; }
		username = user.getUsername();
		List<Permission> permissions = permissionDao.findByUsername(username);
		Set<GrantedAuthority> authorities = getAuthorities(permissions);
		this.userProfile = new UserProfile(user.getUsername(), user.getPassword(), authorities);
		this.userProfile.setFirstName(user.getFirstname());
		this.userProfile.setLastName(user.getLastname());
		this.userProfile.setStatus(user.getStatus());
		return userProfile;
	}
	
	public UserProfile getUserProfile() {
		return userProfile;
	}

	private Set<GrantedAuthority> getAuthorities(Collection<Permission> permissions){
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for(Permission permission : permissions) {
            authorities.add(new SimpleGrantedAuthority(permission.getCode()));
        }
        LOGGER.debug("user authorities are " + authorities.toString());
	    return authorities;
	}

}
