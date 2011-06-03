/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kekovertailu;

import java.util.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tatutahv
 */
public class FibonacciHeapTest {

    public FibonacciHeapTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of heapInsert method, of class FibonacciHeap.
     */
    @Test
    public void testHeapInsert() {
        System.out.println("heapInsert");
        boolean expResult = true;
        FibonacciNode node = new FibonacciNode(300);
        FibonacciHeap instance = new FibonacciHeap();
        instance.heapInsert(node);
        boolean result = node.equals(instance.heapMin());
        assertEquals(expResult,result);
    }

    /**
     * Test of heapMin method, of class FibonacciHeap.
     */
    @Test
    public void testHeapMin() {
        System.out.println("heapMin");
        FibonacciHeap instance = new FibonacciHeap();
        FibonacciNode node = new FibonacciNode(3);
        instance.heapInsert(node);
        FibonacciNode expResult = node;
        FibonacciNode result = instance.heapMin();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of heapDeleteMin method, of class FibonacciHeap.
     */
    @Test
    public void testHeapDeleteMin() {
        System.out.println("heapDeleteMin");

        int test = 10;
        Random randomizer = new Random();

        FibonacciHeap instance = new FibonacciHeap();
        FibonacciNode mayFail = new FibonacciNode(-1000);

        instance.heapInsert(mayFail);

        for (int i = test; i > 0; i--) {
            FibonacciNode node = new FibonacciNode(i);
            instance.heapInsert(node);
        }
        for (int i = test; i > 0; i--) {
            instance.heapDeleteMin();
        }
       
        int result = 0;
        int expResult = 10;

        FibonacciNode resultNode = instance.heapDeleteMin();

        if (resultNode != null) {
            result = resultNode.getKey();
        }
        
        assertEquals(expResult, result);
    }


    /**
     * Test of heapDecKey method, of class FibonacciHeap.
     */
    @Test
    public void testHeapDecKey() {
        System.out.println("heapDecKey");

        int test = 1000;
        int result = 0;
        FibonacciHeap instance = new FibonacciHeap();
        FibonacciNode x = new FibonacciNode(test+1);

        for (int i = test; i > 0; i--) {
            FibonacciNode node = new FibonacciNode(i);
            instance.heapInsert(node);
        }

        instance.heapInsert(x);

        int newkey = -1000;
        int expResult = newkey;
        
        instance.heapDecKey(x, newkey);

        FibonacciNode resultNode = instance.heapDeleteMin();

        if (resultNode != null) {
            result = resultNode.getKey();
        }

        assertEquals(expResult,result);  
    }

   
    /**
     * Test of heapUnion method, of class FibonacciHeap.
     */
    @Test
    public void testHeapUnion() {
        System.out.println("heapUnion");
        FibonacciHeap heap1 = null;
        FibonacciHeap heap2 = null;
        FibonacciHeap expResult = null;
        FibonacciHeap result = FibonacciHeap.heapUnion(heap1, heap2);
        assertEquals(expResult, result);


        
    }

    

}