package com.imlehr.sudo.service;

import com.imlehr.sudo.dao.UserMapperMock;
import com.imlehr.sudo.javabean.vo.AuthVO;
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
public class AuthService {


    @SneakyThrows
    public void updateAuth(String username, String province, String city, String district,
                           String block, String houseNo, String floor, String roomNo) {
    }

    @SneakyThrows
    public AuthVO getByUsername(String username) {
        return new AuthVO().setProvince("四川").setCity("成都").setBlock("沙河小区").setHouseNo("1").setFloor("18").setRoomNo("1802").setState("待审核").setUsername("1388225159");
    }



}
