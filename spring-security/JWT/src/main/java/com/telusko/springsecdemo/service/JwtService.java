package com.telusko.springsecdemo.service;

import com.telusko.springsecdemo.exception.JwtException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET = "TmV3U2VjcmV0S2V5Rm9ySldUU2lnbmluZ1B1cnBvc2VzMTIzNDU2Nzg=\r\n";

    private String secretKey;

    public JwtService(){
        secretKey = generateSecretKey();
    }

    public String generateSecretKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGen.generateKey();
            System.out.println("Secret Key : " + secretKey.toString());
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating secret key", e);
        }
    }

    public String generateToken(String username) {

        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*30))
                .signWith(getKey(), SignatureAlgorithm.HS256).compact();

    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUserName(String token) {
        try {
            return extractClaim(token, Claims::getSubject);
        } catch (JwtException e) {
            throw e;
        } catch (Exception e) {
            throw new JwtException("Failed to extract username from token", "EXTRACT_ERROR", e);
        }
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        try {
            if (token == null || token.isEmpty()) {
                throw new JwtException("Token cannot be null or empty", "INVALID_TOKEN");
            }
            return Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build().parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw new JwtException("JWT token has expired", "EXPIRED_TOKEN", e);
        } catch (UnsupportedJwtException e) {
            throw new JwtException("JWT token is not supported", "UNSUPPORTED_TOKEN", e);
        } catch (MalformedJwtException e) {
            throw new JwtException("Invalid JWT token format", "MALFORMED_TOKEN", e);
        } catch (SignatureException e) {
            throw new JwtException("JWT signature validation failed", "INVALID_SIGNATURE", e);
        } catch (IllegalArgumentException e) {
            throw new JwtException("JWT claims string is empty", "EMPTY_CLAIMS", e);
        } catch (JwtException e) {
            throw e;
        } catch (Exception e) {
            throw new JwtException("An error occurred while parsing JWT: " + e.getMessage(), "UNKNOWN_ERROR", e);
        }
    }


    public boolean validateToken(String token, UserDetails userDetails) {
        try {
            if (token == null || token.isEmpty()) {
                throw new JwtException("Token cannot be null or empty", "INVALID_TOKEN");
            }
            if (userDetails == null || userDetails.getUsername() == null) {
                throw new JwtException("User details cannot be null", "INVALID_USER");
            }

            final String userName = extractUserName(token);
            boolean isValid = userName.equals(userDetails.getUsername()) && !isTokenExpired(token);
            return isValid;
        } catch (JwtException e) {
            throw e;
        } catch (Exception e) {
            throw new JwtException("Token validation failed: " + e.getMessage(), "VALIDATION_ERROR", e);
        }
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
