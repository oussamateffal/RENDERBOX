package com.renderbox.renderboxporoject.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "votre_cle_secrete";

    public static String generateToken(String email) {
        Date expirationDate = new Date(System.currentTimeMillis() + 86400000); // 24 hours expiration
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
