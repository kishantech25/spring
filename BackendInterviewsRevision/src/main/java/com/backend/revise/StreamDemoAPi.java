package com.backend.revise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemoAPi {

    public static void main(String[] args) {

        String input ="swiss";

        Character ch =input.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry->entry.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(ch);
    }
}
