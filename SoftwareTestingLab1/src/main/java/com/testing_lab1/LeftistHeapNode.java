package com.testing_lab1;

public class LeftistHeapNode {

    Integer element, sValue;
    LeftistHeapNode leftChild, rightChild;

    public LeftistHeapNode(int element) {

        this(element, null, null);

    }

    private LeftistHeapNode(int element, LeftistHeapNode left, LeftistHeapNode right) {

        this.element = element;
        this.leftChild = left;
        this.rightChild = right;
        this.sValue = 0;

    }

}
