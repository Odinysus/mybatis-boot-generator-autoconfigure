package com.odinysus.mybatisboot.generator.autoconfigure;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author odinysus
 */
@ConfigurationProperties(
        prefix = "spring.datasource"
)
@AutoConfigureBefore({DatabaseProperties.class})
public class DataSourceProperties {
    private String url;
    /**
     * 驱动名称
     */
    private String driverClassName = "com.mysql.jdbc.Driver" ;
    /**
     * 数据库连接用户名
     */
    private String username;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 数据库连接密码
     */
    private String password;
}
