package com.imlehr.security;

import com.imlehr.utils.EncodingUtil;

/**
 * @author Lehr
 * @create: 2020-05-24
 */
public interface CredentialsService {

    /**
     * 获取db里的密码的操作
     * @param username
     * @return
     */
    String getCredentials(String username);

}
