
package kekovertailu;

/**
 * This class implements datastructure known as minimum binaryheap.
 *
 * @author Tatu Tahvanainen
 *
 */
public class MinBinaryheap {

    private int[] array;
    private int heapsize;
    private int arraysize;

    public MinBinaryheap() {
        this.array = new int[10];
        this.heapsize = 0;
        this.arraysize = 10;
    }

    public MinBinaryheap(int s) {
        this.array = new int[s];
        this.heapsize = 0;
        this.arraysize = s;
    }

    public int getHeapsize() {
        return this.heapsize;
    }

    public void addHeapsize() {
        this.heapsize++;
    }
    // Returns parent of given index of a node.
    private int parent(int i) {
        double d = (double) i;
        d = Math.floor((d - 1) / 2);
        return (int) d;

    }
    // Returns left child of given index of a node.
    private int leftchild(int i) {
        return (2 * i) + 1;
    }
    // Returns right child of given index of a node.
    private int rightchild(int i) {
        return (2 * i) + 2;
    }

    private void minHeapify(int i) {
        int l, r, smallest, temp;

        l = leftchild(i);
        r = rightchild(i);

        if (r <= heapsize) {
            if (array[l] < array[r]) {
                smallest = l;
            } else {
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

    public int heapMin() {
        return array[0];
    }

    public void insert(int k) {
        int i = 0;

        heapsize = heapsize + 1;
        i = heapsize;
        i = i - 1;

        if (heapsize == 1) {
            array[0] = k;
        } else {
            while ((i > 0) && ((array[parent(i)]) > k)) {
                array[i] = array[parent(i)];
                i = parent(i);
            }
            array[i] = k;
        }
    }

    public int delMin() {
        int min;

        min = array[0];
        array[0] = array[heapsize - 1];
        heapsize = heapsize - 1;
        minHeapify(0);
        return min;
    }

    public void decKey(int i, int newk) {

        if (i < 0 || i > arraysize-1) {
            System.out.println("Invalid index");
        }
        else {
            int temp;
            if (newk < array[i]) {
                array[i] = newk;
                while ((i > 0) && (array[parent(i)] > array[i])) {
                    temp = array[i];
                    array[i] = array[parent(i)];
                    array[parent(i)] = temp;
                    i = parent(i);
                }
            }
        }
    }
    
    public static MinBinaryheap merge (MinBinaryheap heap1, MinBinaryheap heap2) {

        int newSize = heap1.getHeapsize() + heap2.getHeapsize();
        MinBinaryheap mergeHeap = new MinBinaryheap(newSize);

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < newSize) {

            if (j <= heap1.getHeapsize() - 1) {
                //System.out.println ("i = " + i + " j= " + j + " ");
                mergeHeap.array[i] = heap1.array[j];
                mergeHeap.addHeapsize();
                i++;
                j++;

            } else {
                //System.out.println ("i = " + i + " k= " + k + " ");

                mergeHeap.array[i] = heap2.array[k];
                mergeHeap.addHeapsize();
                i++;
                k++;
            }
        }

        i = newSize - 1;

        while (i <= 0) {
            mergeHeap.minHeapify(i);
            i--;
        }
        return mergeHeap;
    }
}
