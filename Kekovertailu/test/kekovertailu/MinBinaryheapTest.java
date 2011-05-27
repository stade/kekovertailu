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
public class MinBinaryheapTest {

    public MinBinaryheapTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getHeapsize method, of class MinBinaryheap.
     */
    @Test
    public void testGetHeapsize() {
        System.out.println("getHeapsize");
        MinBinaryheap instance = new MinBinaryheap();
        int expResult = 0;
        int result = instance.getHeapsize();
        assertEquals(expResult, result);

    }

    /**
     * Test of parent method, of class MinBinaryheap.
     */
    @Test
    public void testParent() {

        System.out.println("parent");
        int i = 2;
        MinBinaryheap instance = new MinBinaryheap();
        int expResult = 0;
        int result = instance.parent(i);
        assertEquals(expResult, result);

    }

    /**
     * Test of leftchild method, of class MinBinaryheap.
     */
    @Test
    public void testLeftchild() {

        System.out.println("leftchild");
        int i = 0;
        MinBinaryheap instance = new MinBinaryheap();
        int expResult = 1;
        int result = instance.leftchild(i);
        assertEquals(expResult, result);

    }

    /**
     * Test of rightchild method, of class MinBinaryheap.
     */
    @Test
    public void testRightchild() {

        System.out.println("rightchild");
        int i = 0;
        MinBinaryheap instance = new MinBinaryheap();
        int expResult = 2;
        int result = instance.rightchild(i);
        assertEquals(expResult, result);

    }

    /**
     * Test of minHeapify method, of class MinBinaryheap.
     */
    @Test
    public void testMinHeapify() {

        System.out.println("minHeapify");
        int expResult = 2;
        MinBinaryheap instance = new MinBinaryheap();
        instance.heapInsert(3);
        instance.heapInsert(2);
        instance.heapInsert(1);
//        instance.heapDelMin();
        int result = instance.heapDelMin();
        assertEquals(expResult, result);

    }

    /**
     * Test of heapMin method, of class MinBinaryheap.
     */
    @Test
    public void testHeapMin() {

        System.out.println("heapMin");
        MinBinaryheap instance = new MinBinaryheap();
        instance.heapInsert(3);
        instance.heapInsert(1);
        instance.heapInsert(2);
        int result = instance.heapMin();
        int expResult = 1;
        assertEquals(expResult, result);

    }

    /**
     * Test of heapInsert method, of class MinBinaryheap.
     */
    @Test
    public void testHeapInsert() {

        System.out.println("heapInsert");
        int k = 55;
        MinBinaryheap instance = new MinBinaryheap();
        instance.heapInsert(k);
        int result = instance.heapMin();
        int expResult = 55;
        assertEquals(expResult, result);

    }

    /**
     * Test of heapDelMin method, of class MinBinaryheap.
     */
    @Test
    public void testHeapDelMin() {

        System.out.println("heapDelMin");
        int a = 33;
        int b = 66;
        MinBinaryheap instance = new MinBinaryheap();
        instance.heapInsert(b);
        instance.heapInsert(a);
        int expResult = 33;
        int result = instance.heapDelMin();
        assertEquals(expResult, result);

    }

    /**
     * Test of heapDecKey method, of class MinBinaryheap.
     */
    @Test
    public void testHeapDecKey() {

        System.out.println("heapDecKey");
        int i = 0;
        int newk = 22;
        MinBinaryheap instance = new MinBinaryheap();
        instance.heapInsert(33);
        instance.heapDecKey(i, newk);
        int result = instance.heapDelMin();
        int expResult = 22;
        assertEquals(expResult, result);

    }
}
