package LinkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class LL1 {

    static class Node{
        int data;
        Node next;
         Node(int data){
            this.data=data;
        }
    }

    static class LinkedList{
        Node head ;


        void insertAtEnd(int data){
            Node node = new Node(data);

            if(head==null){
                head=node;
                return;
            }
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
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

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Enter your choice");
            System.out.println("1)Add Element");
            System.out.println("2)Print Element");


            int choice =sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter element: ");
                    int num = sc.nextInt();
                    list.insertAtEnd(num);
                    break;
                case 2:
                    list.display();
                    break;
                default:
                    System.out.println("Wrong choice sir");
                    return;
            }
        }

    }
}
