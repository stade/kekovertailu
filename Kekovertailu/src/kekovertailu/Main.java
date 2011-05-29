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

        /*
        for (int i = 1; i < 6; i++) {
            System.out.println("--------------");
            fibHeap.heapInsert(i);
            fibHeap.printRootList();
        }
        for (int i = 1; i < 6; i++) {
            System.out.println("---------------");
            fibHeap.printRootList();
            fibHeap.printMinChild();
            fibHeap.printMinSibling();
            System.out.println("deleted was = " + fibHeap.heapDeleteMin());
        }
        */

        fibHeap.heapInsert(4);
        fibHeap.heapInsert(300);
        fibHeap.heapInsert(200);
        fibHeap.heapInsert(1);
        fibHeap.heapInsert(1000);
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
