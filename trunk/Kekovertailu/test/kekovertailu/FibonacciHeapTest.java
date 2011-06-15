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
    public void testInsert() {
        System.out.println("Insert");
        boolean expResult = true;
        FibonacciNode node = new FibonacciNode(300);
        FibonacciHeap instance = new FibonacciHeap();
        instance.insert(node);
        boolean result = node.equals(instance.min());
        assertEquals(expResult,result);
    }

    /**
     * Test of heapMin method, of class FibonacciHeap.
     */
    @Test
    public void testMin() {
        System.out.println("Min");
        FibonacciHeap instance = new FibonacciHeap();
        FibonacciNode node = new FibonacciNode(3);
        instance.insert(node);
        FibonacciNode expResult = node;
        FibonacciNode result = instance.min();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of heapDeleteMin method, of class FibonacciHeap.
     */
    @Test
    public void testDeleteMin() {
        System.out.println("DeleteMin");
        FibonacciHeap instance = new FibonacciHeap();
        FibonacciNode res = null;
        FibonacciNode prevRes = null;
        final int test = 1000;
        int integer = 0;
        ArrayList<FibonacciNode> missing = new ArrayList<FibonacciNode>();
        Random randomizer = new Random();

        for (int i = 1 ; i < test; i++) {

            integer = randomizer.nextInt(i);
            FibonacciNode node = new FibonacciNode(integer);
            missing.add(node);
            instance.insert(node);
        }
        for (int i = 1; i < test; i++) {

            res = instance.deleteMin();

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
    public void testDecKey() {
        System.out.println("DecKey");

        int test = 1000;
        int result = 0;
        FibonacciHeap instance = new FibonacciHeap();
        FibonacciNode x = new FibonacciNode(test+1);

        for (int i = test; i > 0; i--) {
            FibonacciNode node = new FibonacciNode(i);
            instance.insert(node);
        }

        instance.insert(x);

        int newkey = -1000;
        int expResult = newkey;
        
        instance.decKey(x, newkey);

        FibonacciNode resultNode = instance.deleteMin();

        if (resultNode != null) {
            result = resultNode.getKey();
        }

        assertEquals(expResult,result);  
    }

   
    /**
     * Test of heapUnion method, of class FibonacciHeap.
     */
    @Test
    public void testMerge() {
        System.out.println("Merge");
        
        final int TEST1 = -100;
        final int TEST2 = 100;
        final int TEST3 = 200;
        Random randomizer = new Random();
        int integer = 0;
        
        
        FibonacciHeap instance1 = new FibonacciHeap();
        FibonacciHeap instance2 = new FibonacciHeap();
        FibonacciHeap instance3 = new FibonacciHeap();
        FibonacciNode node;
        ArrayList<FibonacciNode> missing = new ArrayList<FibonacciNode>();

        for (int i = -200 ; i < TEST1; i++) {
            integer = randomizer.nextInt();
            node = new FibonacciNode(integer);
            instance1.insert(node);
            missing.add(node);
        }
        for (int i = 1 ; i < TEST2; i++) {
            integer = randomizer.nextInt();
            node = new FibonacciNode(integer);
            instance2.insert(node);
            missing.add(node);
        }
        for (int i = TEST2; i < TEST3; i++) {
            integer = randomizer.nextInt();
            node = new FibonacciNode(integer);
            instance3.insert(node);
             missing.add(node);
        }


        FibonacciHeap tempResult = FibonacciHeap.merge(instance2, instance3);
        FibonacciHeap result = FibonacciHeap.merge(instance1, tempResult);

        for (int i = 1; i < 300; i++) {

            node = result.deleteMin();

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