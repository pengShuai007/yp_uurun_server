package com.pengshuai.config.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by YangPeng on 2019/1/23.
 */
@Configuration
public class TransactionManagementConfiguration {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Autowired
    @Qualifier("oracleDataSource")
    private DataSource oracleDataSource;

    @Bean(name="localMysql")
    public PlatformTransactionManager localMysqlManager(){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name="localOracle")
    public PlatformTransactionManager oracleManager(){
        return new DataSourceTransactionManager(oracleDataSource);
    }

//    @Override
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return new DataSourceTransactionManager(dataSource);
//    }
}
