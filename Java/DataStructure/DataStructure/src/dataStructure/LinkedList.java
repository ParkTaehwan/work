package dataStructure;

class LinkedList {
    private LLNode head;
 
    // ��� �߰� �Լ�
    public void add(LLNode newNode) {
        if (head == null)
            head = newNode;
        else {
            LLNode tail = head;
            while (tail.nextNode != null)
                tail = tail.nextNode;
 
            tail.nextNode = newNode;
        }
    }
 
    // ��� �߰� �Լ�(������ ��ġ)
    public void add(LLNode newNode, int location) {
        // ��� ��ġ�� ���Ե� ���
        if (location == 0) {
            newNode.nextNode = head;
            head = newNode;
        } else {
            LLNode before = head;
            // ���� ��带 ã�� ����
            while ((--location) > 0)
                before = before.nextNode;
 
            newNode.nextNode = before.nextNode;
            before.nextNode = newNode;
        }
    }
 
    // ��� Ž��
    public LLNode get(int location) {
        LLNode current = head;
 
        while ((--location) >= 0)
            current = current.nextNode;
 
        return current;
    }
 
    // ��� ����
    public void remove(int location) {
        // ������ ��尡 ����̸�
        if(location == 0)
            head = head.nextNode;
        else
        {
            LLNode before = head;
            while ((--location) > 0)
                before = before.nextNode;
 
            LLNode after = before.nextNode.nextNode;
 
            if (after != null)
                before.nextNode = after;
            else
                before.nextNode = null;
        }
    }
 
    // ��� ���� ���
    public void print() {
        StringBuffer sb = new StringBuffer();
        LLNode current = head;
        int size = 0;
 
        while (current != null) {
            sb.append(current.data);
            sb.append(", ");
            current = current.nextNode;
            size++;
        }
 
        int i = sb.lastIndexOf(", ");
        sb.delete(i, i + 2);
 
        System.out.println("[ " + sb + " ]");
        System.out.println("size : " + size);
    }
}