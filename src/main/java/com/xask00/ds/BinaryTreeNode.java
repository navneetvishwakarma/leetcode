package com.xask00.ds;

public class BinaryTreeNode<T> {
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    T value;

    public BinaryTreeNode(T val) {
        this.value = val;
    }
}
