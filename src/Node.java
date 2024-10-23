/***********************************************************
 * @file: Node.java
 * @Description: This file contains the implementation of a single node in the binary search tree and the multiple task that can be performed on these nodes
 * @Author: Fiona Zhang
 * @Date: October 23, 2024
 ***********************************************************/

public class Node<AnyType extends Comparable<AnyType>> {
    private AnyType element;
    private Node<AnyType> left;
    private Node<AnyType> right;

// Implement the constructor

    public Node(AnyType element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

// Implement the setElement method

    public void setElement(AnyType element) {
        this.element = element;
    }

// Implement the setLeft method

    public void setLeft(Node<AnyType> left) {
        this.left = left;
    }

    // Implement the setRight method
    public void setRight(Node<AnyType> right) {
        this.right = right;
    }

    // Implement the getLeft method
    public Node<AnyType> getLeft() {
        return left;
    }

    // Implement the getRight method
    public Node<AnyType> getRight() {
        return right;
    }

    // Implement the getElement method
    public AnyType getElement() {
        return element;
    }

    // Implement the isLeaf method
    public boolean isLeaf() {
        return left == null && right == null;
    }
}