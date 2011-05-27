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
        MinBinaryheap heap = new MinBinaryheap();

        heap.heapInsert(55);
        heap.heapInsert(33);
        heap.heapInsert(44);
        heap.heapInsert(77);
        heap.heapInsert(22);
        heap.heapInsert(99);
        heap.heapInsert(34);
        heap.heapInsert(88);
        heap.heapInsert(2);

        int res;
        while (heap.getHeapsize() != 0) {

        res = heap.heapDelMin();

        System.out.println(res);
        }
         * 
         */


        FibonacciHeap fibHeap = new FibonacciHeap();

        fibHeap.heapInsert(10);
        /*
        fibHeap.heapInsert(9);
        fibHeap.heapInsert(8);
        fibHeap.heapInsert(7);
         */

        System.out.println("rootlist of 1 ");
        fibHeap.printRootList();

        FibonacciHeap fibHeap2 = new FibonacciHeap();

        fibHeap2.heapInsert(4);
        /*
        fibHeap2.heapInsert(3);
        fibHeap2.heapInsert(1);
        fibHeap2.heapInsert(2);
         */
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



    }
}
