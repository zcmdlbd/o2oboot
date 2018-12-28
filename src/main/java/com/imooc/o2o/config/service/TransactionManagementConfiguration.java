package com.imooc.o2o.config.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;


/**
 * @author 萝卜丁
 * 继承TransactionManagementConfigurer开启事务
 */
@Configuration	
//首先使用注解@EnableTransactionManagement开启事务支持
//在service方法上添加@Transactional便可
@EnableTransactionManagement
public class TransactionManagementConfiguration implements TransactionManagementConfigurer {
	@Autowired
	private DataSource dataSource;
	
	@Override
	/**
	 * 事务管理
	 * */
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		
		return new DataSourceTransactionManager(dataSource);
	}

}
