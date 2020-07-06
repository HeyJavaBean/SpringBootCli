package com.imlehr.security;

import com.imlehr.javabean.MyException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Lehr
 * @create: 2020-05-24
 */
@Slf4j
public class CredentialsServiceImpl implements CredentialsService {


    @Override
    @SneakyThrows
    public String getCredentials(String username) {

        log.warn("您需要自己指定一个用户密码的获取方式!!!!自己写一个实现了CredentialsService的类");
        throw new MyException("后台爆炸", "9999");

    }


}
