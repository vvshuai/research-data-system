package com.sau.data.service.impl;

import com.sau.data.dao.TagDOMapper;
import com.sau.data.dao.UserDOMapper;
import com.sau.data.entity.TagDO;
import com.sau.data.entity.UserDO;
import com.sau.data.exception.SystemException;
import com.sau.data.service.UserService;
import com.sau.data.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 22:30 2020/12/18
 * @Modified By:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDOMapper userDOMapper;

    @Autowired
    TagDOMapper tagDOMapper;

    @Override
    public UserDO selectByNumber(Long loginNumber, String password) throws NoSuchAlgorithmException {
        UserDO userDO = userDOMapper.selectByNumber(loginNumber);

        if(userDO == null) {
            throw new SystemException("111", "请输入正确的学号/教师号");
        }

        if(!MD5Utils.getMd5_16(password).equals(userDO.getPassword())) {
            throw new SystemException("222", "密码错误");
        }

        return userDO;
    }

    @Override
    public boolean addTag(String tagName) {
        TagDO tagDO = new TagDO();
        tagDO.setTagName(tagName);
        int i = tagDOMapper.insertSelective(tagDO);
        if(i <= 0) {
            throw new SystemException("-1", "插入失败");
        }
        return true;
    }
}
