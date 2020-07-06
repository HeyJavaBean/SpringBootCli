package com.imlehr.sudo.dao;


import com.imlehr.javabean.MyException;
import com.imlehr.utils.EncodingUtil;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lehr
 * @create: 2020-02-04
 */
@Repository
public class UserMapperMock {


    Map<String,String> data = new HashMap<>();

    {
        data.put("sudo",EncodingUtil.shiroPassword("123456","sudo"));
    }

    public String getPassword(String username)
    {
        return data.get(username);
    }

    @SneakyThrows
    public void addUser(String username,String password)
    {
        if(data.containsKey(username))
        {
            throw new MyException("用户名已占用","6789");
        }
        data.put(username,EncodingUtil.shiroPassword(password,username));
    }

}


