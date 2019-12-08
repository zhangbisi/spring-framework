package com.zhuri.annotation.upms.service;

import com.zhuri.annotation.upms.dao.model.UpmsLog;

import java.util.List;

/**
 * @author :
 * @create : 2019-05-24 14:27
 * @description :
 */
public interface UpmsLogService {
    /**
     * 根据主键查询记录
     * @param id
     * @return
     */
    UpmsLog selectByPrimaryKey(String id);

    /**
     * 根据主键删除记录
     * @param id
     * @return
     */
    Integer removeByPrimaryKey(String id);


	/**
	 *测试jdbc
	 * @return
	 */
	List<UpmsLog> getList();

	/**
	 * 测试mybatis
	 * @return
	 */
	List<UpmsLog> queryList();
}
