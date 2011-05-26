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
            // If node is smaller than min it becames min
            
            // If min is the only node in the heap, node becames left and right of min
            if (min.getLeft().equals(min)) {

                min.setLeft(node);
                min.setRight(node);
                node.setLeft(min);
                node.setRight(min); 

            }
            // If there is more nodes than min in the heap, node becames left of min and right of
            // the node that was left to min
            else {
                   
                FibonacciNode temp = min.getLeft();

                node.setRight(min);
                node.setLeft(temp);
                min.setLeft(node);
                temp.setRight(node);
               
            }
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
        FibonacciNode nextchild = child.getRight();

        // If min node has childs nodes they are added to the root list
        if (child != null) {

            // If min has only one child
            if (child.getLeft().equals(child)) {

                FibonacciNode temp = min.getLeft();

                child.setRight(min);
                child.setLeft(temp);
                min.setLeft(child);
                temp.setRight(child);

                child.setParent(null);

            }
            else {
                // If min has more than one child
                while (child.getLeft().equals(child)) {

                    child = child.getLeft();

                    FibonacciNode temp = min.getLeft();

                    child.setRight(min);
                    child.setLeft(temp);
                    min.setLeft(child);
                    temp.setRight(child);

                    child.setParent(null);

                }

                FibonacciNode temp = min.getLeft();

                child.setRight(min);
                child.setLeft(temp);
                min.setLeft(child);
                temp.setRight(child);

                child.setParent(null);
            }
        }

        FibonacciNode leftToMin = min.getLeft();
        FibonacciNode rightToMin = min.getRight();

        leftToMin.setRight(rightToMin);
        rightToMin.setLeft(leftToMin);

        if (min.getRight().equals(min)) {
            min = null;
        }
        else {
            min = min.getRight();
            consolidate();
        }

        toBeDeleted.setLeft(null);
        toBeDeleted.setRight(null);
        toBeDeleted.setChild(null);

        numNodes--;

        return toBeDeleted.getKey();
    }
    private void consolidate() {
        FibonacciNode[] array = new FibonacciNode[numNodes];

        for (i = 0; i < numNodes, i++) {

            
        }
        




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

        int i = 0;
        FibonacciNode temp = min;

        while (i < numNodes) {

           
            System.out.println(temp.getKey());

            temp = temp.getLeft();
            i++;

        }  
    }
}
