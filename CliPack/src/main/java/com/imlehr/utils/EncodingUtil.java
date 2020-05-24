package com.imlehr.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class EncodingUtil {

    private static final ByteSource SALT = ByteSource.Util.bytes("Heeeeey");

    public static String shiroPassword(String password,String userId) {
        return new SimpleHash("MD5",password,SALT,1024).toString();
    }

    public static ByteSource getSalt()
    {
        return SALT;
    }
}