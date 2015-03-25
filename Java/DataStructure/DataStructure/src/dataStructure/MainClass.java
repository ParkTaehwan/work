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
			System.out.print("������ �ڷᱸ���� �����ϼ��� : ");
			
			sw=scanner.nextInt();
			System.out.print("\n");
			
			
			if(sw==1){
				LinkedList list = new LinkedList();
		         
		        // ��� 5�� �߰�
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
			    // ���� ����
		        Stack stack = new Stack(5);
		         
		        // ������ �߰�
		        stack.push(3);
		        stack.push(37);
		        stack.push(11);
		        stack.push(12);
		         
		        if(stack.isFull())
		            stack.push(20);
		         
		        // ���� ���
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
			       
			        // ť ����
			        q.enqueue(1);
			        q.enqueue(2);
			        q.enqueue(3);
			        q.enqueue(4);
			 
			        // ���
			        for (int i = 0; i <= q.getSize(); i++)
			            System.out.printf("Dequeue : %d,  Front : %d,  Rear : %d\n",
			                    q.dequeue(), q.getFront(), q.getRear());
			         
			        // �� �������� ����
			        int j = 100;
			        while(!q.isFull())
			            q.enqueue(j++);
			         
			        System.out.printf("Capacity : %d,  Size : %d\n\n",
			                q.getCapacity(), q.getSize());
			         
			        // ���� ��ﶧ���� ����
			        while(!q.isEmpty())
			            System.out.printf("Dequeue : %d,  Front : %d,  Rear : %d\n",
			                    q.dequeue(), q.getFront(), q.getRear());
			        System.out.print("\n");
			        
			}
			
			else if(sw==4){
				// ��� ����
		        TNode A = new TNode('A');
		        TNode B = new TNode('B');
		        TNode C = new TNode('C');
		        TNode D = new TNode('D');
		        TNode E = new TNode('E');
		        TNode F = new TNode('F');
		        TNode G = new TNode('G');
		         
		        // Ʈ���� ��� �߰�
		        A.setLeft(B);
		        B.setLeft(C);
		        B.setRight(D);
		         
		        A.setRight(E);
		        E.setLeft(F);
		        E.setRight(G);
		         
		         
		        // ���
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
				  System.out.println("���� ������: ");
				  for(int i = 0; i< data.length; i++)
				   System.out.print(data[i] + " ");

				  System.out.println("\n");
				  System.out.println("���� ���� ��");

				  for(int i=0; i<6; i++){
				   for(int j=0; j<(6-i); j++){ // �񱳸� �ϳ��� ���� ��Ű�� ���ؼ� 6-i �� ° ���� ����
				    if(data[j] > data[j+1]){
				     int k = data[j];  // swap �˰���
				     data[j] = data[j+1];  // ���� ������ ��ü
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
				
				System.out.println("ã�°� : " + find);
				System.out.println("�˻�����");
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
				
				System.out.println(count + "��°��	�˻� �Ϸ�");
				System.out.print("\n");
			}
			
			else if(sw==0)
				break;
	}

}
}
