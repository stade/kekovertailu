/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kekovertailu;


/**
 *
 * @author tatutahv
 *
 * This class implements datastructure known as minimum binaryheap.
 */
public class MinBinaryheap {

    private int[] array;
    private int heapsize;

    public MinBinaryheap() {
        array = new int[10];
        heapsize = 0;
    }

    public MinBinaryheap(int s) {
        array = new int[s];
        heapsize = 0;
    }
    public int getHeapsize() {
        return this.heapsize;
    }
    // Returns parent of given index of a node.
    public int parent(int i) {
        double d = (double)i;
        d = Math.floor((d-1)/2);

        System.out.println("parent was " + d);

        return (int)d;

    }
    // Returns left child of given index of a node.
    public int leftchild(int i) {
        return (2*i)+1;
    }
    // Returns right child of given index of a node.
    public int rightchild(int i) {
        return (2*i)+2;
    }
    public void minHeapify(int i) {
        int l,r,smallest, temp;

        l = leftchild(i);
        r = rightchild(i);

        if (r <= heapsize) {
            if( array[l] < array[r]) {
                smallest = l;
            }
            else {
                smallest = r;
            }
            if (array[i] > array[smallest]) {
                temp = array[i];
                array[i] = array[smallest];
                array[smallest] = temp;

                minHeapify(smallest);

            }
            else if ((l == heapsize) && (array[i] > array[l])) {
                temp = array[i];
                array[i] = array[l];
                array[l] = temp;

            }
        }
    }

    public int heapMin(int[] array) {
        return array[0];
    }
    

    public void heapInsert(int k) {
        int i = 0;

        heapsize = heapsize+1;

        

        i = heapsize;

        i= i-1;

        
        if (heapsize == 1) {

            array[0] = k;

        }


        else {
        
       
            System.out.println("i = " + i + " and " + array[parent(i)] + " " + k + "" );
        
            while ((i > 0) && ((array[parent(i)]) > k)) {
              
                array[i] = array[parent(i)];
                i = parent(i);
            }
            array[i] = k;
        
        }
        
        
    }
    public int heapDelMin() {
        int min;

        min = array[0];
        array[0] = array[heapsize-1];
        heapsize = heapsize-1;
        minHeapify(0);
        return min;
    }
    public void heapDecKey(int i, int newk) {
        int temp;


        if (newk < array[i]) {
            array[i] = newk;
            while ((i > 0) && (array[parent(i)] > array[i])) {
                temp = array[i];
                array [i] = array[parent(i)];
                array[parent(i)] = temp;
                i = parent(i);
            }
        }
    }
}