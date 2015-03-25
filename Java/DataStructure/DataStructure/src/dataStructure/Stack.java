package dataStructure;

class Stack {
    private Node nodes[];
    private int capacity;
    private int top;
 
    // ������
    public Stack(int capacity) {
        // �ʱ�ȭ
        nodes = new Node[capacity];
        for(int i = 0; i < capacity; i ++)
            nodes[i] = new Node();
         
        this.capacity = capacity;
        top = 0;
    }
 
    // ����
    public void push(int data) {
        nodes[top].data = data;
        top++;
    }
 
    // ����
    public int pop() {
        // ���� top�� ���� index + 1 �� �����̹Ƿ�
        return nodes[--top].data;
    }
 
    // �뷮 ��ȯ
    public int capacity() {
        return capacity;
    }
 
    // �ֻ��� ��� ��ȯ
    public int top() {
        return nodes[top - 1].data;
    }
 
    // ������
    public int size() {
        return top;
    }
 
    // ����ִ��� Ȯ��
    public boolean isEmpty() {
        return top == 0;
    }
 
    // ���� á���� Ȯ��
    public boolean isFull() {
        return capacity == top;
    }
}
