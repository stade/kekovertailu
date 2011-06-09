/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kekovertailu;

import java.util.*;

/**
 *
 * @author Tatu Tahvanainen
 */
public class ComparingHeaps {

    public static void insert() {

        final int TEST = 1000000;
        final int TESTCOUNT = 10;
        int integer = 0;

        double start1, start2, start3, end1, end2, end3, totalTime1 = 0, totalTime2 = 0, totalTime3 = 0;
        Random randomizer = new Random();

        for (int j = TESTCOUNT; j > 0; j--) {

            System.out.println("Comparing is running!");
            MinBinaryheap binHeap = new MinBinaryheap(TEST);
            FibonacciHeap fibHeap = new FibonacciHeap();
            PriorityQueue<Integer> javaHeap = new PriorityQueue<Integer>();

            System.gc();
            System.gc();

            start1 = System.currentTimeMillis();

            for (int i = TEST; i > 0; i--) {
                integer = randomizer.nextInt(i);
                FibonacciNode node = new FibonacciNode(integer);
                fibHeap.heapInsert(node);
            }

            end1 = System.currentTimeMillis();
            System.gc();
            System.gc();
            start2 = System.currentTimeMillis();

            for (int i = TEST; i > 0; i--) {
                integer = randomizer.nextInt(i);
                binHeap.heapInsert(integer);
            }

            end2 = System.currentTimeMillis();
            System.gc();
            System.gc();
            start3 = System.currentTimeMillis();

            for (int i = TEST; i > 0; i--) {
                integer = randomizer.nextInt(i);
                javaHeap.add(integer);
            }

            end3 = System.currentTimeMillis();


            totalTime1 = totalTime1 + (end1 - start1);
            totalTime2 = totalTime2 + (end2 - start2);
            totalTime3 = totalTime3 + (end3 - start3);

        }
        System.out.println("Comparing is done!");
        System.out.println("Average time of inserting " + TEST + " times to Fibonacci-heap " + totalTime1 / TESTCOUNT + " milliseconds");
        System.out.println("Average time of inserting " + TEST + " times to binaryheap " + totalTime2 / TESTCOUNT + " milliseconds");
        System.out.println("Average Time of inserting " + TEST + " times to Java priotyqueue " + totalTime3 / TESTCOUNT + " milliseconds");

    }

    public static void findmin() {
    }

    public static void deleteMin() {
        final int TEST = 1000000;
        final int TESTCOUNT = 10;
        int integer = 0;
        long start1, start2, start3, end1, end2, end3, totalTime1 = 0, totalTime2 = 0, totalTime3 = 0;
        Random randomizer = new Random();

        for (int j = TESTCOUNT; j > 0; j--) {

            System.out.println("Comparing is running!");
            MinBinaryheap binHeap = new MinBinaryheap(TEST);
            FibonacciHeap fibHeap = new FibonacciHeap();
            PriorityQueue<Integer> javaHeap = new PriorityQueue<Integer>();

            // TODO: check that test runs correct mount of times
            for (int i = TEST; i > 0; i--) {
                integer = randomizer.nextInt(i);
                FibonacciNode node = new FibonacciNode(integer);
                fibHeap.heapInsert(node);
            }
            for (int i = TEST; i > 0; i--) {
                integer = randomizer.nextInt(i);
                binHeap.heapInsert(integer);
            }
            for (int i = TEST; i > 0; i--) {
                integer = randomizer.nextInt(i);
                javaHeap.add(integer);
            }

            System.gc();
            System.gc();

            start1 = System.currentTimeMillis();

            for (int i = 0; i < TEST; i++) {
                fibHeap.heapDeleteMin();
                
            }

            end1 = System.currentTimeMillis();
            System.gc();
            System.gc();
            start2 = System.currentTimeMillis();

            for (int i = 0; i < TEST; i++) {
                binHeap.heapDelMin();
            }

            end2 = System.currentTimeMillis();
            System.gc();
            System.gc();
            start3 = System.currentTimeMillis();

            for (int i = TEST - 1; i >= 0; i--) {
                javaHeap.poll();
            }

            end3 = System.currentTimeMillis();

            totalTime1 = totalTime1 + (end1 - start1);
            totalTime2 = totalTime2 + (end2 - start2);
            totalTime3 = totalTime3 + (end3 - start3);

        }
        System.out.println("Comparing is done!");
        System.out.println("Average time of deleting min " + TEST + " times from Fibonacci-heap " + totalTime1/TESTCOUNT + " milliseconds");
        System.out.println("Average time of deleting min " + TEST + " times from binaryheap " + totalTime2/TESTCOUNT + " milliseconds");
        System.out.println("Average time of deleting min " + TEST + " times from Java priorityqueue " + totalTime3/TESTCOUNT + " milliseconds");

    }

    public static void degreaseKey() {
    }

    public static void merge() {
    }
}
