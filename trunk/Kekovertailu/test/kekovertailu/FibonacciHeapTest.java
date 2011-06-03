/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kekovertailu;

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

        int test = 1000;

        FibonacciHeap instance = new FibonacciHeap();
        FibonacciNode mayFail = new FibonacciNode(-1);

        for (int i = test; i > 0; i--) {
            FibonacciNode node = new FibonacciNode(i);
            instance.heapInsert(node);
            instance.heapInsert(mayFail);
        }

        for (int i = 0; i < ((test)*2)-1; i++) {
            instance.heapDeleteMin();
        }
        int result = 0;
        int expResult = 1000;

        FibonacciNode resultNode = instance.heapDeleteMin();

        if (resultNode != null) {
            result = resultNode.getKey();
        }
        
        assertEquals(expResult, result);
    }

    /**
     * Test of heapLink method, of class FibonacciHeap.
     */
    @Test
    public void testHeapLink() {
        System.out.println("heapLink");
        FibonacciNode y = null;
        FibonacciNode x = null;
        FibonacciHeap instance = new FibonacciHeap();
        instance.heapLink(y, x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of heapDecKey method, of class FibonacciHeap.
     */
    @Test
    public void testHeapDecKey() {
        System.out.println("heapDecKey");
        FibonacciNode x = null;
        int newkey = 0;
        FibonacciHeap instance = new FibonacciHeap();
        instance.heapDecKey(x, newkey);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cut method, of class FibonacciHeap.
     */
    @Test
    public void testCut() {
        System.out.println("cut");
        FibonacciNode x = null;
        FibonacciNode y = null;
        FibonacciHeap instance = new FibonacciHeap();
        instance.cut(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cascadingCut method, of class FibonacciHeap.
     */
    @Test
    public void testCascadingCut() {
        System.out.println("cascadingCut");
        FibonacciNode y = null;
        FibonacciHeap instance = new FibonacciHeap();
        instance.cascadingCut(y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printRootList method, of class FibonacciHeap.
     */
    @Test
    public void testPrintRootList() {
        System.out.println("printRootList");
        FibonacciHeap instance = new FibonacciHeap();
        instance.printRootList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMinSibling method, of class FibonacciHeap.
     */
    @Test
    public void testPrintMinSibling() {
        System.out.println("printMinSibling");
        FibonacciHeap instance = new FibonacciHeap();
        instance.printMinSibling();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMinChild method, of class FibonacciHeap.
     */
    @Test
    public void testPrintMinChild() {
        System.out.println("printMinChild");
        FibonacciHeap instance = new FibonacciHeap();
        instance.printMinChild();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}