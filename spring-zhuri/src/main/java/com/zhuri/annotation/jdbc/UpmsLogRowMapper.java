package com.zhuri.annotation.jdbc;

import com.zhuri.annotation.upms.dao.model.UpmsLog;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author :
 * @create : 2019-06-12 11:39
 * @description :
 */
public class UpmsLogRowMapper implements RowMapper {
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		int logId = rs.getInt("log_id");
		/**
		 * 操作描述
		 *
		 * @mbg.generated
		 */
		String description = rs.getString("description");
		/**
		 * 操作用户
		 *
		 * @mbg.generated
		 */
		String username = rs.getString("username");

		/**
		 * 操作时间
		 *
		 * @mbg.generated
		 */
		Long startTime = rs.getLong("start_time");

		/**
		 * 消耗时间
		 *
		 * @mbg.generated
		 */
		Integer spendTime = rs.getInt("spend_time");

		/**
		 * 根路径
		 *
		 * @mbg.generated
		 */
		String basePath = rs.getString("base_path");

		/**
		 * URI
		 *
		 * @mbg.generated
		 */
		String uri = rs.getString("uri");

		/**
		 * URL
		 *
		 * @mbg.generated
		 */
		String url = rs.getString("url");

		/**
		 * 请求类型
		 *
		 * @mbg.generated
		 */
		String method = rs.getString("method");

		/**
		 * 用户标识
		 *
		 * @mbg.generated
		 */
		String userAgent  = rs.getString("user_agent");

		/**
		 * IP地址
		 *
		 * @mbg.generated
		 */
		String ip = rs.getString("ip");

		/**
		 * 权限值
		 *
		 * @mbg.generated
		 */
		String permissions  = rs.getString("permissions");

		String parameter  = rs.getString("parameter");
		String result = rs.getString("result");
		UpmsLog log = new UpmsLog();
		log.setLogId(logId);
		log.setBasePath(basePath);
		log.setDescription(description);
		log.setIp(ip);
		log.setMethod(method);
		log.setParameter(parameter);
		log.setPermissions(permissions);
		log.setResult(result);
		log.setSpendTime(spendTime);
		log.setStartTime(startTime);
		log.setUrl(url);
		log.setUri(uri);
		log.setUserAgent(userAgent);
		return log;
	}
}
