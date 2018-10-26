package com.cz.mutildatasource.conf;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;

import javax.sql.DataSource;

@Configuration
//指定Mapper接口扫描路径和线程池
@MapperScan(basePackages = {"com.cz.mutildatasource.dao.mapper.db1"}, sqlSessionFactoryRef = "test1dbSqlSessionFactory")
public class Test1dbConfig {

    private final static Logger log = LoggerFactory.getLogger(Test1dbConfig.class);

    @Primary
    @Bean(name = "db1")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "test1dbTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("db1") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "test1dbSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("db1") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("com.cz.mutildatasource.entity");
        //指定Mapper xml扫描路径
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/db1/*.xml"));
        return factoryBean.getObject();
    }
}
