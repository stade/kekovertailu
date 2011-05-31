/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kekovertailu;

/**
 *
 * @author tatutahv
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*
        MinBinaryheap heap1 = new MinBinaryheap();
        MinBinaryheap heap2 = new MinBinaryheap();
        MinBinaryheap heap3;

        heap1.heapInsert(10);
        heap1.heapInsert(20);
        heap1.heapInsert(40);
        heap1.heapInsert(30);
        heap1.heapInsert(50);

        heap2.heapInsert(70);
        heap2.heapInsert(60);
        heap2.heapInsert(90);
        heap2.heapInsert(80);

        heap3 = MinBinaryheap.merge(heap1, heap2);

        heap3.heapPrint();
        */
        

        
        FibonacciHeap fibHeap = new FibonacciHeap();

        FibonacciNode fib2 = new FibonacciNode(2);
        FibonacciNode fib3 = new FibonacciNode(3);
        FibonacciNode fib4 = new FibonacciNode(4);
        FibonacciNode fib5 = new FibonacciNode(5);
        FibonacciNode fib6 = new FibonacciNode(6);
        FibonacciNode fib7 = new FibonacciNode(7);
        FibonacciNode fib8 = new FibonacciNode(8);
        FibonacciNode fib9 = new FibonacciNode(9);
        FibonacciNode fib10 = new FibonacciNode(10);
        FibonacciNode fib11 = new FibonacciNode(11);
        FibonacciNode fib12 = new FibonacciNode(12);
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
        fibHeap.heapDeleteMin();
        System.out.println("---------------");
        fibHeap.printRootList();
        fibHeap.printMinChild();
        fibHeap.printMinSibling();
        fibHeap.heapDecKey(fib5,2);
        fibHeap.heapDecKey(fib9,0);
        fibHeap.heapDecKey(fib7,5);
        System.out.println("---------------");
        fibHeap.printRootList();
        fibHeap.printMinChild();
        fibHeap.printMinSibling();

        /*
        for (int i = 1; i < 500; i++) {
            System.out.println("--------------");
            fibHeap.heapInsert(i);
            fibHeap.printRootList();
        }
        for (int i = 1; i < 500; i++) {
            System.out.println("---------------");
            fibHeap.printRootList();
            fibHeap.printMinChild();
            fibHeap.printMinSibling();
            System.out.println("deleted was = " + fibHeap.heapDeleteMin());
        }
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
