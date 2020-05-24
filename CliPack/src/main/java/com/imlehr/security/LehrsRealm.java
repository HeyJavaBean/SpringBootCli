package com.imlehr.security;

import com.imlehr.utils.EncodingUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Lehr
 * @create: 2020-02-05
 */
@Slf4j
public class LehrsRealm extends AuthorizingRealm {


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("开始授权");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        return info;

    }

    @Autowired
    private CredentialsService authenticationManager;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        //加点盐，就懒得用每个用户的id去加盐了
        ByteSource salt = EncodingUtil.getSalt();

        //从数据库里获得密码
        String credentials = authenticationManager.getCredentials(token.getUsername());

        Object principal = new Object();


        //自动用credentials去和token里的密码对比
        return new SimpleAuthenticationInfo(principal,credentials,salt,getName());

    }
}
