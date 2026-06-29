package LinkedList;

import java.util.Scanner;

public class LL3 {
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
            Node node = new Node(data);
            Node temp=head;
            if(head==null){
                head=node;
                return;
            }
             while(temp.next!=null){
                 temp=temp.next;
             }
             temp.next=node;
        }

        void insertAnywhere(int idx , int data){
            Node node = new Node(data);
            Node temp=head;
            int count=0;
            if(idx==0){
                node.next=head;
                head=node;
                return;
            }

            if(temp!=null && count<idx-1){
                temp=temp.next;
                count++;
            }
            node.next=temp.next;
            temp.next=node;

        }
        void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.println("null");
        }

        void deleteByValue(int data){
            Node temp=head.next;
            Node prev=head;

            if(head==null){
                System.out.println("LinkedList is Empty.");
                return;
            }

            if(head.data==data){
                head=head.next;
                return;
            }
            while(temp!=null){
                if(temp.data==data){
                    prev.next=temp.next;
                }
                prev=temp;
                temp=temp.next;
            }
        }

        void deleteAfterValue(int val){
            Node temp=head;
            if(head.data==val){
                head.next=head.next.next;
                return;
            }

            while(temp!=null){
                if(temp.data==val){
                    temp.next=temp.next.next;
                }
                temp=temp.next;
            }
        }
    }
    public static void main(String[] args) {
        LinkedList list= new LinkedList();
        Scanner sc = new Scanner(System.in);

      while(true){

        System.out.println("Enter Your choice");
        System.out.println("1)Insert At End");
        System.out.println("2)Insert anywhere");
        System.out.println("3)Display");
        System.out.println("4)Delete by value");
          System.out.println("5)Delete node after given one.");
        int choice = sc.nextInt();

        switch (choice){
            case 1:
                System.out.println("Enter data ");
                int data=sc.nextInt();
                list.insertAtEnd(data);
                break;
            case 2:
                System.out.println("Enter idx");
                int idx=sc.nextInt();
                System.out.println("Enter Data");
                int val = sc.nextInt();

                list.insertAnywhere(idx,val);
                break;
            case 3:
                list.display();
                break;
            case 4:
                System.out.println("Enter node value you wanted to delete");
                int c = sc.nextInt();
                list.deleteByValue(c);
            case 5:
                System.out.println("Enter that earlier node: ");
                int n = sc.nextInt();
                list.deleteAfterValue(n);
            default:
                System.out.println("Invalid choice.");
        }
     }
    }
}
