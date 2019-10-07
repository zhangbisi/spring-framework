package com.wisdom.annotation.upms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

/**
 * @author :
 * @create : 2019-01-02 9:39
 * @description :
 */

@PropertySource("classpath:application.properties")
@Configuration
public class ProfileConfig implements EmbeddedValueResolverAware {

    /**
     * 方法一： @Value + ${}
     */
    @Value("${redis.maxIdle}")
    private int maxIdle;

    private long maxWaitMillis;

    private int maxTotal;

    private String  hostName;

    private int port;

    private String password;

	/**
	 * 方法二：
	 *      1、实现EmbeddedValueResolverAware
	 *      获取值
	 *      2、String password1 = valueResolver.resolveStringValue("${redis.password}");
	 */
	private StringValueResolver valueResolver;


    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver = resolver;
    }





	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public long getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(long maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public StringValueResolver getValueResolver() {
		return valueResolver;
	}

	public void setValueResolver(StringValueResolver valueResolver) {
		this.valueResolver = valueResolver;
	}
}
