package com.burcuozel.java.performance;

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
}}