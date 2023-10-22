package com.fake.twitter.config.security.jwt

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public static final String HEADER_STRING = "Authorization"
    public static final String TOKEN_PREFIX = "Bearer "
    @Value('${auth.secret}')
    public String SECRET


    JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager)
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_STRING)

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res)
            return
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req)

        SecurityContextHolder.context.authentication = authentication
        chain.doFilter(req, res)
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING)

        if (token != null) {
            // parse the token.
            String user = JWT.require(Algorithm.HMAC512(SECRET.bytes))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .subject

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>())
            }

            return null
        }

        return null
    }
}
