package com.fake.twitter.config.security.details

import com.fake.twitter.model.entity.UserEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl implements UserDetails {
    private UserEntity user
    private List<GrantedAuthority> roles

    UserDetailsImpl(UserEntity user, List<GrantedAuthority> roles) {
        this.user = user
        this.roles = roles
    }

    Collection<GrantedAuthority> getAuthorities() {
        return roles
    }

    String getPassword() {
        return user.getPassword()
    }

    String getUsername() {
        return user.getUsername()
    }

    boolean isAccountNonExpired() {
        return true
    }

    boolean isAccountNonLocked() {
        return true
    }

    boolean isCredentialsNonExpired() {
        return true
    }

    boolean isEnabled() {
        return true
    }

    UserEntity getUser() {
        return user
    }
}
