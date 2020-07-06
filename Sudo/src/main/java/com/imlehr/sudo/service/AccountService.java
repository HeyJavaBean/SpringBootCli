package com.imlehr.sudo.service;

import com.imlehr.security.CredentialsService;
import com.imlehr.sudo.dao.UserMapperMock;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lehr
 * @create: 2020-05-24
 */
@Slf4j
@Service
public class AccountService{

    @Autowired
    private UserMapperMock userMapper;

    @SneakyThrows
    public void register(String username,String password) {

        userMapper.addUser(username,password);

    }


}
