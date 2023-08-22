package com.roua.roua.security.utility;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.security.Key;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {
    // @Value("${jwt.secret}")
    private final String secret = "QjBXHBWN4Rmq5gohmVJnKX5/nHljQ3YhqeZB0dKXUyoGVwfU4suFNaiHrrLvm6bIRtmLwB+SprTXWdeUm4OgFuNYVmH3JsDwUAXJAjjTAi7/M2iFoUl9o2iTFDj4y+uCxzqyWB/w/RLBb3ddcx+wZBKWH8lp0mZVey8mBrhafka9T2l1THjf1SYPDCud/CJhQzQFSvi826Uuvo2B6Tn8tujHbkfQ2rZBl6lepP3Won+Ixya9EZWJ+6PsjAvmj/GesIuEo0cNEIBJ/c+WqFVS7QHk+llzlHpcf8dIse0ODH2B0piYsbq+JuejVFMrb/RYE99Mhy1tm4nzXFHiG1SY2HpNuHJdQAnDEZjTkPwkQUw=";

        
    // @Value("${application.security.jwt.expiration}")
    // private long jwtExpiration;
    // @Value("${application.security.jwt.refresh-token.expiration}")
    // private long refreshExpiration;

    
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails) {
        return   Jwts 
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 604800000 ))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                // .setHeaderParam("typ", "JWT")
                .compact();
    }
    



    public String getSecret() {
        return secret;
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
   
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    // private Key getSignInKey() {
    //     // Generate a secure key using the secretKeyFor method
    //     return Keys.secretKeyFor(SignatureAlgorithm.HS256);
    // }
}
