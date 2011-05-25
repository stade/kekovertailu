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
            
            // If min is the only node in the heap node becames left and right of min
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

                temp.setRight(node);
                node.setLeft(temp);
                node.setRight(min);
                min.setLeft(node);

            }
            if (node.getKey() < min.getKey()) {

                min = node;

            }
         } 
        numNodes = numNodes + 1;
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
