package com.zhuri.web.service.impl;

import com.zhuri.web.dao.entity.UpmsUser;
import com.zhuri.web.dao.entity.UpmsUserExample;
import com.zhuri.web.service.UpmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :
 * @create : 2019-08-17 18:39
 * @description :
 */
@Service
public class UpmsUserServiceImpl implements UpmsUserService {
    @Override
    public UpmsUser selectByPrimaryKey(Integer id) {
        UpmsUser user = new UpmsUser();
        user.setUserId(1);
        user.setUsername("zhangbs");
        return user;
    }

    @Override
    public List<UpmsUser> selectByExample(UpmsUserExample example) {
        return null;
    }

    @Override
    public UpmsUser createUser(UpmsUser upmsUser) {
        return null;
    }



/*
    @Autowired
    UpmsUserMapper upmsUserMapper;


    @Override
    public UpmsUser selectByPrimaryKey(Integer id) {
        return upmsUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UpmsUser> selectByExample(UpmsUserExample example) {
        return upmsUserMapper.selectByExample(example);
    }

    @Override
    public UpmsUser createUser(UpmsUser upmsUser) {
        UpmsUserExample upmsUserExample = new UpmsUserExample();
        upmsUserExample.createCriteria()
                .andUsernameEqualTo(upmsUser.getUsername());
        long count = upmsUserMapper.countByExample(upmsUserExample);
        if (count > 0) {
            return null;
        }
        upmsUserMapper.insert(upmsUser);
        return upmsUser;
    }

   */

}
