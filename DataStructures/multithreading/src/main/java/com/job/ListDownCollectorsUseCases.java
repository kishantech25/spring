package com.job;

import com.job.model.Books;

import java.awt.print.Book;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListDownCollectorsUseCases {


    public static void main(String[] args) {

        //toList
        //toSet
        //toMap
        //groupingBy
        //partitioningBy()
        //Joining()
        //counting()
        //summingInt()
        //averageingInt()


        DBConnection db =DBConnection.getInstance();
        Connection conn = db.getConnection();

        ConnectionHolder holder =new ConnectionHolder();
        holder.setConnection(conn);

        //get the Book Dao
        BooksDao booksDao = new BooksDao();
        List<Books> booksList = booksDao.getBookData(holder.getConnection());

        //the List of Books
       List<String> list = booksList.stream().map(Books::getTitle).collect(Collectors.toList());
       list.forEach(System.out::println);
       //some set of books  whose  specied by title
        //reduce function uses
        //Distinct function uses

        Function<Books,Books> function =Function.identity();
      // Map the even books list
        Map<Integer,Books> bookMap =booksList.stream().collect(Collectors.toMap(Books::getId,Function.identity(),(existing,newValue)->existing));

      //  bookMap.forEach((k,v)->System.out.println(k+","+v));

        //if i have to get the list
        Set<String> toSet = booksList.stream().map(Books::getTitle).collect(Collectors.toSet());
     //   toSet.forEach(System.out::println);


        //map books by Auther
        Map<String,List<Books>> bookByAuther=booksList.stream().collect(Collectors.groupingBy(Books::getAuthor));

      bookByAuther.forEach((k,v)->System.out.println(k+","+v));
   //how many books has each Author
        Map<String,Long>  count =booksList.stream().collect(Collectors.groupingBy(Books::getAuthor,Collectors.counting()));

        count.forEach((k,v)->System.out.println(k+","+v));


    }
}
