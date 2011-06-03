/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kekovertailu;

/**
 *
 * @author tatutahv
 *
 * This class implements nodes of Fibonacci-heap datastructure
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
    public void setKey(int k) {
        this.key = k;
    }
    public void setLeft(FibonacciNode node) {
        this.left = node;
    }
    public void setRight(FibonacciNode node) {
        this.right = node;
    }
    public void setParent(FibonacciNode node) {
        this.parent = node;
    }
    public void setChild(FibonacciNode node) {
        this.child = node;
    }
    public void setDegree(int d) {
        this.degree = d;
    }
    public void setMark(boolean b) {
        this.mark = b;
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
    public FibonacciNode getParent() {
        return this.parent;
    }
    public FibonacciNode getChild() {
        return this.child;
    }
    public int getDegree() {
        return this.degree;
    }
    public boolean getMark() {
        return this.mark;
    }
}