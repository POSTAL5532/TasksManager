package com.tasksmanager.service.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;

/**
 * JWT utils class
 *
 * @author SIE
 */
@Component
public class JwtTokenProvider {

    public static final String TOKEN_START_WITH = "Bearer ";

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInSec}")
    private int jwtExpirationInSec;

    /**
     * Generate token base on user principal from authentication
     *
     * @param authentication authentication
     * @return token
     */
    public String generateToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Date expiryDate = new Date(new Date().getTime() + (jwtExpirationInSec * 1000));

        return Jwts.builder()
            .setSubject(userPrincipal.getId())
            .setIssuedAt(new Date())
            .setExpiration(expiryDate)
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact();
    }

    /**
     * Return user ID from token.
     *
     * @param token token
     * @return user ID
     */
    public String getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
            .setSigningKey(jwtSecret)
            .parseClaimsJws(token)
            .getBody();

        return claims.getSubject();
    }

    /**
     * Validate token.
     *
     * @param token token
     * @return validate result
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }
        catch (SignatureException e) {
            logger.error("Invalid JWT signature");
        }
        catch (MalformedJwtException e) {
            logger.error("Invalid JWT token");
        }
        catch (ExpiredJwtException e) {
            logger.error("Expired JWT token");
        }
        catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token");
        }
        catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty.");
        }

        return false;
    }
}
