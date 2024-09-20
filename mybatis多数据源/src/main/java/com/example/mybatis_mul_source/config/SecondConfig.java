package com.example.mybatis_mul_source.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Description: 主数据源配置
 */
@Configuration
@MapperScan(basePackages = "com.example.mybatis_mul_source.mapper2",
        sqlSessionTemplateRef = "secondSqlSessionTemplate")
public class SecondConfig {

    @Autowired
    @Qualifier("secondDataSource")
    private DataSource secondDataSource;

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory secondSqlSessionFacotory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(secondDataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/second/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "secondTransactionManager")
    public DataSourceTransactionManager secondTransactionManager() {
        return new DataSourceTransactionManager(secondDataSource);
    }

    @Bean(name = "secondSqlSessionTemplate")
    public SqlSessionTemplate secondSqlSessionTemplate(@Qualifier("secondSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}