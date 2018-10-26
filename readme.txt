1. 新建springboot2工程，pom.xml 配置
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
   <modelVersion>4.0.0</modelVersion>

   <groupId>com.cz</groupId>
   <artifactId>mutil-data-source</artifactId>
   <version>0.0.1-SNAPSHOT</version>
   <packaging>jar</packaging>

   <name>mutil-data-source</name>
   <description>Demo project for Spring Boot</description>

   <parent>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-parent</artifactId>
      <version>2.0.6.RELEASE</version>
      <relativePath/> <!-- lookup parent from repository -->
   </parent>

   <properties>
      <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
      <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
      <java.version>1.8</java.version>
   </properties>

   <dependencies>
      <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-web</artifactId>
      </dependency>
      <!-- spring boot -->
      <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter</artifactId>
         <exclusions>
            <exclusion>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-logging</artifactId>
            </exclusion>
         </exclusions>
      </dependency>

      <!-- Swagger -->
      <dependency>
         <groupId>io.springfox</groupId>
         <artifactId>springfox-swagger-ui</artifactId>
         <version>2.9.2</version>
      </dependency>
      <dependency>
         <groupId>io.springfox</groupId>
         <artifactId>springfox-swagger2</artifactId>
         <version>2.9.2</version>
      </dependency>
      <!-- google java tool-->
      <dependency>
         <groupId>com.google.guava</groupId>
         <artifactId>guava</artifactId>
         <version>23.0</version>
      </dependency>
      <!-- json -->
      <dependency>
         <groupId>com.alibaba</groupId>
         <artifactId>fastjson</artifactId>
         <version>1.2.46</version>
      </dependency>

      <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-test</artifactId>
         <scope>test</scope>
      </dependency>

        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.2.3</version>
        </dependency>

      <!-- lombok -->
      <dependency>
         <groupId>org.projectlombok</groupId>
         <artifactId>lombok</artifactId>
         <scope>provided</scope>
      </dependency>

      <!-- log4j 2 -->
      <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-log4j2</artifactId>
      </dependency>

   </dependencies>

   <build>
      <plugins>
         <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
         </plugin>
      </plugins>
   </build>


</project>

2.swagger api 接口配置
package com.cz.mutildatasource.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 extends WebMvcConfigurationSupport {

    /**
     * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。
     * 需要重新指定静态资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cz.mutildatasource.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("多数据源测试管理 RESTful APIs")
                .description("多数据源-测试管理")
                //.termsOfServiceUrl("http://hwangfantasy.github.io/")
                .version("1.0")
                .build();
    }
}

3.多数据源配置
数据源1配置
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

数据源2配置
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

4.配置文件application.properties 配置
## 数据源配置
spring.datasource.db1.jdbc-url=jdbc:mysql://172.21.46.11:3306/hiaerrobot_device?useUnicode=true&characterEncoding=utf-8&useSSL=false
spring.datasource.db1.username=root
spring.datasource.db1.password=Www#1234
spring.datasource.db1.driver-class-name=com.mysql.jdbc.Driver

## 数据源配置2
spring.datasource.db2.jdbc-url=jdbc:mysql://172.21.46.11:3306/haierrobot_alarm?useUnicode=true&characterEncoding=utf-8&useSSL=false
spring.datasource.db2.username=root
spring.datasource.db2.password=Www#1234
spring.datasource.db2.driver-class-name=com.mysql.jdbc.Driver
## sql语句打印
logging.level.com.cz.mutildatasource.dao=debug
## PageHelper 配置
pagehelper.helper-dialect=MySql
pagehelper.reasonable=true
pagehelper.supportMethodsArguments=true
pagehelper.params=count=countSql

注意：数据库url配置在springboot2中需要调整为 jdbc-url