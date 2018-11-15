package com.zhangxing.eshop;

import java.util.HashSet;
import java.util.Set;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * spring boot 启动类
 *
 */
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@MapperScan("com.zhangxing.eshop.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    /**
     * 配置文件设置参数
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
    	return new DataSource();	
    }
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception{
    	SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
    	sessionFactoryBean.setDataSource(dataSource());
    	PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    	sessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
    	return sessionFactoryBean.getObject();
    }
    @Bean
    public PlatformTransactionManager transactionManager(){
    	return new DataSourceTransactionManager(dataSource());
    }
    @Bean
    public JedisCluster JedisClusterFactory(){
    	Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		jedisClusterNodes.add(new HostAndPort("192.168.0.170", 7001));
		jedisClusterNodes.add(new HostAndPort("192.168.0.174", 7003));
		jedisClusterNodes.add(new HostAndPort("192.168.0.172", 7005));
		JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes);
		return jedisCluster;
    }
}
