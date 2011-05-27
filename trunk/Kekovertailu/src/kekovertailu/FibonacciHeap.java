/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kekovertailu;

/**
 *
 * @author tatutahv
 */
public class FibonacciHeap {

    private FibonacciNode min;
    private int numNodes;

    public FibonacciHeap() {

        this.min = null;
        this.numNodes = 0;

    }

    public void heapInsert(int key) {

        FibonacciNode node = new FibonacciNode(key);

        // If heap is empty node becames min
        if (min == null) {
            node.setLeft(node);
            node.setRight(node);
            min = node;

        }
        else {
            // If min is the only node in the heap, node becames left and right of min
            if (min.getLeft().equals(min)) {

                min.setLeft(node);
                min.setRight(node);
                node.setLeft(min);
                node.setRight(min);

            } // If there is more nodes than min in the heap, node becames left of min and right of
            // the node that was left to min
            else {

                FibonacciNode temp = min.getLeft();

                node.setRight(min);
                node.setLeft(temp);
                min.setLeft(node);
                temp.setRight(node);

            }
            // If node is smaller than min it becames min
            if (node.getKey() < min.getKey()) {

                min = node;
            }
        }
        numNodes = numNodes + 1;
    }

    public int heapMin() {
        return min.getKey();
    }

    public int heapDeleteMin() {

        FibonacciNode toBeDeleted = min;
        FibonacciNode child = min.getChild();
       

        // If min node has childnodes they are added to the root list
        if (child != null) {

            // If min has only one child
            if (child.getLeft().equals(child)) {

                FibonacciNode temp = min.getLeft();

                child.setRight(min);
                child.setLeft(temp);
                min.setLeft(child);
                temp.setRight(child);

                child.setParent(null);

            } else {
                // If min has more than one child
                while (!child.getLeft().equals(child)) {

                    child = child.getLeft();

                    FibonacciNode temp = min.getLeft();

                    child.setRight(min);
                    child.setLeft(temp);
                    min.setLeft(child);
                    temp.setRight(child);

                    child.setParent(null);

                }

                FibonacciNode temp = min.getLeft();

                // Insert the last child to root list
                child.setRight(min);
                child.setLeft(temp);
                min.setLeft(child);
                temp.setRight(child);

                child.setParent(null);
            }
        }


        FibonacciNode leftToMin = min.getLeft();
        FibonacciNode rightToMin = min.getRight();

        // Remove the minimum node from the rootlist
        leftToMin.setRight(rightToMin);
        rightToMin.setLeft(leftToMin);

        //  Min is the only node in heap
        if (min.getRight().equals(min)) {
            min = null;
        } // There is more than one node in the heap
        else {
            min = min.getRight();
            consolidate();
        }

        // Delete all the references of min node to other nodes
        toBeDeleted.setLeft(null);
        toBeDeleted.setRight(null);
        toBeDeleted.setChild(null);

        numNodes--;

        return toBeDeleted.getKey();
    }

    private void consolidate() {

        // Calculater max degree of heaps in rootlist
        int maxDegree = 2 + (int) log2(numNodes);

        System.out.println("maxDegree: " + maxDegree);

        // Degree array size is the max degree of heap in rootlist
        FibonacciNode[] degreeArray = new FibonacciNode[maxDegree];


        for (int i = 0; i < maxDegree; i++) {
            degreeArray[i] = null;
        }

        FibonacciNode x = min.getLeft();
        FibonacciNode y = null;
        FibonacciNode temp = null;
        int degree = 0;

        do {
            x = x.getRight();
            degree = x.getDegree();

            while (degreeArray[degree] != null) {
                y = degreeArray[degree];

                if (x.getKey() > y.getKey()) {
                    temp = x;
                    x = y;
                    y = temp;
                }

                heapLink(y,x);
                degreeArray[degree] = null;
                degree++;
            }
            degreeArray[degree] = x;
        }
        while (!x.getRight().equals(min));

        min = null;

        for (int i = 0; i < maxDegree; i++) {

            if (degreeArray[i] != null) {
                if (min == null) {
                    min = degreeArray[i];
                    min.setLeft(min);
                    min.setRight(min);
                }
                else {
                    if (min.getLeft().equals(min)) {

                        min.setLeft(degreeArray[i]);
                        min.setRight(degreeArray[i]);
                        degreeArray[i].setLeft(min);
                        degreeArray[i].setRight(min);
                    }
                    else {
                        FibonacciNode leftToMin = min.getLeft();

                        leftToMin.setRight(degreeArray[i]);
                        degreeArray[i].setLeft(leftToMin);
                        degreeArray[i].setRight(min);
                        min.setLeft(degreeArray[i]);
                    }
                    if (degreeArray[i].getKey() < min.getKey()) {
                        min = degreeArray[i];
                    }
                }
            }
        }
    }
    public void heapLink(FibonacciNode y, FibonacciNode x) {
        FibonacciNode leftToY = y.getLeft();
        FibonacciNode rightToY = y.getRight();
        FibonacciNode temp;
        FibonacciNode leftTemp;

        leftToY.setRight(rightToY);
        rightToY.setLeft(leftToY);

        // Y becomes only child of x
        if (x.getChild() == null) {

            x.setChild(y);
            y.setLeft(y);
            y.setRight(y);
        }
        // Y becomes left of current chilf of x
        else {
            temp = x.getChild();
            leftTemp = temp.getLeft();

            leftTemp.setRight(y);
            temp.setLeft(y);
            y.setLeft(leftTemp);
            y.setRight(temp);

        }

        x.setDegree(x.getDegree()+1);
        y.setMark(false);


    }

    // Merges two Fibonacci-heaps as one
    public static FibonacciHeap heapUnion(FibonacciHeap heap1, FibonacciHeap heap2) {

        FibonacciHeap unionHeap = new FibonacciHeap();
        FibonacciNode min1Right = null;
        FibonacciNode min2Left = null;

        unionHeap.min = heap1.min;

        // Temporary references for right node of min1 and left node of min2
        min1Right = unionHeap.min.getRight();
        min2Left = heap2.min.getLeft();

        // Min of two heap becomes now neighbours
        unionHeap.min.setRight(heap2.min);
        heap2.min.setLeft(unionHeap.min);

        // To keep rootlist (circular double linked list) intact min2 old left
        // becomes left of min1 old right and  min1 old right becomes right of
        // min2 old left
        min1Right.setLeft(min2Left);
        min2Left.setRight(min1Right);

        // Checks which key is the new min in the merged Fibonacci-heap
        if (heap2.min.getKey() < heap1.min.getKey()) {
            unionHeap.min = heap2.min;
        }

        // Adds number of both nodes in the heap as the nodenumber of merged
        // Fibonacci heap
        unionHeap.numNodes = heap1.numNodes + heap2.numNodes;

        return unionHeap;

    }
    public void printRootList() {

        FibonacciNode temp = min;

        System.out.print("Contents of heaps rootlist: ");

        
        do {
            System.out.print(" " + temp.getKey());
            
            temp = temp.getRight();
        }
        while (!temp.equals(min));
        System.out.println();

    }
    public void printMinSibling() {

        System.out.println("left of min = " + min.getLeft().getKey() + " right of min = " + min.getRight().getKey() + " min ifself " + min.getKey());


    }

    private static double log2(int n) {
        return (Math.log(n) / Math.log(2));
    }
}
