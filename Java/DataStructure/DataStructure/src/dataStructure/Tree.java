package dataStructure;

class Tree {
    // ���� ��ȸ
    public static void preorderPrintTree(TNode node) {
        if(node == null)
            return;
         
        // �θ� ��� ���
        System.out.print(" " + node.getData());
         
        // ���� ���� Ʈ�� ���
        preorderPrintTree(node.getLeft());
         
        // ������ ���� Ʈ�� ���
        preorderPrintTree(node.getRight());
    }
     
    // ���� ��ȸ
    public static void inorderPrintTree(TNode node) {
        if(node == null)
            return;
         
        // ���� ���� Ʈ�� ���
        inorderPrintTree(node.getLeft());
         
        // �θ� ��� ���
        System.out.print(" " + node.getData());
         
        // ������ ���� Ʈ�� ���
        inorderPrintTree(node.getRight());
    }
     
    // ���� ��ȸ
    public static void postorderPrintTree(TNode node) {
        if(node == null)
            return;
         
        // ���� ���� Ʈ�� ���
        postorderPrintTree(node.getLeft());
         
        // ������ ���� Ʈ�� ���
        postorderPrintTree(node.getRight());
         
        // �θ� ��� ���
        System.out.print(" " + node.getData());
    }
}
