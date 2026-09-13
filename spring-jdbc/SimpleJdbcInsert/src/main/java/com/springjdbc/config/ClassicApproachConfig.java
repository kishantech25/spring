package com.springjdbc.config;

import com.springjdbc.dao.StatatementDAO;
import com.springjdbc.model.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class ClassicApproachConfig {

    @Autowired
    private Environment env;

    @Bean("simpleJdbcInsert")
     public SimpleJdbcInsert getjdbcTemplate(){
       SimpleJdbcInsert insert =new SimpleJdbcInsert(dataSource());
       return insert;
    }

   @Bean("statementDAO")
   public StatatementDAO getStatement(){
        StatatementDAO statatementDAO= new StatatementDAO(getjdbcTemplate());
        return statatementDAO;
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
