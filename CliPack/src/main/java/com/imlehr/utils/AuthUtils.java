package com.imlehr.utils;

import com.imlehr.javabean.MyException;
import com.imlehr.security.JwtUtils;
import lombok.SneakyThrows;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lehr
 * @create: 2020-05-24
 */
public class AuthUtils {

    @SneakyThrows
    public static void login(String username,String password)
    {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username, password));
        } catch (Exception e) {
            throw new MyException("登录失败","1234");
        }

    }

    public static String getUsername(HttpServletRequest request)
    {
        String token = request.getHeader("token");
        return JwtUtils.getClaimByName(token,"userId").toString();
    }

    public static void logout()
    {
        SecurityUtils.getSubject().logout();
    }
}
