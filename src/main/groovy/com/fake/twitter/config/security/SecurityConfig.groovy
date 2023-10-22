package com.fake.twitter.config.security

import com.fake.twitter.config.security.details.UserDetailsServiceImpl
import com.fake.twitter.config.security.jwt.JWTAuthenticationFilter
import com.fake.twitter.config.security.jwt.JWTAuthorizationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsServiceImpl userDetailsService

    static String SIGN_IN_URL = "/api/v1/auth"
    static String SIGN_UP_URL = "/api/v1/registration/**"
    static String SWAGGER_URL = "/swagger-ui/"
    static String SWAGGER_RESOURCES = "/swagger-resources/**"
    static String SWAGGER_API_DOCS = "/v2/api-docs/**"

    SecurityConfig(UserDetailsServiceImpl userDetailsService
    ) {
        this.userDetailsService = userDetailsService
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(SWAGGER_URL, SWAGGER_RESOURCES, SWAGGER_API_DOCS, SIGN_UP_URL, SIGN_IN_URL).permitAll()
                .antMatchers("/api/v1/comment/**", "/api/v1/post/**", "/api/v1/users/**").authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder()
    }

    @Override
    void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder())
    }


    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource()

        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues()
        source.registerCorsConfiguration("/**", corsConfiguration)

        return source
    }
}
