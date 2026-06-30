package DoublyLinkedList;

import java.util.Scanner;

public class DLL1 {

    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
        }
    }

    static class DLinkedList{
        Node head;
        void insertAtEnd(int data){
            Node node = new Node(data);
            Node temp=head;
            if(head==null){
                head=node;
                head.next=null;
                return;
            }
            while (temp.next!=null){
                temp=temp.next;
            }
            node.prev=temp;
            temp.next=node;

        }

        void displayForward(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+"<->");
                temp=temp.next;
            }
            System.out.println("null");
        }

        void displayBackward(){
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;

            }

            while(temp!=head){
                System.out.print(temp.data+"<->");
                temp=temp.prev;
            }
            System.out.println("null");
        }
    }
    public static void main(String[] args) {
        DLinkedList list = new DLinkedList();
        Scanner sc  = new Scanner(System.in);
        while(true){
            System.out.println("Enter your choice: ");
            System.out.println("1)Insert at end");
            System.out.println("2)Display Forward");
            System.out.println("3)Display Backward");
            int c = sc.nextInt();
            switch (c){
                case 1:
                    System.out.println("Enter Node value: ");
                    int v = sc.nextInt();
                    list.insertAtEnd(v);
                    break;
                case 2:
                    list.displayForward();
                    break;
                case 3:
                    list.displayBackward();
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }
    }
}
