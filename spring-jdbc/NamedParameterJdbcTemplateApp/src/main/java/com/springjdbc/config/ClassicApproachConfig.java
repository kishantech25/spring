package com.springjdbc.config;

import com.springjdbc.dao.StatatementDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class ClassicApproachConfig {

    @Autowired
    private Environment env;

    @Bean("statementDAO")
    public StatatementDAO getstatatementDAO(){
        return new StatatementDAO(getNamedParamJdbcTemplate());
    }


    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate template =new JdbcTemplate();
        template.setDataSource(dataSource());
        return template;
    }

    @Bean("namedParamJdbcTemplate")
    public NamedParameterJdbcTemplate getNamedParamJdbcTemplate(){
        NamedParameterJdbcTemplate namedParamJdbcTemplate=new NamedParameterJdbcTemplate(getJdbcTemplate());
        return namedParamJdbcTemplate;
    }

    @Bean("dataSource")
    public DataSource dataSource(){
      DriverManagerDataSource source =new DriverManagerDataSource();
      source.setDriverClassName(env.getProperty("db.driverClassName"));
      source.setUrl(env.getProperty("db.url"));
      source.setUsername(env.getProperty("db.username"));
      source.setPassword(env.getProperty("db.password"));
      return source;
    }

}
