package com.imlehr.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.imlehr.javabean.MyException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Lehr
 * @create: 2020-02-04
 */
@Slf4j
public class JwtUtils {

    private static final String KEY = "Hello";

    /**
     签发对象：这个用户的id
     签发时间：现在
     有效时间：30分钟
     载荷内容：id
     密钥：这个人的真名（这样设计不太好）
     */
    public static String createToken(String userId) {

        //暂时没有想好怎么更方便的设计载荷
        String sessionId = SecurityUtils.getSubject().getSession().getId().toString();
        Integer expireMinute = 30;
        //目前默认audience和userId是一样的

        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,expireMinute);
        Date expiresDate = nowTime.getTime();

        return JWT.create().withAudience(userId)
                .withIssuedAt(new Date())
                .withExpiresAt(expiresDate)
                .withClaim("sessionId", sessionId)
                .withClaim("userId", userId)
                .sign(Algorithm.HMAC256(KEY));
    }

    /**
     * 检验合法性
     * @param token
     *
     */
    @SneakyThrows
    public static boolean verifyToken(String token){

        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(KEY)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            //效验失败
            log.warn("JWT无效");
            return false;
        }
        return true;
    }

    @SneakyThrows
    public static String getAudience(String token){
        String audience = null;
        try {
            audience = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            //这里是token解析失败
            throw new MyException("JWT无效","1234");
        }
        return audience;
    }


    public static Claim getClaimByName(String token, String name){
        return JWT.decode(token).getClaim(name);
    }
}
