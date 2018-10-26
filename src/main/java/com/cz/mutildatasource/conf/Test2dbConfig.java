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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
//指定Mapper接口扫描路径和线程池
@MapperScan(basePackages = {"com.cz.mutildatasource.dao.mapper.db2"}, sqlSessionFactoryRef = "test2dbSqlSessionFactory")
public class Test2dbConfig {

    private final static Logger log = LoggerFactory.getLogger(Test2dbConfig.class);

    @Bean(name = "db2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "test2dbTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("db2") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "test2dbSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("db2") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("com.cz.mutildatasource.entity");
        //指定Mapper xml扫描路径
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/db2/*.xml"));
        return factoryBean.getObject();
    }
}
