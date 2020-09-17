package com.testing_lab1;

public class LeftistHeap {

    private LeftistHeapNode rootNode;
    private String inorderTraverse = "";

    public LeftistHeap() {
        rootNode = null;
    }

    private LeftistHeapNode merge(LeftistHeapNode leftHeap, LeftistHeapNode rightHeap) {

        if (leftHeap == null)
            return rightHeap;
        if (rightHeap == null)
            return leftHeap;
        if (leftHeap.element > rightHeap.element)  {
            LeftistHeapNode tempNode = leftHeap;
            leftHeap = rightHeap;
            rightHeap = tempNode;
        }

        leftHeap.rightChild = merge(leftHeap.rightChild, rightHeap);

        if (leftHeap.leftChild == null)
        {
            leftHeap.leftChild = leftHeap.rightChild;
            leftHeap.rightChild = null;

        } else {

            if (leftHeap.leftChild.sValue < leftHeap.rightChild.sValue) {

                LeftistHeapNode temp = leftHeap.leftChild;
                leftHeap.leftChild = leftHeap.rightChild;
                leftHeap.rightChild = temp;
            }

            leftHeap.sValue = leftHeap.rightChild.sValue + 1;
        }
        return leftHeap;
    }

    public void insert(int x) {
        rootNode = merge(new LeftistHeapNode(x), rootNode);
    }

    public int deleteMin() {

        if (rootNode == null)
            return -1;
        int minItem = rootNode.element;
        rootNode = merge(rootNode.leftChild, rootNode.rightChild);
        return minItem;

    }

    public void clear() {
        rootNode = null;
    }

    public void printHeap() {
        System.out.println(inorder(rootNode));
    }

    private String inorder(LeftistHeapNode rootNode) {

        if (rootNode != null) {
            inorder(rootNode.leftChild);
            inorderTraverse = inorderTraverse + rootNode.element.toString() + " ";
            inorder(rootNode.rightChild);
        }

        return inorderTraverse;

    }

}
