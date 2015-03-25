package dataStructure;

class TNode {
    private char data;
    private TNode left;
    private TNode right;
 
    public TNode(char data) {
        this.setData(data);
    }
 
    public void setData(char data) {
        this.data = data;
    }
 
    public char getData() {
        return data;
    }
 
    public void setLeft(TNode left) {
        this.left = left;
    }
 
    public TNode getLeft() {
        return left;
    }
 
    public void setRight(TNode right) {
        this.right = right;
    }
 
    public TNode getRight() {
        return right;
    }
}