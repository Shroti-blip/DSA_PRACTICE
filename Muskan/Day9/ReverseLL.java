package Day9;

import java.util.Scanner;

public class ReverseLL {

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }

    static class LinkedList{
        Node head;
        void insertAtEnd(int data){
            Node node=new Node(data);
            Node temp=head;
            if(head==null){
                head=node;
                return;
            }
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;
            node.next=null;
        }

        void disPlay(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.println("null");
        }

        void reverse(){
            System.out.println("Reverse LL");
        }
    }


    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter your choice");
            System.out.println("1.Add at end");
            System.out.println("2.Display");
            System.out.println("3.Exit");

            int choice = sc.nextInt();
            switch (choice){
                case 1 :
                    System.out.println("Enter data");
                    int v = sc.nextInt();
                    list.insertAtEnd(v);
                    break;
                case 2 :
                    list.disPlay();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid choice");
            }
        }
    }
}
