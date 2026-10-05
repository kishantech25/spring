package com.corejava.fundamental;

import java.util.HashMap;
import java.util.Map;

public class CountWords {

    public static void main(String[] args) {

        Map<String,Long> counts  =new HashMap<>();

        String s ="Welcome to java world to Exam";

       CountWords countWords =new CountWords();
      Map<String,Integer> map=countWords.countWordsInMap(s);

      map.entrySet().forEach(entry->System.out.println(entry.getKey()+" : "+entry.getValue()));

    }

    public Map<String,Integer> countWordsInMap(String string){

        Map<String,Integer> countMap =new HashMap<>();

        String[] words =string.split("\\s");

        for(String word:words){
                countMap.put(word,countMap.getOrDefault(word,0)+1);
        }
        return countMap;
    }
}
