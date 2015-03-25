package dataStructure;

class Queue {
    private QNode[] nodes;
    private int capacity;
    private int front;
    private int rear;
 
    // ��ȯ ť ����
    public Queue(int capacity) {
        // �ʱ�ȭ
        this.capacity = capacity;
 
        // �迭 ���� & �޸� �Ҵ�
        nodes = new QNode[capacity + 1];
        for (int i = 0; i < capacity + 1; i++)
            nodes[i] = new QNode();
    }
 
    // ����
    public void enqueue(int data) {
        int position = 0;
 
        // ť�� �Ĺ�(rear)�� �迭�� ����ٸ�
        if (rear == capacity + 1) {
            // �Ĺ��� index�� 0���� �ʱ�ȭ(��ȯ ť�̹Ƿ� ��� ���ƿ´�.)
            rear = 0;
            position = 0;
        } else
            // �׷��� �ʴٸ� �״�� ����
            position = rear++;
 
        // ������ ����
        nodes[position].setData(data);
    }
 
    // ����
    public int dequeue() {
        int position = front;
 
        // ť�� ����(front)�� �迭 ���� ��ġ��������
        if (front == capacity)
            front = 0;
        else
            // �׷��� �ʴٸ� �״�� ����
            front++;
 
        return nodes[position].getData();
    }
 
    // ������ ��ȯ
    public int getSize() {
        // ���� index�� �Ĺ� index���� �տ� ��ġ�� �ִٸ�
        if (front <= rear)
            return rear - front;
        else
            return (capacity + 1) - front + rear;
    }
 
    // ������ ����ִ���
    public boolean isEmpty() {
        return front == rear;
    }
 
    // �� �� �ִ���
    public boolean isFull() {
        // ���� index�� �Ĺ� index���� �տ� ��ġ�� �ִٸ�
        if (front < rear)
            return (rear - front) == capacity;
        else
            return (rear + 1) == front;
    }
 
    public int getCapacity() {
        return capacity;
    }
 
    public int getFront() {
        return front;
    }
 
    public int getRear() {
        return rear;
    }
}