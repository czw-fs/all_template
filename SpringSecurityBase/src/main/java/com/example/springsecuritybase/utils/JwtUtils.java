package com.example.springsecuritybase.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.example.springsecuritybase.config.security.login.dto.UserLoginInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Integer expiration;

    public String createJwt(UserLoginInfo userLoginInfo){
        Date expireDate = new Date(System.currentTimeMillis() + expiration * 1000 * 60 * 60 * 24);
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                .withHeader(map)// 添加头部
                //可以将基本信息放到claims中
                .withClaim("userId", userLoginInfo.getUserId())//userId
                .withClaim("username", userLoginInfo.getUsername())//用户名
                .withClaim("sessionId", userLoginInfo.getSessionId())//会话id
                .withExpiresAt(expireDate) //超时设置,设置过期的日期
                .withIssuedAt(new Date()) //签发时间
                .sign(Algorithm.HMAC256(String.valueOf(secret))); //SECRET加密
        return token;
    }

    /**
     * 检查 JWT 是否过期
     * @param token
     * @return 如果 token 过期返回 true，否则返回 false
     */
    public boolean isTokenExpired(String token) {
        try {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
            Date expiration = decodedJWT.getExpiresAt();
            return expiration.before(new Date()); // 如果当前时间晚于过期时间，则返回 true
        } catch (Exception e) {
            log.error("检查 token 过期异常: " + e.getMessage());
            return true; // 如果验证过程中发生异常，假设 token 已过期
        }
    }

    /**
     * 获取token中的用户信息
     * @param token
     * @return
     */
    public UserLoginInfo getUserLoginInfoFromJwt(String token){

        if(!StringUtils.hasLength(token)){
            return null;
        }

        Map<String, Claim> map = getMapFromToken(token);
        if(map == null){
            return null;
        }

        Long userId = map.get("userId").asLong();
        String username = map.get("username").asString();
        String sessionId = map.get("sessionId").asString();

        return new UserLoginInfo()
                .setUserId(userId)
                .setUsername(username)
                .setSessionId(sessionId)
                ;
    }

    /**
     * 获取jwt中的所有参数
     * @param token
     * @return
     */
    public Map<String, Claim> getMapFromToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error("token解码异常");
        }
        return jwt.getClaims();
    }

}
