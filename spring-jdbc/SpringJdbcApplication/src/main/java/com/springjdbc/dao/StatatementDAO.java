package com.springjdbc.dao;

import com.springjdbc.model.Statement;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class StatatementDAO {


    private NamedParameterJdbcTemplate namedParamJdbcTemplate;

    private final String SQL_FOR_STATEMENT = "SELECT * FROM STATEMENT ORDER BY STATEMENT_ID";
    private final String SQL_FOR_STAT="SELECT * from STATEMENT WHERE STATEMENT_ID=:statementId";
    public StatatementDAO(NamedParameterJdbcTemplate namedParamJdbcTemplate){
        this.namedParamJdbcTemplate=namedParamJdbcTemplate;
    }

    public List<Statement> getStatements(int pageSize,int pageNo){

        ResultSetExtractor<List<Statement>> extractor =rs->{
          int startIndex =(pageSize *(pageNo-1))+1;
          int endIndex=pageSize* pageNo;
          int rowIndex=1;
          Statement stmt =null;
          List<Statement> statements=null;

          statements =new ArrayList<>();

          while(rs.next() && rowIndex<=endIndex){
              if(rowIndex>=startIndex){
                  stmt=new Statement();
                  stmt.setStatementId(rs.getInt(1));
                  stmt.setAccountId(rs.getInt(2));
                  stmt.setTxnDateTime(rs.getTimestamp(3));
                  stmt.setSummary(rs.getString(4));
                  stmt.setDebit(rs.getBigDecimal(5));
                  stmt.setCredit(rs.getBigDecimal(6));
                  stmt.setBalance(rs.getBigDecimal(7));
                  statements.add(stmt);
              }
              rowIndex++;
          }
          return statements;
        };
         return namedParamJdbcTemplate.query(SQL_FOR_STATEMENT,extractor);

    }

//    public List<Map<String,Object>> findStatement(int statementId){
//        MapSqlParameterSource paramSource =new MapSqlParameterSource();
//        paramSource.addValue("statementId",statementId);
//
//        return namedParamJdbcTemplate.queryForList(SQL_FOR_STAT,paramSource,statementId);
//    }

}
