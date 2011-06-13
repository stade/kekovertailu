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

    public static void insert(int test, int testcount) {
        int integer = 0;
        double start1, start2, start3, end1, end2, end3, totalTime1 = 0, totalTime2 = 0, totalTime3 = 0;
        Random randomizer = new Random();

        for (int j = testcount; j > 0; j--) {

            System.out.println("Comparing is running!");
            MinBinaryheap binHeap = new MinBinaryheap(test);
            FibonacciHeap fibHeap = new FibonacciHeap();
            PriorityQueue<Integer> javaHeap = new PriorityQueue<Integer>();

            System.gc();
            System.gc();

            start1 = System.currentTimeMillis();

            for (int i = test; i > 0; i--) {
                integer = randomizer.nextInt(i);
                FibonacciNode node = new FibonacciNode(integer);
                fibHeap.heapInsert(node);
            }

            end1 = System.currentTimeMillis();
            System.gc();
            System.gc();
            start2 = System.currentTimeMillis();

            for (int i = test; i > 0; i--) {
                integer = randomizer.nextInt(i);
                binHeap.heapInsert(integer);
            }

            end2 = System.currentTimeMillis();
            System.gc();
            System.gc();
            start3 = System.currentTimeMillis();

            for (int i = test; i > 0; i--) {
                integer = randomizer.nextInt(i);
                javaHeap.add(integer);
            }

            end3 = System.currentTimeMillis();


            totalTime1 = totalTime1 + (end1 - start1);
            totalTime2 = totalTime2 + (end2 - start2);
            totalTime3 = totalTime3 + (end3 - start3);

        }
        System.out.println("Comparing is done!");
        System.out.println("Average time of inserting " + test + " times to Fibonacci-heap " + totalTime1 / testcount + " milliseconds");
        System.out.println("Average time of inserting " + test + " times to binaryheap " + totalTime2 / testcount + " milliseconds");
        System.out.println("Average Time of inserting " + test + " times to Java priotyqueue " + totalTime3 / testcount + " milliseconds");

    }

    public static void findmin() {
    }

    public static void deleteMin(int test, int testcount) {
        int integer = 0;
        double start1, start2, start3, end1, end2, end3, totalTime1 = 0, totalTime2 = 0, totalTime3 = 0;
        Random randomizer = new Random();

        for (int j = testcount; j > 0; j--) {

            System.out.println("Comparing is running!");
            MinBinaryheap binHeap = new MinBinaryheap(test);
            FibonacciHeap fibHeap = new FibonacciHeap();
            PriorityQueue<Integer> javaHeap = new PriorityQueue<Integer>();

            // TODO: check that test runs correct mount of times
            for (int i = test; i > 0; i--) {
                integer = randomizer.nextInt(i);
                FibonacciNode node = new FibonacciNode(integer);
                fibHeap.heapInsert(node);
            }
            for (int i = test; i > 0; i--) {
                integer = randomizer.nextInt(i);
                binHeap.heapInsert(integer);
            }
            for (int i = test; i > 0; i--) {
                integer = randomizer.nextInt(i);
                javaHeap.add(integer);
            }

            System.gc();
            System.gc();

            start1 = System.currentTimeMillis();

            for (int i = 0; i < test; i++) {
                fibHeap.heapDeleteMin();
                
            }

            end1 = System.currentTimeMillis();
            System.gc();
            System.gc();
            start2 = System.currentTimeMillis();

            for (int i = 0; i < test; i++) {
                binHeap.heapDelMin();
            }

            end2 = System.currentTimeMillis();
            System.gc();
            System.gc();
            start3 = System.currentTimeMillis();

            for (int i = test - 1; i >= 0; i--) {
                javaHeap.poll();
            }

            end3 = System.currentTimeMillis();

            totalTime1 = totalTime1 + (end1 - start1);
            totalTime2 = totalTime2 + (end2 - start2);
            totalTime3 = totalTime3 + (end3 - start3);

        }
        System.out.println("Comparing is done!");
        System.out.println("Average time of deleting min " + test + " times from Fibonacci-heap " + totalTime1/testcount + " milliseconds");
        System.out.println("Average time of deleting min " + test + " times from binaryheap " + totalTime2/testcount + " milliseconds");
        System.out.println("Average time of deleting min " + test + " times from Java priorityqueue " + totalTime3/testcount + " milliseconds");

    }

    public static void degreaseKey(int test,int testcount, int degreasecount) {
        int integer = 0, k = 0, key = 0;
        long start1, start2, end1, end2, totalTime1 = 0, totalTime2 = 0;
        Random randomizer = new Random();
        int pseudoRandomIndex = test/2;
        FibonacciNode pseudoRandomNode = null;
        FibonacciNode node;
        MinBinaryheap binHeap = new MinBinaryheap(test);
        FibonacciHeap fibHeap = new FibonacciHeap();
        

        // TODO: check that test runs correct mount of times
        for (int i = test; i > 0; i--) {
            k++;
            integer = randomizer.nextInt(i);
            node = new FibonacciNode(integer);
            fibHeap.heapInsert(node);

            if(i == test/2) {
                pseudoRandomNode = node;
            }

        }
        for (int i = test; i > 0; i--) {
            integer = randomizer.nextInt(i);
            binHeap.heapInsert(integer);
        }

        System.gc();
        System.gc();

        System.out.println("k =" + k);

        for (int l = testcount; l > 0; l--) {

            System.out.println("Comparing is running!");

            start1 = System.nanoTime();

            for (int j = degreasecount; j > 0; j--) {
                

                key = pseudoRandomNode.getKey();

                key = key--;

                fibHeap.heapDecKey(pseudoRandomNode, key);
            }

            end1 = System.nanoTime();

            start2 = System.nanoTime();

            for (int j = degreasecount; j > 0; j--) {

                binHeap.heapDecKey(pseudoRandomIndex,pseudoRandomIndex);
            }

            end2 = System.nanoTime();

            totalTime1 = totalTime1 + (end1 - start1);
            totalTime2 = totalTime2 + (end2 - start2);

        }

        System.out.println("Comparing is done!");
        System.out.println("Average time of degreasing a key " + degreasecount + " times in Fibonacci-heap " + totalTime1/testcount + " nanoseconds");
        System.out.println("Average time of degreasing a key " + degreasecount + " times in binaryheap " + totalTime2/testcount + " nanoseconds");
        
    }

    public static void merge(int test, int testcount) {
        int integer = 0;
        double start1, start2, end1, end2, totalTime1 = 0, totalTime2 = 0;
        Random randomizer = new Random();

        for (int j = testcount; j > 0; j--) {

            System.out.println("Comparing is running!");
            MinBinaryheap binHeap1 = new MinBinaryheap(test);
            FibonacciHeap fibHeap1 = new FibonacciHeap();

            MinBinaryheap binHeap2 = new MinBinaryheap(test);
            FibonacciHeap fibHeap2 = new FibonacciHeap();

            MinBinaryheap binHeap3 = new MinBinaryheap(test*2);
            FibonacciHeap fibHeap3 = new FibonacciHeap();

            // TODO: check that test runs correct mount of times
            for (int i = test; i > 0; i--) {
                integer = randomizer.nextInt(i);
                FibonacciNode node = new FibonacciNode(integer);
                fibHeap1.heapInsert(node);
            }
            for (int i = test; i > 0; i--) {
                integer = randomizer.nextInt(i);
                binHeap1.heapInsert(integer);
            }

            for (int i = test; i > 0; i--) {
                integer = randomizer.nextInt(i);
                FibonacciNode node = new FibonacciNode(integer);
                fibHeap2.heapInsert(node);
            }
            for (int i = test; i > 0; i--) {
                integer = randomizer.nextInt(i);
                binHeap2.heapInsert(integer);
            }

            System.gc();
            System.gc();


            start1 = System.nanoTime();

            fibHeap3 = FibonacciHeap.heapUnion(fibHeap1, fibHeap2);

            end1 = System.nanoTime();

            System.out.println(start1 + " " + end1);

            System.gc();
            System.gc();

            start2 = System.nanoTime();

            binHeap3 = MinBinaryheap.merge(binHeap1, binHeap2);

            end2 = System.nanoTime();

            totalTime1 = totalTime1 + (end1 - start1);
            totalTime2 = totalTime2 + (end2 - start2);

        }

        System.out.println("Comparing is done!");
        System.out.println("Average time of merging two Fibonacci-heaps with " + test + " nodes  " + totalTime1/testcount + " nanoseconds");
        System.out.println("Average time of merging two minimum binaryheaps with " + test + " nodes " + totalTime2/testcount + " nanoseconds");

    }
}
