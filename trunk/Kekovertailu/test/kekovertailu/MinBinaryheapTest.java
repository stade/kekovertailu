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
     * Test of heapMin method, of class MinBinaryheap.
     */
    @Test
    public void testMin() {

        System.out.println("Min");
        MinBinaryheap instance = new MinBinaryheap();
        instance.insert(3);
        instance.insert(1);
        instance.insert(2);
        int result = instance.heapMin();
        int expResult = 1;
        assertEquals(expResult, result);

    }

    /**
     * Test of heapInsert method, of class MinBinaryheap.
     */
    @Test
    public void testInsert() {

        System.out.println("Insert");
        int k = 55;
        MinBinaryheap instance = new MinBinaryheap();
        instance.insert(k);
        int result = instance.heapMin();
        int expResult = 55;
        assertEquals(expResult, result);

    }

    /**
     * Test of heapDelMin method, of class MinBinaryheap.
     */
    @Test
    public void testDelMin() {

        System.out.println("DelMin");
        int a = 33;
        int b = 66;
        MinBinaryheap instance = new MinBinaryheap();
        instance.insert(b);
        instance.insert(a);
        int expResult = 33;
        int result = instance.delMin();
        assertEquals(expResult, result);

    }

    /**
     * Test of heapDecKey method, of class MinBinaryheap.
     */
    @Test
    public void testDecKey() {

        System.out.println("DecKey");
        int i = 0;
        int newk = 22;
        MinBinaryheap instance = new MinBinaryheap();
        instance.insert(33);
        instance.decKey(i, newk);
        int result = instance.delMin();
        int expResult = 22;
        assertEquals(expResult, result);

    }
}
