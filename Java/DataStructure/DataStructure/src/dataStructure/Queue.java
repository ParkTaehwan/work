package dataStructure;

class Queue {
    private QNode[] nodes;
    private int capacity;
    private int front;
    private int rear;
 
    // 순환 큐 생성
    public Queue(int capacity) {
        // 초기화
        this.capacity = capacity;
 
        // 배열 생성 & 메모리 할당
        nodes = new QNode[capacity + 1];
        for (int i = 0; i < capacity + 1; i++)
            nodes[i] = new QNode();
    }
 
    // 삽입
    public void enqueue(int data) {
        int position = 0;
 
        // 큐의 후방(rear)이 배열을 벗어났다면
        if (rear == capacity + 1) {
            // 후방의 index를 0으로 초기화(순환 큐이므로 계속 돌아온다.)
            rear = 0;
            position = 0;
        } else
            // 그렇지 않다면 그대로 증가
            position = rear++;
 
        // 데이터 삽입
        nodes[position].setData(data);
    }
 
    // 제거
    public int dequeue() {
        int position = front;
 
        // 큐의 전방(front)이 배열 끝에 위치해있으면
        if (front == capacity)
            front = 0;
        else
            // 그렇지 않다면 그대로 증가
            front++;
 
        return nodes[position].getData();
    }
 
    // 사이즈 반환
    public int getSize() {
        // 전방 index가 후방 index보다 앞에 위치해 있다면
        if (front <= rear)
            return rear - front;
        else
            return (capacity + 1) - front + rear;
    }
 
    // 완전히 비어있는지
    public boolean isEmpty() {
        return front == rear;
    }
 
    // 꽉 차 있는지
    public boolean isFull() {
        // 전방 index가 후방 index보다 앞에 위치해 있다면
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