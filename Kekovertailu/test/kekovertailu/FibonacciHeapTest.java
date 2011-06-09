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

        FibonacciHeap instance = new FibonacciHeap();
        FibonacciNode res = null;
        FibonacciNode prevRes = null;
        final int test = 1000;
        int integer = 0;
        ArrayList<FibonacciNode> missing = new ArrayList();
        Random randomizer = new Random();

        for (int i = 1 ; i < test; i++) {

            integer = randomizer.nextInt(i);
            FibonacciNode node = new FibonacciNode(integer);
            missing.add(node);
            instance.heapInsert(node);
        }
        for (int i = 1; i < test; i++) {

            res = instance.heapDeleteMin();

            if (i != 1) {
                assertTrue(prevRes.getKey() <= res.getKey());
            }

            if (res != null) {
                if (missing.contains(res)) {
                    missing.remove(res);
                }
                System.out.println("**************************************");
                System.out.println(" i =" + i + " deleted was = " + res.getKey());
                System.out.println("**************************************");

                prevRes = res;
            }
        }
        int i = 0;
        FibonacciNode missingNode;
        while (!missing.isEmpty()) {
            missingNode = missing.remove(i);
            System.out.println("Missing " + missingNode.getKey());
        }
        assertTrue(missing.isEmpty());  
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
        
        final int TEST1 = -100;
        final int TEST2 = 100;
        final int TEST3 = 200;
        
        
        FibonacciHeap instance1 = new FibonacciHeap();
        FibonacciHeap instance2 = new FibonacciHeap();
        FibonacciHeap instance3 = new FibonacciHeap();
        FibonacciNode node;
        ArrayList<FibonacciNode> missing = new ArrayList();

        for (int i = -200 ; i < TEST1; i++) {
            node = new FibonacciNode(i);
            instance1.heapInsert(node);
            missing.add(node);
        }
        for (int i = 1 ; i < TEST2; i++) {
            node = new FibonacciNode(i);
            instance2.heapInsert(node);
            missing.add(node);
        }
        for (int i = TEST2; i < TEST3; i++) {
            node = new FibonacciNode(i);
            instance3.heapInsert(node);
             missing.add(node);
        }


        FibonacciHeap tempResult = FibonacciHeap.heapUnion(instance2, instance3);
        FibonacciHeap result = FibonacciHeap.heapUnion(instance1, tempResult);

        for (int i = 1; i < 300; i++) {

            node = result.heapDeleteMin();

            if (node != null) {
                if (missing.contains(node)) {
                    missing.remove(node);
                }
            }
        }

        FibonacciNode missingNode;
        while (!missing.isEmpty()) {
            missingNode = missing.remove(0);
            System.out.println("Missing " + missingNode.getKey());
        }
        assertTrue(missing.isEmpty()); 
    }
}