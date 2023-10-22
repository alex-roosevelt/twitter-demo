package com.fake.twitter.config.security.jwt

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.fake.twitter.model.entity.UserEntity
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager

    @Value('${auth.expiration-time}')
    public long EXPIRATION_TIME // 15 mins
    @Value('${auth.secret}')
    public String SECRET


    JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager
        setFilterProcessesUrl("/api/v1/authenticate")
    }

    @Override
    Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) {
        try {
            UserEntity creds = new ObjectMapper().readValue(req.getInputStream(), UserEntity)

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.username,
                            creds.password,
                            new ArrayList<>())
            )
        } catch (IOException e) {
            throw new RuntimeException(e)
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException {
        UserDetails userDetails = (UserDetails) auth.getPrincipal()

        String token = JWT.create()
                .withSubject(userDetails.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET.getBytes()))


        res.getWriter().write(token)
        res.getWriter().flush()
    }
}
