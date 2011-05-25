/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kekovertailu;

/**
 *
 * @author tatutahv
 */
public class FibonacciNode {

    private FibonacciNode left;
    private FibonacciNode right;
    private FibonacciNode parent;
    private FibonacciNode child;
    private int key;
    private int degree;
    private boolean mark;

    public FibonacciNode() {

        this.key = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.child = null;
        this.degree = 0;
        this.mark = false;
    }
    public FibonacciNode(int k) {
        this.key = k;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.child = null;
        this.degree = 0;
        this.mark = false;
    }
    public void setDegree(int d) {
        this.degree = d;
    }
    public void setLeft(FibonacciNode node) {
        this.left = node;
    }
    public void setRight(FibonacciNode node) {
        this.right = node;
    }
    public int getKey() {
        return this.key;
    }
    public FibonacciNode getLeft() {
        return this.left;
    }
    public FibonacciNode getRight() {
        return this.right;
    }

}
