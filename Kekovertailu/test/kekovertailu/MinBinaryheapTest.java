
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
    /**
     * Test of heapDecKey method, of class MinBinaryheap.
     */
    @Test
    public void testMerge() {

        System.out.println("Merge");

        final int TEST1 = -100;
        final int TEST2 = 100;
        final int TEST3 = 200;
        int integer = 0, res = 0, index = 0;
        Random randomizer = new Random();

        MinBinaryheap instance1 = new MinBinaryheap(100);
        MinBinaryheap instance2 = new MinBinaryheap(100);
        MinBinaryheap instance3 = new MinBinaryheap(100);
        
        ArrayList<Integer> missing = new ArrayList<Integer>();

        for (int i = -200 ; i < TEST1; i++) {
            integer = randomizer.nextInt();
            instance1.insert(integer);
            missing.add(integer);
        }
        for (int i = 1 ; i < TEST2; i++) {
            integer = randomizer.nextInt();
            instance2.insert(integer);
            missing.add(integer);
        }
        for (int i = TEST2; i < TEST3; i++) {
            integer = randomizer.nextInt();
            instance3.insert(integer);
            missing.add(integer);
        }

        MinBinaryheap tempResult = MinBinaryheap.merge(instance2, instance3);
        MinBinaryheap result = MinBinaryheap.merge(instance1, tempResult);

        for (int i = 1; i < 300; i++) {

            res = result.delMin();

            if (missing.contains(res)) {
                index = missing.indexOf(res);
                missing.remove(index);
            }
        }

        while (!missing.isEmpty()) {
            res = missing.remove(0);
            System.out.println("Missing " + res);
        }
        assertTrue(missing.isEmpty());
        
    }
}
