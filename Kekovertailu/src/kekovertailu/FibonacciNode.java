
package kekovertailu;


/**
 * FibonacciNode <code>FibonacciNode</code> Implements nodes of Fibonacci-heap datastructure.
 *
 * @author Tatu Tahvanainen

 */
public class FibonacciNode {

    private FibonacciNode left;
    private FibonacciNode right;
    private FibonacciNode parent;
    private FibonacciNode child;
    private int key;
    private int degree;
    private boolean mark;

    /**
      *  Creates a FibonacciNode.
      */
    public FibonacciNode() {
        this.key = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.child = null;
        this.degree = 0;
        this.mark = false;
    }
    /**
      *  Creates a Fibonaccinode object which key is given as a integer.
      *
      *  @param k Key of FibonacciNode
      */
    public FibonacciNode(int k) {
        this.key = k;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.child = null;
        this.degree = 0;
        this.mark = false;
    }
    /**
      *  Sets given integer as key of Fibonaccinode
      *
      *  @param k Key of FibonacciNode
      */
    public void setKey(int k) {
        this.key = k;
    }
    /**
      *  Sets a given Fibonaccinode as a left node of Fibonaccinode.
      *
      *  @param node FibonacciNode
      */
    public void setLeft(FibonacciNode node) {
        this.left = node;
    }
    /**
      *  Sets a given Fibonaccinode as a right node of this Fibonaccinode.
      *
      *  @param node FibonacciNode
      */
    public void setRight(FibonacciNode node) {
        this.right = node;
    }
    /**
      *  Sets a given Fibonaccinode as a parent of this Fibonaccinode.
      *
      *  @param node FibonacciNode
      */
    public void setParent(FibonacciNode node) {
        this.parent = node;
    }
     /**
      *  Sets a given Fibonaccinode as a parent of this Fibonaccinode.
      *
      *  @param node FibonacciNode
      */
    public void setChild(FibonacciNode node) {
        this.child = node;
    }
     /**
      *  Sets the degree of Fibonaccinode.
      *
      *  @param d degree
      */
    public void setDegree(int d) {
        this.degree = d;
    }
     /**
      *  Sets a mark of Fibonaccinode which is given to asure that no node has
      *  too many childs to compared to number of all nodes of Fibonacciheap.
      *
      *  @param b mark
      */
    public void setMark(boolean b) {
        this.mark = b;
    }
    /**
      *  Retuns key of this Fibonaccinode.
      *
      *  @return key key of this Fibonaccinode.
      */
    public int getKey() {
        return this.key;
    }
     /**
      *  Returns left Fibonaccinode of this Fibonaccinode.
      *
      *  @return left null if node has no left node.
      */
    public FibonacciNode getLeft() {
        return this.left;
    }
    /**
      *  Returns right Fibonaccinode of this FibonacciNode.
      *
      *  @return right null if node has no right node.
      */
    public FibonacciNode getRight() {
        return this.right;
    }
     /**
      *  Returns parent Fibonaccinode of this Fibonaccinode.
      *
      *  @return parent null if node has no parent node.
      */
    public FibonacciNode getParent() {
        return this.parent;
    } /**
      *  Returns child Fibonaccinode of this Fibonaccinode.
      *
      *  @return child null if node has no child node.
      */
    public FibonacciNode getChild() {
        return this.child;
    }
     /**
      *  Returns degree of this Fibonaccinode.
      *
      *  @return degree degree as a integer
      */
    public int getDegree() {
        return this.degree;
    }
     /**
      *  Returns mark of this FibonacciNode.
      *
      *  @return mark 
      */
    public boolean getMark() {
        return this.mark;
    }
}
