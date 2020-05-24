package com.imlehr.security;


import com.imlehr.javabean.MyException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Lehr
 * @create: 2020-02-10
 */
@Slf4j
public class CustomSessionManager extends DefaultWebSessionManager {


    @Override
    public Serializable getSessionId(SessionKey key) {
        Serializable sessionId = key.getSessionId();
        if (sessionId == null) {
            HttpServletRequest request = WebUtils.getHttpRequest(key);
            HttpServletResponse response = WebUtils.getHttpResponse(key);
            return this.getSessionId(request, response);
        }

        return sessionId;
    }

    @SneakyThrows
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {

        String token = WebUtils.toHttp(request).getHeader("token");
        log.info("会话管理器得到的token是：\n" + token);
        //如果失效or没有token则被认为是匿名未登录状态
        if (token == null || token.length() < 1 || !JwtUtils.verifyToken(token)) {
            return UUID.randomUUID().toString();
        }


        //通过了则是找到对应的已登录用户
        String sessionId = JwtUtils.getClaimByName(token, "sessionId").asString();
        String userId = JwtUtils.getAudience(token);

        System.out.println(sessionId);

        request.setAttribute("userId", userId);


        request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "header");
        request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, token);
        request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
        request.setAttribute(ShiroHttpServletRequest.SESSION_ID_URL_REWRITING_ENABLED, isSessionIdUrlRewritingEnabled());

        return sessionId;
    }


}
