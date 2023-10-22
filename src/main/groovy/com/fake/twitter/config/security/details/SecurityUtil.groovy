package com.fake.twitter.config.security.details

import com.fake.twitter.model.entity.UserEntity
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder

/**
 * Utility methods for working with Spring Security.
 */
class SecurityUtil {

    static UserEntity getLoggedInUser() {
        UserEntity UserEntity = null
        SecurityContext securityContext = SecurityContextHolder.getContext()
        Authentication auth
        if (securityContext != null) {
            auth = securityContext.getAuthentication()
            if (auth != null) {
                Object principal = auth.getPrincipal()
                if (principal instanceof UserDetailsImpl) {
                    UserDetailsImpl authUserEntity = (UserDetailsImpl) principal
                    UserEntity = authUserEntity.getUser()
                }
            }
        }
        return UserEntity
    }

    static Authentication signInUser(UserEntity userEntity) {
        List<GrantedAuthority> roles = getRoles(userEntity)
        UserDetailsImpl springSecurityUserEntity = new UserDetailsImpl(userEntity, roles)
        Authentication authentication = new UsernamePasswordAuthenticationToken(springSecurityUserEntity, userEntity.getPassword(), roles)
        SecurityContextHolder.getContext().setAuthentication(authentication)
        return authentication
    }

    static List<GrantedAuthority> getRoles(UserEntity userEntity) {
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>()
//        roles.add(new GrantedAuthority("ROLE_User"))
        return roles
    }
}