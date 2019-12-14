package com.chris.data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author chrischan
 * create on 2019\7\18 0018 16:10
 * use for:
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "selectDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.select")
    public DataSource selectDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "updateDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.update")
    public DataSource updateDataSource() {
        return DataSourceBuilder.create().build();
    }
}
