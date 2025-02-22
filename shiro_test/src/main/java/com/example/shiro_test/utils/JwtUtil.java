package com.example.shiro_test.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Data
@Component
public class JwtUtil {

    @Value("jwt.secret")
    private String secret;
    private Integer expire = 888;

    /**
     * 生成token
     */
    public String createJwtToken(Long id) {
        Date date = Date.from(LocalDateTime.now().plusSeconds(expire).toInstant(ZoneOffset.ofHours(8)));
        Algorithm algorithm = Algorithm.HMAC256(secret);    //使用密钥进行哈希
        return JWT.create()
                .withClaim("id", id)//用户id
                .withExpiresAt(date)  //过期时间
                .sign(algorithm);     //签名算法
    }

    /**
     * 校验token是否正确
     */
    public boolean verifyToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256(secret))
                    .build()
                    .verify(token);
            return true;
        } catch (JWTVerificationException | IllegalArgumentException e) {
            return false;
        }

    }

    /**
     * 在token中获取到username信息
     */
    public Long getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("id").asLong();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 判断是否过期
     */
    public boolean isExpire(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getExpiresAt().getTime() < System.currentTimeMillis();
    }
}