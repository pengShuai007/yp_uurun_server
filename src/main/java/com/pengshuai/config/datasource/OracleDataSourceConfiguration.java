package com.pengshuai.config.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by YangPeng on 2019/1/21.
 */
@Configuration
@MapperScan(basePackages = "com.pengshuai.oracle.*.dao",sqlSessionTemplateRef = "oracleSqlSessionTemplate")
public class OracleDataSourceConfiguration {

    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;
    @Value("${oracle_mapper_path}")
    private String oracleMapperPath;

    @Bean(name = "oracleDataSource")
    @ConfigurationProperties(prefix = "oracle.datasource")
    public DataSource mysqlDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="oracleSqlSessionFactory")
    public SqlSessionFactory createSqlSessionFactoryBean(@Qualifier("oracleDataSource") DataSource oracleDataSource)
            throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + oracleMapperPath;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        sqlSessionFactoryBean.setDataSource(oracleDataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "oracleDataSourceTransactionManager")
    public DataSourceTransactionManager oracleDataSourceTransactionManager(@Qualifier("oracleDataSource") DataSource oracleDataSource){
        return new DataSourceTransactionManager(oracleDataSource);
    }

    @Bean(name = "oracleSqlSessionTemplate")
    public SqlSessionTemplate oracleSqlSessionTemplate(@Qualifier("oracleSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }

}
