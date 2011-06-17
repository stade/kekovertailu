package kekovertailu;

/**
 *  This class implements datastructure known as Fibonacciheap
 *
 * @author Tatu Tahvanainen
 */
public class FibonacciHeap {

    private FibonacciNode min;
    private int numNodes;

    public FibonacciHeap() {

        this.min = null;
        this.numNodes = 0;

    }

    public int getNumNodes() {
        return numNodes;
    }

    // Inserts Fibonaccinode to Fibonacciheap
    public void insert(FibonacciNode node) {

        // If heap is empty node becames min
        if (min == null) {
            node.setLeft(node);
            node.setRight(node);
            min = node;

        } else {
            // If min is the only node in the heap, node becames left and right of min
            if (min.getRight().equals(min)) {

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
            // If nodes key is smaller than min it becames min
            if (node.getKey() < min.getKey()) {

                min = node;
            }
        }
        numNodes = numNodes + 1;
    }

    // Returns minimum node of Fibonacciheap and keeps the min node in the heap
    public FibonacciNode min() {
        return this.min;
    }

    // Deletes and returns minimum node of Fibonacciheap if Heap is empty returns null
    public FibonacciNode deleteMin() {

        FibonacciNode toBeDeleted = min;
        FibonacciNode temp = null;
        FibonacciNode child = null;
        FibonacciNode leftChild = null;
        FibonacciNode rightChild = null;
        FibonacciNode nextChild = null;


        if (min != null) {
            child = min.getChild();
            // If minnode has childnodes they are added to the root list
            if (child != null) {
                // If min has only one child
                if (child.getRight().equals(child)) {
                    // If min is only node in rootlist
                    if (min.getRight().equals(min)) {
                        child.setLeft(min);
                        child.setRight(min);
                        min.setLeft(child);
                        min.setRight(child);
                    }
                    else {
                        temp = min.getLeft();
                        child.setLeft(temp);
                        child.setRight(min);
                        min.setLeft(child);
                        temp.setRight(child);
                    }

                    child.setParent(null);

                } // If min has more than one child
                else {
                    // Puts mins childs to rootlist until one child is remaining
                    while (!child.getRight().equals(child)) {

                        //If min is the only node in the rootlist
                        if (min.getRight().equals(min)) {

                            nextChild = child.getRight();

                            leftChild = child.getLeft();
                            rightChild = child.getRight();

                            leftChild.setRight(rightChild);
                            rightChild.setLeft(leftChild);

                            min.setLeft(child);
                            min.setRight(child);
                            child.setLeft(min);
                            child.setRight(min);

                            child.setParent(null);
                            child = nextChild;
                        }
                        // Min is not the only node in the rootlist
                        else {
                            nextChild = child.getRight();

                            leftChild = child.getLeft();
                            rightChild = child.getRight();

                            leftChild.setRight(rightChild);
                            rightChild.setLeft(leftChild);

                            temp = min.getLeft();

                            min.setLeft(child);
                            temp.setRight(child);
                            child.setLeft(temp);
                            child.setRight(min);

                            child.setParent(null);
                            child = nextChild;
                        }
                    }
                    //Insert the last child to root list
                    temp = min.getLeft();

                    child.setLeft(temp);
                    child.setRight(min);

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
            if (min.getRight().equals(min) && min.getLeft().equals(min)) {
                min = null;
            } // There is more than one node in the heap so consolidate must be done
            else {
                min = min.getRight();
                consolidate();
            }

            // Delete all the references of min node to other nodes
            toBeDeleted.setLeft(null);
            toBeDeleted.setRight(null);
            toBeDeleted.setChild(null);

            numNodes--;

            return toBeDeleted;

        }
        else {
            System.out.println("Heap was empty");
            return null;
        }
    }

    //Modifies heaps structure to a state where every rootnodes tree has a different degree
    private void consolidate() {

        // Calculate max degree of trees in rootlist
        int maxDegree = (int) maxDegree(numNodes);

        // Degree arrays size is the max degree of heaps in rootlist
        FibonacciNode[] degreeArray = new FibonacciNode[maxDegree];

        // Set every reference to point null
        for (int i = 0; i < maxDegree; i++) {
            degreeArray[i] = null;
        }

        FibonacciNode x = min;

        FibonacciNode y = null;
        FibonacciNode temp = null;
        int degree = 0;
        int numRoots = 0;
        x = min;

        // Count number of rootnodes
        if (x != null) {
            numRoots++;
            x = x.getRight();

            while (x != min) {
                numRoots++;
                x = x.getRight();
            }
        }

        // Goes through every node in rootlist. After this loop finishes there is
        // no trees with same degree in fibonacciheap
        while (numRoots > 0) {

            FibonacciNode next = x.getRight();
            degree = x.getDegree();

            while (degreeArray[degree] != null) {
                y = degreeArray[degree];

                if (x.getKey() > y.getKey()) {
                    temp = x;
                    x = y;
                    y = temp;
                }
            
                // Makes y a child of x
                heapLink(y, x);

                degreeArray[degree] = null;
                degree = degree + 1;

            }

            degreeArray[degree] = x;

            x = next;
            numRoots--;
        }

        min = null;

        FibonacciNode leftToMin;

        // Creates the new rootlist of Fibonacci-heap whitch is now one node smaller.
        // This is done by making new rootlist by rootnodes whitch trees are all
        // diffrent degree. Trees are in degreeArray.
        for (int i = 0; i < maxDegree; i++) {
            if (degreeArray[i] != null) {
                //Rootlist is empty
                if (min == null) {
                    min = degreeArray[i];
                    min.setLeft(min);
                    min.setRight(min);
                } 
                // Rootlist is not empty
                else {
                    leftToMin = min.getLeft();
                    leftToMin.setRight(degreeArray[i]);
                    min.setLeft(degreeArray[i]);
                    degreeArray[i].setLeft(leftToMin);
                    degreeArray[i].setRight(min);

                    if (degreeArray[i].getKey() < min.getKey()) {
                        temp = min;
                        min = degreeArray[i];      
                    }
                }
            }
        }
    }

    // Heaplink makes y a child of x
    private void heapLink(FibonacciNode y, FibonacciNode x) {

        FibonacciNode leftToY = y.getLeft();
        FibonacciNode rightToY = y.getRight();
        FibonacciNode leftofCurrent;
        FibonacciNode currentChild;

        // Removes y from rootlist
        leftToY.setRight(rightToY);
        rightToY.setLeft(leftToY);

        // Y becomes only child of x
        if (x.getChild() == null) {

            x.setChild(y);
            y.setLeft(y);
            y.setRight(y);
            y.setParent(x);

        }
        // Y becomes left of current child of x
        else {
            currentChild = x.getChild();

            // X has only one child
            if (currentChild.getLeft().equals(currentChild)) {

                currentChild.setLeft(y);
                currentChild.setRight(y);
                y.setLeft(currentChild);
                y.setRight(currentChild);
                y.setParent(x);

            }
            // X has more than one child
            else {

                leftofCurrent = currentChild.getLeft();
                leftofCurrent.setRight(y);
                currentChild.setLeft(y);
                y.setLeft(leftofCurrent);
                y.setRight(currentChild);
                y.setParent(x);

            }
        }

        // Degree of x rises by one when we make y child of x
        x.setDegree(x.getDegree() + 1);
        y.setMark(false);
    }
    //Decreases key of given FibonacciNode
    public void decKey(FibonacciNode x, int newkey) {

        FibonacciNode y = null;
     
        if (newkey > x.getKey()) {
            System.out.print("Can't decrease key to greater key than current key");
        }
        else {
            x.setKey(newkey);
            y = x.getParent();

            if ((y != null) && (x.getKey() < y.getKey())) {
                cut(x, y);
                cascadingCut(y);
            }
            if (x.getKey() < min.getKey()) {
                min = x;
            }
        }
    }

    private void cut(FibonacciNode x, FibonacciNode y) {

        FibonacciNode leftOfMin = min.getLeft();

        // If x is the only child
        if (x.getLeft().equals(x)) {
            leftOfMin.setRight(x);
            min.setLeft(x);
            x.setLeft(leftOfMin);
            x.setRight(min);
        } // X is not the only child
        else {
            FibonacciNode leftToX = x.getLeft();
            FibonacciNode rightToX = x.getRight();

            leftToX.setRight(rightToX);
            rightToX.setLeft(leftToX);

            leftOfMin.setRight(x);
            min.setLeft(x);
            x.setLeft(leftOfMin);
            x.setRight(min);
        }

        y.setDegree(y.getDegree() - 1);
        x.setParent(null);
        x.setMark(false);

    }

    private void cascadingCut(FibonacciNode y) {
        FibonacciNode z = y.getParent();

        if (z != null) {
            if (y.getMark() == false) {
                y.setMark(true);
            } else {
                cut(y, z);
                cascadingCut(z);
            }
        }
    }
    // Merges two Fibonacci-heaps as one
    public static FibonacciHeap merge(FibonacciHeap heap1, FibonacciHeap heap2) {

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

    //Calculates the maximum degree of Fibonacci-heap containing n number of nodes
    private static double maxDegree(int n) {

        double res = 0;

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        } else {
            res = (Math.log(n) / Math.log((1 + Math.sqrt(5)) / 2));
            res = Math.ceil(res);
            return res;
        }
    }
}
