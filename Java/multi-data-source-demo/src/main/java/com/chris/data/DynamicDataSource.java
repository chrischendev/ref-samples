package com.chris.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chrischan
 * create on 2019\7\18 0018 16:15
 * use for:
 */
@Component
@Primary
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Autowired
    @Qualifier("selectDataSource")
    DataSource selectDataSource;

    @Autowired
    @Qualifier("updateDataSource")
    DataSource updateDataSource;

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDbType();
    }

    @Override
    public void afterPropertiesSet() {
        Map<Object, Object> map = new HashMap<>();

        map.put("selectDataSource", selectDataSource);
        map.put("updateDataSource", updateDataSource);

        setTargetDataSources(map);
        setDefaultTargetDataSource(updateDataSource);//默认
        super.afterPropertiesSet();
    }
}
