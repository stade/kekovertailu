/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kekovertailu;

/**
 *
 * @author tatutahv
 *
 */
import java.util.*;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        FibonacciHeap fibHeap = new FibonacciHeap();


        /*
        int test = 4000000;
        long start1, start2, start3, end1, end2, end3, totalTime1, totalTime2, totalTime3;


        MinBinaryheap heap = new MinBinaryheap(test);
        
        PriorityQueue javaHeap = new PriorityQueue();
        System.gc();
        System.gc();

        start1 = System.currentTimeMillis();

        for (int i = test - 1; i >= 0; i--) {
            FibonacciNode node = new FibonacciNode(i);
            fibHeap.heapInsert(node);
        }

        end1 = System.currentTimeMillis();
        System.gc();
        System.gc();

        start2 = System.currentTimeMillis();

        for (int i = test - 1; i >= 0; i--) {
            heap.heapInsert(i);
        }

        end2 = System.currentTimeMillis();
        System.gc();
        System.gc();

        start3 = System.currentTimeMillis();

        for (int i = test - 1; i >= 0; i--) {
            javaHeap.add(i);
        }

        end3 = System.currentTimeMillis();


        totalTime1 = end1 - start1;
        totalTime2 = end2 - start2;
        totalTime3 = end3 - start3;

        System.out.println("Time of inserting " + test + " times to Fibonacci-heap " + totalTime1 + " milliseconds");
        System.out.println("Time of inserting " + test + " times to binaryheap " + totalTime2 + " milliseconds");
        System.out.println("Time of inserting " + test + " times to Java priotyqueue " + totalTime3 + " milliseconds");


        start1 = System.currentTimeMillis();

        for (int i = 0; i < test; i++) {
            fibHeap.heapDeleteMin();

        }

        end1 = System.currentTimeMillis();
        start2 = System.currentTimeMillis();

        for (int i = 0; i < test; i++) {
            heap.heapDelMin();
        }

        end2 = System.currentTimeMillis();
        start3 = System.currentTimeMillis();

        for (int i = test - 1; i >= 0; i--) {
            javaHeap.poll();
        }

        end3 = System.currentTimeMillis();

        totalTime1 = end1 - start1;
        totalTime2 = end2 - start2;
        totalTime3 = end3 - start3;

        System.out.println("Time of deleting min " + test + " times from Fibonacci-heap " + totalTime1 + " milliseconds");
        System.out.println("Time of deleting min " + test + " times from binaryheap " + totalTime2 + " milliseconds");
        System.out.println("Time of deleting min " + test + " times from Java priorityqueue " + totalTime3 + " milliseconds");
        */
        /*
        FibonacciNode fib2 = new FibonacciNode(2);
        FibonacciNode fib3 = new FibonacciNode(3);
        FibonacciNode fib4 = new FibonacciNode(-1000);
        FibonacciNode fib5 = new FibonacciNode(5);
        FibonacciNode fib6 = new FibonacciNode(6);
        FibonacciNode fib7 = new FibonacciNode(7);
        FibonacciNode fib8 = new FibonacciNode(8);
        FibonacciNode fib9 = new FibonacciNode(5);
        FibonacciNode fib10 = new FibonacciNode(10);
        FibonacciNode fib11 = new FibonacciNode(11);
        FibonacciNode fib12 = new FibonacciNode(-1000);
        FibonacciNode fib13 = new FibonacciNode(13);

        fibHeap.heapInsert(fib2);
        fibHeap.heapInsert(fib3);
        fibHeap.heapInsert(fib4);
        fibHeap.heapInsert(fib5);
        fibHeap.heapInsert(fib6);
        fibHeap.heapInsert(fib7);
        fibHeap.heapInsert(fib8);
        fibHeap.heapInsert(fib9);
        fibHeap.heapInsert(fib10);
        fibHeap.heapInsert(fib11);
        fibHeap.heapInsert(fib12);
        fibHeap.heapInsert(fib13);

   
        System.out.println("---------------");
        fibHeap.printRootList();
        fibHeap.printMinChild();
        fibHeap.printMinSibling();
        fibHeap.heapDecKey(fib5,-300);
        fibHeap.heapDecKey(fib9,0);
        fibHeap.heapDecKey(fib7,-400);
        System.out.println("---------------");
        fibHeap.printRootList();
        fibHeap.printMinChild();
        fibHeap.printMinSibling();

        for (int i = 0; i < 12; i++) {
            System.out.println("deleted was =" + fibHeap.heapDeleteMin().getKey());
        }
        */
        
        FibonacciNode res = null;
        int missing = 0;
        int integer = 0;
        Random randomizer = new Random();
        
        for (int i = 1 ; i < 40; i++) {

            integer = randomizer.nextInt(100);
            FibonacciNode node = new FibonacciNode(integer);

            System.out.println("hash " + node.hashCode());

            System.out.println("--------------");
            fibHeap.heapInsert(node);

            fibHeap.printRootList();

        }

        System.out.println("heapsize = "+ fibHeap.getNumNodes());

        for (int i = 1; i < 40; i++) {
            System.out.println("---------------");

            fibHeap.printRootList();

            fibHeap.printMinChild();
            fibHeap.printMinSibling();

            res = fibHeap.heapDeleteMin();

            if (res != null) {
                /*
                if (res.getKey() != i) {
                    missing++;
                }
                 *
                 */
                System.out.println("**************************************");
                System.out.println(" i =" + i + " deleted was = " + res.getKey());
                System.out.println("**************************************");
            }
        }
        /*
        System.out.println("missing " +  missing);
        */
        /*
        System.out.println("---------------------------");
        System.out.println("deleted was = " + fibHeap.heapDeleteMin());
        System.out.println("---------------------------");
        System.out.println("deleted was = " + fibHeap.heapDeleteMin());
        System.out.println("---------------------------");
        System.out.println("deleted was = " + fibHeap.heapDeleteMin());
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println("deleted was = " + fibHeap.heapDeleteMin());
        System.out.println("---------------------------");
        System.out.println("deleted was = " + fibHeap.heapDeleteMin());
        System.out.println("---------------------------");
         */
        /*
        System.out.println(fibHeap.heapMin());

        fibHeap.printMinSibling();

        
        fibHeap.printRootList();
        

        
        System.out.println("min = " + fibHeap.heapMin());
         */

        /*
        FibonacciHeap fibHeap2 = new FibonacciHeap();

        fibHeap2.heapInsert(4);
        
        fibHeap2.heapInsert(3);
        fibHeap2.heapInsert(1);
        fibHeap2.heapInsert(2);
        
        System.out.println("rootlist of 2 ");
        fibHeap2.printRootList();

        System.out.println("min of 1");
        System.out.println(fibHeap.heapMin());

        System.out.println("min of 2");
        System.out.println(fibHeap2.heapMin());


        FibonacciHeap fibHeap3;

        fibHeap3 = FibonacciHeap.heapUnion(fibHeap, fibHeap2);

        System.out.println("min of 3");
        System.out.println(fibHeap3.heapMin());

        System.out.println("rootlist of 3 ");
        fibHeap3.printRootList();
         */


    }
}
