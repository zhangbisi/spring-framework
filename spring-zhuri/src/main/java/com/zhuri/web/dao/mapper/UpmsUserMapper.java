package com.zhuri.web.dao.mapper;

import com.zhuri.web.dao.entity.UpmsUser;
import com.zhuri.web.dao.entity.UpmsUserExample;

import java.util.List;

/**
 * @author :
 * @create : 2019-08-17 18:38
 * @description :
 */
public interface UpmsUserMapper {
    long countByExample(UpmsUserExample example);

    int deleteByExample(UpmsUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UpmsUser record);

    int insertSelective(UpmsUser record);

    List<UpmsUser> selectByExample(UpmsUserExample example);

    UpmsUser selectByPrimaryKey(Integer userId);

   //int updateByExampleSelective(@Param("record") UpmsUser record, @Param("example") UpmsUserExample example);

    //int updateByExample(@Param("record") UpmsUser record, @Param("example") UpmsUserExample example);

    int updateByPrimaryKeySelective(UpmsUser record);

    int updateByPrimaryKey(UpmsUser record);
}
