package com.wisdom.annotation.upms.service.impl;

import com.wisdom.annotation.jdbc.UpmsLogRowMapper;
import com.wisdom.annotation.upms.dao.model.UpmsLog;
import com.wisdom.annotation.upms.service.UpmsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :
 * @create : 2019-05-24 14:28
 * @description :
 */
@Service
public class UpmsLogServiceImpl implements UpmsLogService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	//@Autowired
	//private UpmsLogMapper upmsLogMapper;

    @Override
    public UpmsLog selectByPrimaryKey(String id) {
        return new UpmsLog();
    }

    @Override
    public Integer removeByPrimaryKey(String id) {
        return 5;
    }

	@Override
	public List<UpmsLog> getList() {
    	String sql = "SELECT * from upms_log";
		List<UpmsLog> upmsLogs = jdbcTemplate.query(sql,new UpmsLogRowMapper());
		return upmsLogs;
	}

	@Override
	public List<UpmsLog> queryList() {
		//return upmsLogMapper.queryList();
		return null;
	}


}
