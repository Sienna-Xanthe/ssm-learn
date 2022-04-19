package com.itheima.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//<!--    加载外部的properties文件-->
//<!--    <context:property-placeholder location="classpath:jdbc.properties"/>-->
//@PropertySource("classpath:jdbc.properties")//因为idea原因加载不了这个文件，所以我还是用的直接赋值
public class DataSourceConfiguration {
//    @Value("${jdbc.driver}")
//    private String driver;
//    @Value("${jdbc.url}")
//    private String url;
//    @Value("${jdbc.username}")
//    private String username;
//    @Value("${jdbc.password}")
//    private String password;

    @Value("com.mysql.cj.jdbc.Driver")
    private String driver;
    @Value("jdbc:mysql://47.99.74.187:3306/login")
    private String url;
    @Value("Login")
    private String username;
    @Value("root")
    private String password;




    @Bean("dataSource") //Spring会将当前方法的返回值以指定名称存储到Spring容器中
    public DataSource getDatasource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);//?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
