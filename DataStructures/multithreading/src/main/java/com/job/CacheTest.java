package com.job;

import com.job.cache.Cache;
import com.job.model.Books;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CacheTest {

    public static void main(String[] args) throws SQLException, InterruptedException, ExecutionException {

        ConnectionHolder holder =new ConnectionHolder();
        Cache cache =Cache.getInstance();
        Map<String,Object> map =new HashMap<>();
        Thread thread1 =new Thread(()->{
         //get the database connection Object
            DBConnection db =DBConnection.getInstance();
            Connection conn = db.getConnection();
            holder.setConnection(conn);
        });

        Thread thread2 =new Thread(()->{
        //get the Books Detail
            try(Connection c =holder.getConnection()){
                BooksDao dao =new BooksDao();
                 List<Books> getBooks=dao.getBookData(c);
                Map<Integer,Books> books= getBooks.stream().collect(Collectors.toMap(Books::getId,Function.identity()));
              books.forEach((k,v)->System.out.println(k+","+v));
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        });
        map.put("thread1",thread1);
        map.put("thread2",thread2);

        thread1.start();
        thread2.start();

        //show the list of books data
    }
}
