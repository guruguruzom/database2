package com.guruguruzom.dbc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableTransactionManagement
public class WebConfiguration {
	
//	
//	@Bean
//	@ConfigurationProperties(prefix = "spring.datasource.hikari")
//	public HikariConfig hikariConfig() {
//		return new HikariConfig();
//	}
//	
//	@Bean
//	public DataSource dataSource() {
//		DataSource dataSource = new HikariDataSource(hikariConfig());
//		return dataSource;
//	}
//	
//	@Bean("userTransactionManager")
//	public DataSourceTransactionManager transactionManager() {
//   		return new DataSourceTransactionManager(dataSource());
//   	}
//
//	@Bean("userMapperScannerConfigurer")
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//		
//    	MapperScannerConfigurer mapperScannerConfigurerBean = new MapperScannerConfigurer();
//    	mapperScannerConfigurerBean.setSqlSessionFactoryBeanName("userSqlSessionFactory");
//    	mapperScannerConfigurerBean.setBasePackage("com.guruguruzom.dbc.mapper");
//    	return mapperScannerConfigurerBean;
//    }
//	
//	@Bean("userSqlSessionFactory")
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//		sessionFactoryBean.setDataSource(dataSource);
//		sessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
//		return sessionFactoryBean.getObject();
//	}
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSource() {
		DataSource dataSource = new HikariDataSource(hikariConfig());
		log.info("datasource : {}", dataSource);
		return dataSource;
	}
	
	@Primary
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
   	}
	
	@Autowired
	private ApplicationContext applicationContext;

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		//sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
