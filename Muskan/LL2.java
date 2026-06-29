package LinkedList;


import java.util.Scanner;

public class LL2 {

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

        void insertAtMiddle(int data, int idx) {
            Node node = new Node(data);


            if (idx == 0) {
                node.next = head;
                head = node;
                return;
            }

            Node temp = head;
            int count = 0;

            while (temp != null && count < idx - 1) {
                temp = temp.next;
                count++;
            }


            node.next = temp.next;
            temp.next = node;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Enter your choice");
            System.out.println("1)Add Element");
            System.out.println("2)Add anywhere");
            System.out.println("3)Print Element");


            int choice =sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter element: ");
                    int num = sc.nextInt();
                    list.insertAtEnd(num);
                    break;

                case 2:
                    System.out.print("Enter index: ");
                    int idx = sc.nextInt();

                    System.out.print("Enter data: ");
                    int num1 = sc.nextInt();

                    list.insertAtMiddle(num1, idx);
                    break;
                case 3:
                    list.display();
                    break;
                default:
                    System.out.println("Wrong choice sir");
                    return;
            }
        }

    }
}
