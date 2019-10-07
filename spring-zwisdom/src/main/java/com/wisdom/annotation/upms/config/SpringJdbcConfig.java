package com.wisdom.annotation.upms.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.wisdom.annotation.upms.dao.model.UpmsLog;
import com.wisdom.annotation.upms.interceptor.UpmsLogAspects;
import com.wisdom.annotation.upms.service.UpmsLogService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author :
 * @create : 2019-05-25 10:43
 * @description :
 *
 *
 */
@Configuration
@ComponentScan(value = "com.wisdom.annotation.upms.service")
public class SpringJdbcConfig {
    //切面类加入容器
    @Bean
    public UpmsLogAspects upmsLogAspects(){
        return new UpmsLogAspects();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
    	return jdbcTemplate;
	}

	@Bean
	public DruidDataSource dataSource(){
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/zheng");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return  dataSource;
	}

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
        UpmsLogService upmsLogService = applicationContext.getBean(UpmsLogService.class);
		List<UpmsLog> logs =  upmsLogService.getList();
		System.out.println(logs.size());
		System.out.println("logs = [" + logs.toArray() + "]");
    }

}
