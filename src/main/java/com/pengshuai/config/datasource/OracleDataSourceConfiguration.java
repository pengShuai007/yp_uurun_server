package com.pengshuai.config.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;

/**
 * Created by YangPeng on 2019/1/21.
 */
@Configuration
@MapperScan("com.pengshuai.oracle.*.dao")
public class OracleDataSourceConfiguration {

    @Value("${jdbc.oracle.driver}")
    private String oracleJdbcDriver;
    @Value("${jdbc.oracle.url}")
    private String oracleJdbcUrl;
    @Value("${jdbc.oracle.username}")
    private String oracleJdbcUser;
    @Value("${jdbc.oracle.password}")
    private String oracleJdbcPassword;
    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;
    @Value("${oracle_mapper_path}")
    private String oracleMapperPath;
    @Value("${entity_package}")
    private String entityPackage;

    @Bean(name="oracleDataSource")
    public ComboPooledDataSource createOracleDataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledOracleDataSource = new ComboPooledDataSource();
        comboPooledOracleDataSource.setDriverClass(oracleJdbcDriver);
        comboPooledOracleDataSource.setJdbcUrl(oracleJdbcUrl);
        comboPooledOracleDataSource.setUser(oracleJdbcUser);
        comboPooledOracleDataSource.setPassword(oracleJdbcPassword);
        comboPooledOracleDataSource.setAutoCommitOnClose(false);
        return comboPooledOracleDataSource;
    }

    @Bean(name="oracleSqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean(@Qualifier("oracleDataSource") DataSource oracleDataSource)
            throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + oracleMapperPath;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        sqlSessionFactoryBean.setDataSource(oracleDataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        return sqlSessionFactoryBean;
    }
}
