package com.fake.twitter.config.security.details

import com.fake.twitter.repository.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository

    UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository
    }

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = userRepository.findByUsername(username)
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Could not find user with name '" + username + "'")
        }

        List<GrantedAuthority> roles = SecurityUtil.getRoles(user.get())
        return new UserDetailsImpl(user.get(), roles)
    }
}
