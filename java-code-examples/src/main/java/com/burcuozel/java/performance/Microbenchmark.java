package com.burcuozel.java.performance;

import java.util.Random;


/**
 * . A microbenchmark is a test designed to measure a very small unit of performance: 
 * the time to call a synchronized method versus a nonsynchronized method; 
 * the overhead in creating a thread versus using a thread pool; 
 * the time to execute one arithmetic algorithm versus an alternate implementation; 
 *
 */

public class Microbenchmark {

/**
 * This code doesn't change any program states, because result "l" is never used.
 * A smart compiler will not execute method call and regardless of parameters,loop size,implementation, 
 * it will end up in a few miliseconds.
 * 
 * Solution: ensure that each result is read not simply written.
 */
public void doTestfibImpl1_useResults() {
    // Main Loop
    double l;
    long then = System.currentTimeMillis();
    for (int i = 0; i < 100; i++) {
        l = fibImpl1(50);
    }
    long now = System.currentTimeMillis();
    System.out.println("Elapsed time: " + (now - then));
}

private double fibImpl1(int n) {
    if (n < 0) throw new IllegalArgumentException("Must be > 0");
    if (n == 0) return 0d;
    if (n == 1) return 1d;
    double d = fibImpl1(n - 2) + fibImpl1(n  - 1);
    if (Double.isInfinite(d)) throw new ArithmeticException("Overflow");
    return d;
}

/**
 * In this example the time to calculate the random numbers is included that we measure
 * 
 * Solution: First generate random numbers array then use it in the loop
 * 
 */
public void doTestfibImpl1_notIncludeUnnecessayOperations() {
    // Main Loop
    double l;
    Random random=new Random();
    long then = System.currentTimeMillis();
    for (int i = 0; i < 50; i++) {       
		l = fibImpl1(random.nextInt());
    }
    long now = System.currentTimeMillis();
    System.out.println("Elapsed time: " + (now - then));
}

public void doTestfibImpl1_notIncludeUnnecessayOperationsSolution() {
 
    double l;
    Random random=new Random();
    int[] input = new int[50];
    for (int i = 0; i < 50; i++) {
        input[i] = random.nextInt();
    }
    long then = System.currentTimeMillis();
    for (int i = 0; i < 50; i++) {
        try {
            l = fibImpl1(input[i]);
        } catch (IllegalArgumentException iae) {
        }
    }
    long now = System.currentTimeMillis();
}






}