package dataStructure;

class Stack {
    private Node nodes[];
    private int capacity;
    private int top;
 
    // 생성자
    public Stack(int capacity) {
        // 초기화
        nodes = new Node[capacity];
        for(int i = 0; i < capacity; i ++)
            nodes[i] = new Node();
         
        this.capacity = capacity;
        top = 0;
    }
 
    // 삽입
    public void push(int data) {
        nodes[top].data = data;
        top++;
    }
 
    // 제거
    public int pop() {
        // 실제 top의 값은 index + 1 인 상태이므로
        return nodes[--top].data;
    }
 
    // 용량 반환
    public int capacity() {
        return capacity;
    }
 
    // 최상위 노드 반환
    public int top() {
        return nodes[top - 1].data;
    }
 
    // 사이즈
    public int size() {
        return top;
    }
 
    // 비어있는지 확인
    public boolean isEmpty() {
        return top == 0;
    }
 
    // 가득 찼는지 확인
    public boolean isFull() {
        return capacity == top;
    }
}
