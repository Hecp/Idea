package com.hcp.sharding.jdbc.config;

import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.InlineShardingStrategyConfiguration;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hcp on 2018/5/19.
 */
//@Configuration
public class DatasourceConfig {
    @Bean
    public DataSource getDataSource() throws SQLException {
        return buildDataSource();
    }

    private DataSource buildDataSource() throws SQLException {
        // 设置数据库
        Map<String, DataSource> dataSourceMap = new HashMap<>(1);
        dataSourceMap.put("ds_0", createDataSource("ds_0"));

        // 设置t_order表
        TableRuleConfiguration orderTableRuleConfiguration = new TableRuleConfiguration();
        orderTableRuleConfiguration.setLogicTable("t_order");
        orderTableRuleConfiguration.setActualDataNodes("ds_0.t_order_${0..1}");

        // 设置t_order表分表策略(order_id % 2)
        orderTableRuleConfiguration.setTableShardingStrategyConfig(
                new InlineShardingStrategyConfiguration("order_id", "t_order_${order_id % 2"));

        ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();
        shardingRuleConfiguration.getTableRuleConfigs().add(orderTableRuleConfiguration);


        DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfiguration,
                new ConcurrentHashMap<>(16), new Properties());
        return dataSource;
    }

    private DataSource createDataSource(String dbName) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        dataSource.setUrl("jdbc:mysql://localhost:3306/" + dbName);
        dataSource.setUsername("root");
        dataSource.setPassword("hcp0113@@");
        return dataSource;
    }
}
