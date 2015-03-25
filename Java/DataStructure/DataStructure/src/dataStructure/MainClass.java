package dataStructure;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner =new Scanner(System.in);
		
		int sw=1;
		
		while(true){
			System.out.println("1. LinkedList");
			System.out.println("2. Stack");
			System.out.println("3. Queue");
			System.out.println("4. Tree");
			System.out.println("5. Sort");
			System.out.println("6. Search\n");
			System.out.print("실행할 자료구조를 선택하세요 : ");
			
			sw=scanner.nextInt();
			System.out.print("\n");
			
			
			if(sw==1){
				LinkedList list = new LinkedList();
		         
		        // 노드 5개 추가
		        for(int i = 0; i < 5; i++)
		            list.add(new LLNode(i));
		 
		        list.print();
		         
		        System.out.println("\nDelete node from index : 2\n");
		        list.remove(2);
		        list.print();
		 
		        System.out.println("\nInsert node(100) to index : 2");
		        System.out.println("Insert node(200) to index : 2\n");
		        list.add(new LLNode(100), 2);
		        list.add(new LLNode(200), 2);
		        list.print();
		         
		        System.out.println("\nRemove node from index : 0\n");
		        list.remove(0);
		        list.print();	
		        System.out.print("\n");
			}
			
			else if(sw==2){
			    // 스택 생성
		        Stack stack = new Stack(5);
		         
		        // 데이터 추가
		        stack.push(3);
		        stack.push(37);
		        stack.push(11);
		        stack.push(12);
		         
		        if(stack.isFull())
		            stack.push(20);
		         
		        // 정보 출력
		        int size = stack.size();
		        System.out.printf("Capacity : %d, Size : %d, Top : %d\n\n",
		                stack.capacity(), size, stack.top());
		         
		        for(int i = 0; i <size; i++){
		            if(stack.isEmpty())
		                break;
		             
		            System.out.printf("Popped : %d, ", stack.pop());
		             
		            if(!stack.isEmpty())
		                System.out.printf("Current Top : %d\n", stack.top());
		            else
		                System.out.println("Stack Is Empty.");
		        }
		        System.out.print("\n"); 
		    
			}
			
			else if(sw==3){
			       Queue q = new Queue(10);
			       
			        // 큐 삽입
			        q.enqueue(1);
			        q.enqueue(2);
			        q.enqueue(3);
			        q.enqueue(4);
			 
			        // 출력
			        for (int i = 0; i <= q.getSize(); i++)
			            System.out.printf("Dequeue : %d,  Front : %d,  Rear : %d\n",
			                    q.dequeue(), q.getFront(), q.getRear());
			         
			        // 꽉 찰때까지 삽입
			        int j = 100;
			        while(!q.isFull())
			            q.enqueue(j++);
			         
			        System.out.printf("Capacity : %d,  Size : %d\n\n",
			                q.getCapacity(), q.getSize());
			         
			        // 전부 비울때까지 제거
			        while(!q.isEmpty())
			            System.out.printf("Dequeue : %d,  Front : %d,  Rear : %d\n",
			                    q.dequeue(), q.getFront(), q.getRear());
			        System.out.print("\n");
			        
			}
			
			else if(sw==4){
				// 노드 생성
		        TNode A = new TNode('A');
		        TNode B = new TNode('B');
		        TNode C = new TNode('C');
		        TNode D = new TNode('D');
		        TNode E = new TNode('E');
		        TNode F = new TNode('F');
		        TNode G = new TNode('G');
		         
		        // 트리에 노드 추가
		        A.setLeft(B);
		        B.setLeft(C);
		        B.setRight(D);
		         
		        A.setRight(E);
		        E.setLeft(F);
		        E.setRight(G);
		         
		         
		        // 출력
		        System.out.println("Preorder...");
		        Tree.preorderPrintTree(A);
		        System.out.println("\n");
		 
		        System.out.println("Inorder...");
		        Tree.inorderPrintTree(A);
		        System.out.println("\n");
		         
		        System.out.println("Postorder...");
		        Tree.postorderPrintTree(A);
		        System.out.print("\n");
			}
			
			else if(sw==5){
				int data[] = {2, 9, 10, 3, 7, 15, 5};
				  System.out.println("원래 데이터: ");
				  for(int i = 0; i< data.length; i++)
				   System.out.print(data[i] + " ");

				  System.out.println("\n");
				  System.out.println("버블 정렬 후");

				  for(int i=0; i<6; i++){
				   for(int j=0; j<(6-i); j++){ // 비교를 하나씩 감소 시키기 위해서 6-i 번 째 까지 해줌
				    if(data[j] > data[j+1]){
				     int k = data[j];  // swap 알고리즘
				     data[j] = data[j+1];  // 서로 데이터 교체
				     data[j+1] = k;
				    }
				   }
				  }

				  for(int i = 0; i< data.length; i++)
				   System.out.print(data[i] + " ");
				  System.out.print("\n");
				  System.out.print("\n");
			}
			
			else if(sw==6){
				int[] a = { 2, 3, 5, 7, 11, 15, 24, 35, 40, 50};
				int count = 1;
				boolean flag = false;
				
				int start = 0;
				int end = a.length;
				int find = 35;
				
				System.out.println("찾는값 : " + find);
				System.out.println("검색시작");
				do{
					if(find < a[(start+end)/2]) {
						System.out.println((start+end)/2 + " " + a[(start+end)/2]);
						end = (int)((start+end)/2)-1;
						count++;
					}
					else if(find > a[(start + end)/2]) {
						System.out.println((start+end)/2 + " " + a[(start+end)/2]);
						start = (int)((start+end)/2)+1;
						count++;
					}
					else{
						flag = true;
					}
					
				}while(!flag);
				
				System.out.println(count + "번째에	검색 완료");
				System.out.print("\n");
			}
			
			else if(sw==0)
				break;
	}

}
}
