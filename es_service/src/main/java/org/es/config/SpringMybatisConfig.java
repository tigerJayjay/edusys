package org.es.config;

import java.util.Properties;

import javax.sql.DataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;



@Configuration
@ComponentScan(basePackages={"org.es.dao","org.es.service","org.es.shiro.ream"})
@MapperScan(basePackages={"org.es.dao"})
public class SpringMybatisConfig {
	@Value("com.mysql.jdbc.Driver")
	private  String driverClassName="com.mysql.jdbc.Driver";  
	@Value("${url}")
    private  String url="jdbc:mysql://localhost:3306/edusys"; 
	@Value("${username}")
    private  String username="root";  
	@Value("${password}")
    private  String password="123456";  
    /**
     * druid数据源
     * @return
     */
    @Bean(destroyMethod = "close")  
    public DataSource dataSource() {   
    	DruidDataSource dataSource = new DruidDataSource();  
        dataSource.setDriverClassName(driverClassName);  
        dataSource.setUrl(url);  
        dataSource.setUsername(username);  
        dataSource.setPassword(password); 
        return dataSource;  
    }  
    /**
     * 加载配置文件
     * @return
     */
    @Bean
    public PropertySourcesPlaceholderConfigurer placeholer(){
    	PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
    	return pspc;
    }
    /**
     * 事务管理器
     * @return
     */
    @Bean(name="transactionManager")  
    public DataSourceTransactionManager txManager() {  
        return new DataSourceTransactionManager(dataSource());  
    }  
    
    @Bean(name="sqlSessionFactory")  
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {  
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();  
        sessionFactory.setDataSource(dataSource()); 
        sessionFactory.setTypeAliasesPackage("org.es.model");
        Interceptor[] plugins =  new Interceptor[]{pageHelper()};
        sessionFactory.setPlugins(plugins);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath*:mapper/*Mapper.xml"));
        return sessionFactory; 
    }  
    /**
     * 设置pageHelper分页插件
     * @return
     */
    @Bean
    public PageInterceptor pageHelper(){
    	PageInterceptor ph = new PageInterceptor();
    	Properties prop = new Properties();
    	prop.setProperty("helperDialect", "mysql");
    	ph.setProperties(prop);
    	return ph;
    }
    /**
     * 根据Mapper文件创建dao实现类对象
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("/mapper");
        return mapperScannerConfigurer;
    }
}
