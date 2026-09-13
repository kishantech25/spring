package com.job;
import com.job.github.EmailSenderWorker;
import com.job.github.Worker;
import com.job.model.Books;
import com.job.singleton.DateUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.*;

public class App {

    //create the thread pool with exctly 2 threads
    static ExecutorService executer = Executors.newFixedThreadPool(2);



    public static void main(String[] args) throws InterruptedException, ExecutionException {

        com.job.ConnectionHolder holder = new com.job.ConnectionHolder();

//        Thread producer = new Thread(() -> {
//
//            DBConnection db = DBConnection.getInstance();
//
//            Connection conn = db.getConnection();
//
//            holder.setConnection(conn);
//
//        }, "Connection-Producer");
//
//        Thread consumer1Get = new Thread(() -> {
//
//            Connection conn = holder.getConnection();
//
//            BooksDao dao = new BooksDao();
//
//            List<Books> books = dao.getBookData(conn);
//
//
//            books.forEach(System.out::println);
//
//            try {
//                conn.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }, "Book-Consumer-1");
//
//        Thread consumer2Save =new Thread(()->{
//
//            Connection conn =holder.getConnection();
//            BooksDao dao =new BooksDao();
//           //save The books
//            Books book=new Books();
//            book.setId(14);
//            book.setTitle("Life  lesson 2");
//            book.setAuthor("Pallavi");
//            dao.saveBooks(book,conn);
//
//        },"Book-consumer-2");
//
//        Thread consumer3Delete=new Thread(()->{
//            Connection conn =holder.getConnection();
//            BooksDao dao =new BooksDao();
//            //delete The books
//            dao.deleteBooks(13, conn);
//
//        },"Book-consumer-3");
//
//        Thread consumer4Update=new Thread(()->{
//            Connection conn =holder.getConnection();
//            BooksDao dao =new BooksDao();
//            //update The books
//            Books book=new Books();
//            book.setId(14);
//            book.setTitle("Life  lesson 2");
//            book.setAuthor("Pallavi");
//            dao.updateBooks(book,conn);
//
//        },"Book-consumer-4");

        //task 2 to Produce


       // task 1 to Get
//        CompletableFuture<Connection>  future0 =CompletableFuture.supplyAsync(()->{
//           DBConnection db =DBConnection.getInstance();
//           Connection conn= db.getConnection();
//           holder.setConnection(conn);
//           return conn;
//        });
//
//
//        CompletableFuture<List<Books>> future1 = future0.thenCompose(conn ->
//                CompletableFuture.supplyAsync(() -> {
//                    try (Connection c = holder.getConnection()) {
//                        BooksDao dao = new BooksDao();
//                        return dao.getBookData(c);
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                }, executer)
//        );

 //       future1.get().stream().forEach(System.out::println);

        //task 2 to Save
//        CompletableFuture<Void> future2 = future0.thenCompose(conn -> CompletableFuture.runAsync(() -> {
//            try(Connection conn = holder.getConnection()){
//                BooksDao dao = new BooksDao();
//                Books book = new Books();
//                book.setId(14);
//                book.setTitle("Life  lesson 2");
//                book.setAuthor("Pallavi");
//                dao.saveBooks(book, conn);
//            }
//        }, executer));

        //task 3 to Delete
//        CompletableFuture<Void> future3 = future0.thenCompose(conn -> CompletableFuture.runAsync(() -> {
//            try(Connection conn = holder.getConnection()){
//                BooksDao dao = new BooksDao();
//                dao.deleteBooks(13, conn);
//            }
//
//        }, executer));

        //task 4 to Update
//        CompletableFuture<Books> future4 = future0.thenCombine(CompletableFuture.runAsync(() -> {
//            try(Connection conn = holder.getConnection()){
//                BooksDao dao = new BooksDao();
//                Books book = new Books();
//                book.setId(14);
//                book.setTitle("Life  lesson 5");
//                book.setAuthor("Pallavi11");
//                Books books= dao.updateBooks(book, conn);
//                return books;
//            }
//
//        }, executer));

        // Wait for all tasks to complete
 //       CompletableFuture.allOf(future0,future1,future2,future3,future4).join();

         //shutdown  the executer
  //      executer.shutdown();


//        ClassLoaderA loaderA =new ClassLoaderA();
//        ClassLoaderB loaderB =new ClassLoaderB();
//      Class<?> classA= loaderA.loadClass("com.job.util.Userutil");
//      Class<?> classB =loaderB.loadClass("com.job.util.Userutil");
//
//      //Object objA =classA.

//           Worker  w =new Worker();
//           Thread t  =new Thread(w);
//           t.start();
//           Thread.sleep(2000);//run for 5 seconds
//           w.stop();

        EmailSenderWorker worker = new EmailSenderWorker();
        Thread thread1 = new Thread(worker);
        Thread thread2 = new Thread(worker);
        Thread thread3 = new Thread(worker);
        Thread thread4 = new Thread(worker);
        Thread thread5 = new Thread(worker);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        Thread.sleep(10000);
        worker.stopWorker();



    }
}