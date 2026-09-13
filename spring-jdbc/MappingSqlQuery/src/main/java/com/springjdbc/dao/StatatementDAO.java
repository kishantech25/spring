package com.springjdbc.dao;


import com.springjdbc.model.Statement;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;


public class StatatementDAO {
    private DataSource dataSource;
  public StatatementDAO(SimpleJdbcInsert simpleJdbcInsert){
      this.simpleJdbcInsert = simpleJdbcInsert;
  }

  public int insertStatement(Statement statement){

  }

}
