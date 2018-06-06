package com.java8.samples.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
public class StreamsFeature {

    public static void main(String[] args) {

        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("yellow");
        stringCollection.add("green");
        stringCollection.add("red");
        stringCollection.add("orange");
        stringCollection.add("blue");
        stringCollection.add("brown");
        stringCollection.add("white");
        stringCollection.add("black");


        // filtering

        stringCollection
                .stream()
                .filter((s) -> s.startsWith("b"))
                .forEach(System.out::println); 


        // sorting

        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("b"))
                .forEach(System.out::println); 


        // mapping

        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);
 


        // matching

        boolean anyStartsWithB = stringCollection
                .stream()
                .anyMatch((s) -> s.startsWith("b"));

        System.out.println(anyStartsWithB);      // true

        boolean allStartsWithB = stringCollection
                .stream()
                .allMatch((s) -> s.startsWith("b"));

        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ = stringCollection
                .stream()
                .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true


        // counting

        long startsWithB = stringCollection
                .stream()
                .filter((s) -> s.startsWith("b"))
                .count();

        System.out.println(startsWithB);    // 3


        // reducing

        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);
        // "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"


    }

}
