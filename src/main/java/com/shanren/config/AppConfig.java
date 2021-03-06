package com.shanren.config;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;

import com.shanren.MybatisSqlSessionFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.shanren.repository,com.shanren.service")
public class AppConfig {
	
	@Bean
	//@Bean(name="datasource2")
	//@Order(10)
	public DataSource datasourc() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/worldssssss");
		ds.setUsername("root");
		ds.setPassword("root");

		return ds;
	}
	
	
	//@Bean(name="datasource2")
	@Bean
	//@Order(5)
	public DataSource datasource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/world");
		ds.setUsername("root");
		ds.setPassword("root");

		return ds;
	}

	

	@Bean
	public MapperScannerConfigurer mapper() {
		MapperScannerConfigurer cfg = new MapperScannerConfigurer();
		cfg.setSqlSessionFactoryBeanName("mybatis");
		cfg.setBasePackage("com.shanren.mapper");
		return cfg;
	}
	
	@Bean
	public MapperScannerConfigurer mapper1() {
		MapperScannerConfigurer cfg = new MapperScannerConfigurer();
		cfg.setSqlSessionFactoryBeanName("mybatis1");
		cfg.setBasePackage("com.shanren.mapper");
		return cfg;
	}

	@Bean
	public MybatisSqlSessionFactoryBean mybatis1(List<DataSource> list) {
		MybatisSqlSessionFactoryBean b = new MybatisSqlSessionFactoryBean();
		b.setDataSource(datasourc());
		b.setEnumBasePackages("com.shanren");
		b.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		return b;
	}
	
	@Bean
	public MybatisSqlSessionFactoryBean mybatis(List<DataSource> list) {
		MybatisSqlSessionFactoryBean b = new MybatisSqlSessionFactoryBean();
		b.setDataSource(datasource());
		b.setEnumBasePackages("com.shanren");
		b.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		return b;
	}

}
