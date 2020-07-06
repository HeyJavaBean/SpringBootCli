package com.imlehr.sudo.service;

import com.imlehr.javabean.MyException;
import com.imlehr.security.CredentialsService;
import com.imlehr.sudo.dao.UserMapperMock;
import com.imlehr.utils.EncodingUtil;
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
public class CredentialsServiceImpl implements CredentialsService {

    @Autowired
    private UserMapperMock userMapper;

    @Override
    @SneakyThrows
    public String getCredentials(String username) {

        return userMapper.getPassword(username);

    }


}
