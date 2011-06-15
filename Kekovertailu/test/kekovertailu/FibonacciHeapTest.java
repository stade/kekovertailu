
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
     * Test of Insert method, of class FibonacciHeap.
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
     * Test of Min method, of class FibonacciHeap.
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
     * Test of DeleteMin method, of class FibonacciHeap.
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

        assertTrue(missing.isEmpty());  

        while (!missing.isEmpty()) {
            missingNode = missing.remove(i);
            System.out.println("Missing " + missingNode.getKey());
        }
        
    }


    /**
     * Test of decKey method, of class FibonacciHeap.
     */
    @Test
    public void testDecKey() {
        System.out.println("DecKey");
        FibonacciHeap instance = new FibonacciHeap();
        FibonacciNode node = new FibonacciNode();
        ArrayList<FibonacciNode> fiblist = new ArrayList<FibonacciNode>();

        for (int i = 0; i < 10; i++) {
            node = new FibonacciNode(i);
            instance.insert(node);
            fiblist.add(node);
        }

        instance.deleteMin();

        node = fiblist.get(8);

        instance.decKey(node, 0);

        node = instance.deleteMin();

        node = instance.deleteMin();

        assertEquals(1, node.getKey());

        node = instance.min();

        assertEquals(2, node.getKey());


    }

   
    /**
     * Test of Merge method, of class FibonacciHeap.
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