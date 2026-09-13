package com.springjdbc.util;

import com.springjdbc.model.Statement;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class StreamApiOperations {

    public void practice(List<Statement> txns){
        //count the list of transactions
        System.out.println(txns.stream().count());

        //get all the credit happend on ttxn
        List<BigDecimal> txnEach =txns.stream().map(txn-> txn.getCredit()).collect(Collectors.toList());
        //List down txn happned between than  5000 and 100000
        List<Double> txnAmount5000And10000 =txnEach.stream().map(bigDecimal->bigDecimal.doubleValue())
                .filter(amount->amount>=10000.0).toList();
        System.out.println(txnAmount5000And10000.stream().count());

        //select * from statement order by credit desc limit 100 OFFSET 50
        List<Statement> result =txns.stream()
                .sorted(Comparator.comparing(Statement::getCredit).reversed())
                .skip(100)
                .limit(50)
                .collect(Collectors.toList());

      //   result.forEach(System.out::println);

         //get the higest credit happend
        Statement stamt = txns.stream().max(Comparator.comparing(Statement::getCredit)).orElse(null);
      //  System.out.println(stamt);

        //retrive the summary =Salary Credit whose balance >50000.0

        //solutions ,SELECT * FROM Statement where summary='%Salary Credit%' and balance>50000 Limit 100 OFFSET 10001

       List<Statement> result1=txns.stream()
                .filter(s->s.getSummary() !=null && s.getSummary().contains("Salary Credit"))
                .filter(s->s.getBalance().doubleValue()> 50000.0)
                .skip(1000)
                .limit(100)
                .collect(Collectors.toList());
     //  result1.forEach(System.out::println);

     Map<String,Double> map= txns.stream().
               collect(Collectors.groupingBy(
                       Statement::getSummary,
                       Collectors.summingDouble(s->s.getBalance().doubleValue())));
     map.entrySet().forEach(entry->System.out.println(entry.getKey()+" : "+entry.getValue()));
     System.out.println(map.entrySet().stream().count());
    }
}
