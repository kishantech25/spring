package com.job;

import com.job.cache.ApplicationCache;
import com.job.cache.Cache;
import com.job.classloaders.CustomClassLoaderA;
import com.job.classloaders.CustomClassLoaderB;
import com.job.singleton.DateUtil;
import com.job.test.Employee;
import com.job.util.EmployeList;

import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.Callable;

public class Main {

//    public static void main(String[] args) {
//
////        Thread thread =new Thread(()->{
////           throw new RuntimeException("International Exception");
////        });
////        thread.setName("Misbehaving  thread");
////
////        thread.setUncaughtExceptionHandler((thread1,throwable)->{
////            System.out.println("A critical error happend in thread "+ thread.getName()+" the error is "+throwable.getMessage());
////        });
////        thread.start();;
//   }

//public static void main(String[] args) {
//
//    String str = "Java is a object oriented programming language";
//    //Map<Character,Integer> map=str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), HashMap::new,Collectors.counting());
//    Map<Character,Integer> map = getCharacterOccurance(str);
//
//    map.entrySet().forEach(entry->System.out.println(entry.getKey()+" : "+entry.getValue()));
//
//}
//    public static  Map<Character,Integer> getCharacterOccurance(String input){
//
//        //convert into char Array
//        char[] charArray =input.toCharArray();
//
//        //create the hashMap Object
//        Map<Character,Integer> map =new HashMap<>();
//        for(char c: charArray){
//            map.put(c,map.getOrDefault(c,0)+1);
//        }
//        return map;
//    }
      public static void main(String[] args) throws Exception{

//          Path userClass  =Path.of("com\\job\\util\\User.class");
//
//          CustomClassLoaderA loaderA =new CustomClassLoaderA(userClass);
//          CustomClassLoaderB loaderB =new CustomClassLoaderB(userClass);
//
//          Class<?> userClassA =loaderA.loadClass("com.job.util.User");
//
//          Class<?> userClassB =loaderB.loadClass("com.job.util.User");
//
//          System.out.println("Class A = "+userClassA.getName());
//          System.out.println("Class B = "+userClassB.getName());
//
//GC Root
// ↓
//Thread
// ↓
//ThreadLocalMap
// ↓
//ThreadLocal
// ↓
//Large Object

//          System.out.println("Classes Name Equal= "+(userClassA.equals(userClassB)));
//          System.out.println("Classes Name Equal= "+(userClassA == userClassB));
//
//          System.out.println("Loader A " +userClassA.getClassLoader());
//          System.out.println("Loader B " +userClassB.getClassLoader());

          //Cache cache = Ca.getInstance();
          ApplicationCache cache = ApplicationCache.getInstance();

         List<Employee> emplList=EmployeList.employeList();
         int count=0;
          while(true){
              String key = UUID.randomUUID()
                      .toString()
                      .replace("-", "");


              System.out.println(key + "     " + emplList);
              cache.put(key, emplList);

          }

      }
      
}

