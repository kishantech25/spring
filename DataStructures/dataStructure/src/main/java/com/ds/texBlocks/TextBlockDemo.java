package com.ds.texBlocks;

public class TextBlockDemo {

    public static void main(String[] args) {
        //json Example
        String json = """
                          {
                          "id":1,
                           "name":"Kishan",
                           "salary":50000
                          }""";

        //SQL Example
        String sql = """
                     SELECT employee_id,
                     employee_name,
                     salary
                     FROM employee
                     WHERE salary > 50000
                     ORDER BY salary DESC
                     """;
        //HTMl Example
        String html = """
                        <html>
                           <body>
                              <h1>Welcome</h1>
                              <p>Java 17</p>
                         </body>
                         </html>
                        """;

         //total no of Leangth
        System.out.println(json.length());
        //return totl number Of characters
        System.out.println(json.isEmpty());
        //check the String contains whitesapce
        System.out.println(json.isBlank());
        //check json data contains Kishan
        System.out.println(json.contains("kishan"));
        //StartWith {
        System.out.println(json.startsWith("{"));
        System.out.println(json.endsWith("}"));
        //json contains endsWith
        System.out.println(json.indexOf("name"));
        //replace teh method
     //   System.out.println(json.replace("Kishan","Rahul"));

        //json.lines().forEach(System.out::println);
        System.out.println(json.indent(2));
    }
}
