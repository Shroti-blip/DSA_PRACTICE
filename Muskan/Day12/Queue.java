package Day12;

import java.util.Scanner;

public class Queue {

    static class Node{
        int data;
        Node next;
//        Node rear;
        Node(int data){
            this.data=data;
        }
    }

    static class QueueOperations{
        Node front;
        Node rear;

        void enqueue(int data){

            Node node = new Node( data);
            if(front==null){//10
                front=rear=node;
                return;
            }
             rear.next=node;//10->node
             rear=node;//node=rear

        }

        void display(){
            Node temp=front;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.println("null");
        }

        void deque(){
            if(front==null){
                System.out.println("Queue is Empty.");
                return;
            }
            front=front.next;
        }

        boolean isEmpty(){
            if(front==null){
                return true;
            }
            return false;
        }

        int size(){
            Node temp=front;
            int count =0;
            while(temp!=null){
                count+=1;
                temp=temp.next;
            }
            return count;
        }

        int peek (){
            if(front==null){
                System.out.println("Queue is Empty.");
                return -1;
            }
            return rear.data;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueOperations q = new QueueOperations();

        while(true){
            System.out.println("Enter your choice");
            System.out.println("1.Add");
            System.out.println("2.Display");
            System.out.println("3.Dequeue/Delete");
            System.out.println("4.Size");
            System.out.println("5.Peek");
            System.out.println("6.Empty or not?");
            System.out.println("7.Exit");
            int c= sc.nextInt();

            switch (c){
                case 1:
                    System.out.println("Enter data: ");
                    q.enqueue(sc.nextInt());
                    break;
                case 2 :
                    q.display();
                    break;
                case 3:
                    q.deque();
                    break;
                case 4:
                    int size =  q.size();
                    System.out.println("Queue size is : "+ size);
                    break;
                case 5:
                     int rear=q.peek();
                    System.out.println("Rear value"+rear);
                    break;
                case 6:
                     boolean res = q.isEmpty();
                    System.out.println("Queue is Empty ?"+res);
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }

    }
}
