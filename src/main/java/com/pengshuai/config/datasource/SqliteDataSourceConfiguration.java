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
 * Created by YangPeng on 2019/6/6.
 */
@Configuration
@MapperScan(basePackages = "com.pengshuai.sqlite.*.dao",sqlSessionTemplateRef = "sqliteSqlSessionTemplate")
public class SqliteDataSourceConfiguration {

    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;
    @Value("${sqlite_mapper_path}")
    private String sqliteMapperPath;

    @Bean(name = "sqliteDataSource")
    @ConfigurationProperties(prefix = "sqlite.datasource")
    public DataSource sqliteDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="sqliteSqlSessionFactory")
    public SqlSessionFactory createSqlSessionFactoryBean(@Qualifier("sqliteDataSource") DataSource sqliteDataSource)
            throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + sqliteMapperPath;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        sqlSessionFactoryBean.setDataSource(sqliteDataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "sqliteDataSourceTransactionManager")
    public DataSourceTransactionManager sqliteDataSourceTransactionManager(@Qualifier("sqliteDataSource") DataSource sqliteDataSource){
        return new DataSourceTransactionManager(sqliteDataSource);
    }

    @Bean(name = "sqliteSqlSessionTemplate")
    public SqlSessionTemplate sqliteSqlSessionTemplate(@Qualifier("sqliteSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }
}
