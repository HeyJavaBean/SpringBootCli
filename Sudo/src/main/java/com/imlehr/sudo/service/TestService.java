package com.imlehr.sudo.service;

import com.imlehr.security.CredentialsService;
import com.imlehr.sudo.dao.TestMapper;
import com.imlehr.utils.EncodingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lehr
 * @create: 2020-05-24
 */
@Service
public class TestService implements CredentialsService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public String getCredentials(String username) {
        String credentials = EncodingUtil.shiroPassword("Lehr","123");
        return credentials;
    }

    public Integer getNum()
    {
        return testMapper.getNum();
    }
}
