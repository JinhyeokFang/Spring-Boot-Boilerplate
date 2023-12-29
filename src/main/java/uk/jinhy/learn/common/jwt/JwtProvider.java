package uk.jinhy.learn.common.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtProvider {

    @Value("${spring.security.jwt.secret}")
    private String secret;

    private SecretKey key;

    @PostConstruct
    protected void init() {
        key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    // JWT 토큰 생성
    public String createToken(JwtType jwtType, String email) {
        Date now = new Date();
        Claims claims = Jwts.claims()
                .subject(jwtType.toString())
                .issuedAt(now)
                .expiration(new Date(now.getTime() + 24 * 60 * 60 * 1000))
                .build();
        claims.put("email", email);
        return Jwts.builder()
                .claims(claims)
                .signWith(key)
                .compact();
    }

    public Claims parseJwtToken(String token) throws Exception {
        try {
            return Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (Exception e) {
            throw new Exception("잘못된 토큰입니다.");
        }
    }
}
