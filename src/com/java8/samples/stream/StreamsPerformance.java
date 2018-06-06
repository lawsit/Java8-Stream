package com.java8.samples.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
 

public class StreamsPerformance {

    public static final int MAX = 1000000;

    public static void sortSequential() {
        List<String> values = new ArrayList<>(MAX);
        Random rand = new Random();
        for (int i = 0; i < MAX; i++) {
            int  n = rand.nextInt(5000000) + 1;
            values.add(n.toString());
        }

        // sequential

        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

    public static void sortParallel() {
        List<String> values = new ArrayList<>(MAX);
        Random rand = new Random();
        for (int i = 0; i < MAX; i++) {
            int  n = rand.nextInt(5000000) + 1;
            values.add(n.toString());
        }

        // sequential

        long t0 = System.nanoTime();

        long count = values.parallelStream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));
    }

    public static void main(String[] args) {
        sortSequential();
        sortParallel();
    }
}
