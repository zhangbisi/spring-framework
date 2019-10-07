package com.zhuri.web.service;

import com.zhuri.web.dao.entity.UpmsUser;
import com.zhuri.web.dao.entity.UpmsUserExample;

import java.util.List;

/**
 * @author :
 * @create : 2019-08-17 18:39
 * @description :
 */
public interface UpmsUserService {

    UpmsUser selectByPrimaryKey(Integer id);

    List<UpmsUser> selectByExample(UpmsUserExample example);

    UpmsUser createUser(UpmsUser upmsUser);
}
