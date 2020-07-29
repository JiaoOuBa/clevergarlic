package com.dzp.clevergarlic.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.exception.GlobalException;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT token生成
 * @Auther ck
 * @Date 2020/7/28 18:34
 * @Desc
 */
@Service
public class AdminTokenService {

    //私钥
    public static final String SECRET = "sdjhakdhajdklsl;o653632";
    //过期时间:秒
    public static final int EXPIRE = 600;

    /**
     * 生成Token
     * @param adminId
     * @param userName
     * @return
     * @throws Exception
     */
    public static String createToken(Long adminId, String userName) throws Exception {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.SECOND, EXPIRE);
        Date expireDate = nowTime.getTime();

        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        String token = JWT.create()
                .withHeader(map)//头
                .withClaim("id", adminId)
                .withClaim("userName", userName)
                .withSubject("fc")
                .withIssuedAt(new Date())//签名时间
                .withExpiresAt(expireDate)//过期时间
                .sign(Algorithm.HMAC256(SECRET));//签名
        return token;
    }

    /**
     * 验证Token
     * @param token
     * @return
     */
    public static Map<String, Claim> verifyToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = null;
        try {
            jwt = verifier.verify(token);
        }catch (Exception e){
            throw new GlobalException(ExceptionMsg.LOGINOUT);
        }
        return jwt.getClaims();
    }

    /**
     * 解析Token
     * @param token
     * @return
     */
    public static Map<String, Claim> parseToken(String token){
        try {

            DecodedJWT decodedJWT = JWT.decode(token);
            return decodedJWT.getClaims();
        } catch (JWTDecodeException e) {
            throw new GlobalException(ExceptionMsg.LOGINOUT);
        }
    }
}
