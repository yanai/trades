package com.com.tikal.traders.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
public class BoneCPConfig {

    @Value("${bonecp.url}")
    private String jdbcUrl;

    @Value("${bonecp.username}")
    private String jdbcUsername;

    @Value("${bonecp.password}")
    private String jdbcPassword;

    @Value("${bonecp.driverClass}")
    private String driverClass;

    @Value("${bonecp.idleMaxAgeInMinutes:240}")
    private Integer idleMaxAgeInMinutes;
    		
    @Value("${bonecp.idleConnectionTestPeriodInMinutes:60}")
    private Integer idleConnectionTestPeriodInMinutes;

    @Value("${bonecp.maxConnectionsPerPartition:10}")
    private Integer maxConnectionsPerPartition;

    @Value("${bonecp.minConnectionsPerPartition:1}")
    private Integer minConnectionsPerPartition;

    @Value("${bonecp.partitionCount:2}")
    private Integer partitionCount;

    @Value("${bonecp.acquireIncrement:5}")
    private Integer acquireIncrement;

    @Value("${bonecp.statementsCacheSize:100}")
    private Integer statementsCacheSize;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        dataSource.setIdleConnectionTestPeriodInMinutes(idleConnectionTestPeriodInMinutes);
        dataSource.setIdleMaxAgeInMinutes(idleMaxAgeInMinutes);
        dataSource.setMaxConnectionsPerPartition(maxConnectionsPerPartition);
        dataSource.setMinConnectionsPerPartition(minConnectionsPerPartition);
        dataSource.setPartitionCount(partitionCount);
        dataSource.setAcquireIncrement(acquireIncrement);
        dataSource.setStatementsCacheSize(statementsCacheSize);
        return dataSource;
    }

}