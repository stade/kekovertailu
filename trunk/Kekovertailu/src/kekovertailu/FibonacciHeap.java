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

        // If minnode has childnodes they are added to the root list
        if (child != null) {

            // If min has only one child
            if (child.getLeft().equals(child)) {

                FibonacciNode temp = min.getLeft();

                System.out.println("Only child was " + child.getKey());

                child.setRight(min);
                child.setLeft(temp);
                min.setLeft(child);
                temp.setRight(child);

                child.setParent(null);

            }
            else {
                // If min has more than one child

                FibonacciNode leftChild = null;
                FibonacciNode rightChild  = null;
                FibonacciNode nextChild = null;



                while (!child.getLeft().equals(child)) {

                    System.out.println("Adding to " + child.getKey() + " rootlist ");

                    nextChild = child.getLeft();

                    leftChild = child.getLeft();
                    rightChild = child.getRight();

                    leftChild.setRight(rightChild);
                    rightChild.setLeft(leftChild);

                    FibonacciNode temp = min.getLeft();
                   
                    child.setRight(min);
                    child.setLeft(temp);
                    min.setLeft(child);
                    temp.setRight(child);

                    child.setParent(null);

                    child = nextChild;
                }
             

                FibonacciNode temp = min.getLeft();

                // Insert the last child to root list

                System.out.println("Adding to " + child.getKey() + " rootlist ");

                child.setRight(min);
                child.setLeft(temp);
                min.setLeft(child);
                temp.setRight(child);

                child.setParent(null);
            }
        }
        FibonacciNode leftToMin = min.getLeft();
        FibonacciNode rightToMin = min.getRight();

        System.out.println("Mins siblings before removal: left= " + min.getLeft().getKey() + " right = " + min.getRight().getKey());

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
        int maxDegree = 1 +(int) maxDegree(numNodes);

        System.out.println("maxDegree: " + maxDegree);
        System.out.println("num of nodes: " + numNodes);


        // Degree array size is the max degree of heap in rootlist
        FibonacciNode[] degreeArray = new FibonacciNode[maxDegree];


        for (int i = 0; i < maxDegree; i++) {
            degreeArray[i] = null;
        }

        FibonacciNode leftOfEnd = min.getLeft();
        FibonacciNode end = leftOfEnd.getRight();
        FibonacciNode x = min.getLeft();

        System.out.println("At the begin min is: " + min.getKey() + " and end is: " + end.getKey());


        FibonacciNode y = null;
        FibonacciNode temp = null;
        int degree = 0;
        int i = 0;

         printRootList();

        do {
            System.out.println("min is " + min.getKey());
            x = x.getRight();
            System.out.println("x: " + x.getKey());
            System.out.println("right of x: " + x.getRight().getKey());

            degree = x.getDegree();

            System.out.println("Current degree is: " + degree);

            while (degreeArray[degree] != null) {
                y = degreeArray[degree];

                System.out.println("x = " + x.getKey() + " y = " + y.getKey());

                if (x.getKey() > y.getKey()) {
                    temp = x;
                    x = y;
                    y = temp;
                }
                System.out.println(" x should be smaller than y now x = " + x.getKey() + " y = " + y.getKey());

                heapLink(y,x);
                degreeArray[degree] = null;

                degree = degree + 1;
            }
            degreeArray[degree] = x;

            System.out.println("degreeArray[" + degree + "]: " + degreeArray[degree].getKey());
            System.out.println("min " + min.getKey());
            System.out.println("x: " + x.getKey());
            System.out.println("right of x: " + x.getRight().getKey());
        }
        while (!x.getRight().equals(end));

        System.out.println("Consolate ready");

        min = null;

        for (i = 0; i < maxDegree; i++) {

            if (degreeArray[i] != null) {

                System.out.println(" degreeArray[" + i + "] = " + degreeArray[i].getKey());
            }
            else {
                System.out.println(" degreeArray[" + i + "] = null");
            }
        }



        for (i = 0; i < maxDegree; i++) {

            if (degreeArray[i] != null) {

                 System.out.println(" degreeArray[" + i + "] = " + degreeArray[i].getKey());

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

                        if (degreeArray[i].getKey() < min.getKey()) {
                            min = degreeArray[i];
                        }

                    }
                    else {
                        FibonacciNode leftToMin = min.getLeft();

                        leftToMin.setRight(degreeArray[i]);
                        degreeArray[i].setLeft(leftToMin);
                        degreeArray[i].setRight(min);
                        min.setLeft(degreeArray[i]);

                        if (degreeArray[i].getKey() < min.getKey()) {
                            min = degreeArray[i];
                        }
                    }    
                }
            }
        }
    }
    public void heapLink(FibonacciNode y, FibonacciNode x) {

        System.out.println(y.getKey() + " comes child of " + x.getKey());

        FibonacciNode leftToY = y.getLeft();
        FibonacciNode rightToY = y.getRight();
        FibonacciNode temp;
        FibonacciNode leftTemp;

        
        leftToY.setRight(rightToY);
        rightToY.setLeft(leftToY);
        


        // Y becomes only child of x
        if (x.getChild() == null) {


            x.setChild(y);
            y.setParent(x);
            y.setLeft(y);
            y.setRight(y);
        }
        // Y becomes left of current child of x
        else {

            // X has only one child
            if(x.getChild().getLeft().equals(x.getChild())) {
                temp = x.getChild();

                temp.setLeft(y);
                temp.setRight(y);
                y.setLeft(temp);
                y.setRight(temp);
                y.setParent(x);
            }
            // X has more than one child
            else {
                temp = x.getChild();
                leftTemp = temp.getLeft();
                leftTemp.setRight(y);
                temp.setLeft(y);
                y.setLeft(leftTemp);
                y.setRight(temp);
                y.setParent(x);
            }
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

        if (min != null) {

            System.out.print("Contents of heaps rootlist: ");

        
            do {
                System.out.print(" " + temp.getKey());
            
                temp = temp.getRight();
            }
            while (!temp.equals(min));
            System.out.println();
        }
        else {
            System.out.println("Rootlist is empty");
        }
    }
    public void printMinSibling() {

        if (min!= null) {

            System.out.println("left of min = " + min.getLeft().getKey() + " right of min = " + min.getRight().getKey() + " min ifself " + min.getKey());
        }

    }
    public void printMinChild() {

        if (min != null) {
            if (min.getChild() != null) {
                System.out.println("Child of min " + min.getChild().getKey());
                System.out.println("Parent of child of min "+ min.getChild().getParent().getKey());
                System.out.println("left of child of min " + min.getChild().getLeft().getKey());
                System.out.println("right of child of min " + min.getChild().getRight().getKey());
            }
            else  {
                System.out.println("Min has no childs");
            }
            
        }
        else {
            System.out.println("min was null");
        }
    }


    private static double maxDegree(int n) {

        double res = 0;

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        else {
            res = (Math.log(n) / Math.log((1 + Math.sqrt(5))/2));
            res = Math.round(res);
            return res;
        }

        
    }
}
