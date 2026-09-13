//package com.springjdbc.model;
//
//import com.springjdbc.dao.AccountsDao;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class Java11FeatuersExample {
//
//    public static void main(String[] args) throws Exception{
//
//        AccountsDao dao =new AccountsDao();
//
//       var accounts = dao.getAccountsList();
//
//       //prints the accounts
//  //      accounts.stream().forEach(System.out::println);
//        //Prints all account holder name only
//
//       var accountHoldernames= accounts.stream().map(account->account.getAccountHolderName())
//               .filter(accountHolderName->accountHolderName.isBlank())
//                            .collect(Collectors.toList());
//       accountHoldernames.stream().forEach(System.out::println);
//       String s1 = "";
//       String s2 =" ";
//       String name =" Kishan ";
//
//       System.out.println(s1.isEmpty());
//       System.out.println(s2.isEmpty());
//
//       System.out.println(s1.isBlank());
//       System.out.println(s1.isBlank());
//
//       System.out.println(name);
//
//      // System.out.println(name.trim());
//       //alternate
//        System.out.println(name.strip());
//        String stl ="    Java";
//        System.out.println(stl.stripLeading());
//
//        String stT="Java   ";
//        System.out.println(stT.stripTrailing());
//
//        //before java 11
//        for(int i=0;i<5;i++){
//            System.out.print("*");
//        }
//        //current
//        System.out.println("*".repeat(10));
//      //Suppose
//        String text = "Java\nSpring\nHibernate\nDocker";
//        linesMethod(text);
//        filesMethod();
//        collectionToArrayDemo();
//        apiClientApi();
//
//        //Now
//       // text.lines().forEach(System.out::println);
//    }
//    public static void linesMethod(String text)throws Exception{
//        int start  =0;
//        var strings =new ArrayList<>();
//        for(int i=0;i<text.length();i++){
//            char ch = text.charAt(i);
//            if(ch == '\n'){
//                String line =text.substring(start,i);
//                System.out.println(line);
//                strings.add(line);
//                start = i +1;
//            }
//        }
//        //  return strings;
//
//    }
//    //enhanced the FIles class
//    public static void filesMethod() throws IOException {
//        String dbDetails= Files.readString(Path.of("C:/Users/KISHANTECH/Spring/spring-jdbc/pagination/src/main/resources/db.properties"));
//          System.out.println(dbDetails);
//    }
//    //cleaner an type safe
//    public static void collectionToArrayDemo(){
//        var list =List.of("Amit","sumit","Rakesh");
//        String[] arr =list.toArray(String[]::new);
//        System.out.println(Arrays.toString(arr));
//    }
//
//    //Http Client API
//    public static void apiClientApi() throws Exception{
//        HttpClient clinet =HttpClient.newHttpClient();
//
//        HttpRequest request =HttpRequest.newBuilder()
//                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
//                .build();
//
//        HttpResponse<String> response =clinet.send(request,HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());
//    }
//    //j
//
//}
