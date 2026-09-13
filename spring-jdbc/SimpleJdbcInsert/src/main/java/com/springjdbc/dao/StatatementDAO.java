package com.springjdbc.dao;


import com.springjdbc.model.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;


public class StatatementDAO {

  private SimpleJdbcInsert simpleJdbcInsert;
  @Autowired
  public StatatementDAO(SimpleJdbcInsert simpleJdbcInsert){
      this.simpleJdbcInsert = simpleJdbcInsert;
  }
  public int insertStatement(Statement statement){
      BeanPropertySqlParameterSource parameterSource =new BeanPropertySqlParameterSource(statement);
      simpleJdbcInsert.setTableName("Statement");;
      int rowCount=simpleJdbcInsert.execute(parameterSource);
      return rowCount;
  }

}
