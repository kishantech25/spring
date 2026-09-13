package com.springjdbc.dao;

import com.springjdbc.model.Statement;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class StatatementDAO {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParamJdbcTemplate;

    private final String SQL_FOR_STAT="SELECT * from STATEMENT WHERE STATEMENT_ID=:statementId";
    public StatatementDAO(NamedParameterJdbcTemplate namedParamJdbcTemplate){
        this.namedParamJdbcTemplate=namedParamJdbcTemplate;
    }


    public List<Map<String,Object>> findStatement(int statementId){
        MapSqlParameterSource paramSource =new MapSqlParameterSource();
        paramSource.addValue("statementId",statementId);

        return namedParamJdbcTemplate.queryForList(SQL_FOR_STAT,paramSource);
    }

//    //SQL Parameter Source
//     public List<Statement> findStatements(int statementId){
//         RowMapper<Statement> rowMapper =(rs,rowNum)->{
//               Statement stmt=new Statement();
//
//                 return null;
//             };
//         }



}
