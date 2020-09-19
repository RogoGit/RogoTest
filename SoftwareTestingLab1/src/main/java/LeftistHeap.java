public class LeftistHeap {

    private LeftistHeapNode rootNode;
    private String inorderTraverse = "";
    private String sValues = "";

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

    public Integer deleteMin() {

        if (rootNode == null)
            return null;
        int minItem = rootNode.element;
        rootNode = merge(rootNode.leftChild, rootNode.rightChild);
        return minItem;

    }

    public void clear() {
        rootNode = null;
    }

    public String showSValues() {
        return getSValues(rootNode);
    }

    private String getSValues(LeftistHeapNode rootNode) {

        if (rootNode != null) {
            getSValues(rootNode.leftChild);
            getSValues(rootNode.rightChild);
            sValues = sValues + rootNode.sValue.toString() + " ";
        }

        return sValues;

    }

    public String printHeap() {
        return inorder(rootNode);
    }

    private String inorder(LeftistHeapNode rootNode) {

        if (rootNode != null) {
            inorder(rootNode.leftChild);
            inorder(rootNode.rightChild);
            inorderTraverse = inorderTraverse + rootNode.element.toString() + " ";
        }

        return inorderTraverse;

    }

}
