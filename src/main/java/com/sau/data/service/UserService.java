package com.sau.data.service;

import com.sau.data.entity.UserDO;

import java.security.NoSuchAlgorithmException;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 22:24 2020/12/18
 * @Modified By:
 */
public interface UserService {


    UserDO selectByNumber(Long loginNumber, String password) throws NoSuchAlgorithmException;


}
