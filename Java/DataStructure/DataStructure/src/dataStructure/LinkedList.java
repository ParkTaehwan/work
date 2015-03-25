package dataStructure;

class LinkedList {
    private LLNode head;
 
    // 노드 추가 함수
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
 
    // 노드 추가 함수(지정된 위치)
    public void add(LLNode newNode, int location) {
        // 헤드 위치에 삽입될 경우
        if (location == 0) {
            newNode.nextNode = head;
            head = newNode;
        } else {
            LLNode before = head;
            // 이전 노드를 찾아 연결
            while ((--location) > 0)
                before = before.nextNode;
 
            newNode.nextNode = before.nextNode;
            before.nextNode = newNode;
        }
    }
 
    // 노드 탐색
    public LLNode get(int location) {
        LLNode current = head;
 
        while ((--location) >= 0)
            current = current.nextNode;
 
        return current;
    }
 
    // 노드 삭제
    public void remove(int location) {
        // 제거할 노드가 헤드이면
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
 
    // 노드 정보 출력
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