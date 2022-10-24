package com.ch.nike.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.properties")
public class DataBaseConfiguration {

	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	@Bean
	@ConfigurationProperties(prefix = "mybatis.configuration")
	public org.apache.ibatis.session.Configuration mybatisConfig() {
		return new org.apache.ibatis.session.Configuration();
	}
	
	@Bean
	public DataSource dataSource() {
		DataSource ds = new HikariDataSource(hikariConfig());
		return ds;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		ssfb.setDataSource(ds);
		ssfb.setMapperLocations(applicationContext.getResources("classpath:/mapper/sql-*.xml"));
		ssfb.setConfiguration(mybatisConfig());
		ssfb.setTypeAliasesPackage("com.ch.nike.dto");
		return ssfb.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sst(SqlSessionFactory ssf) {
		return new SqlSessionTemplate(ssf);
	}
}
