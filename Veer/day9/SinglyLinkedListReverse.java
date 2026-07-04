package org.example.day9;

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class SinglyLinkedListReverse {
    public static java.util.Scanner sc=new java.util.Scanner(System.in);
    private static Node head=null;

    public static void addNewNode(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }else {
            Node last = head;
            while (last.next != null)
                last = last.next;
            last.next = newNode;
        }
        System.out.println("New Node Added");

    }
    public static void traverse(){
        if(head==null){
            System.out.println("No nodes found!");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data + " ->");
            temp=temp.next;
        }
        System.out.println(" NULL\n");
    }
    public static void reverseList(){
        if(head==null){
            System.out.println("No nodes found!");
            return;
        }
    }
    public static void reverseWithoutChangingList(){
        if(head==null){
            System.out.println("No nodes found!");
            return;
        }
    }

    public static void main(String [] args){
        int ch;
        do{
            System.out.println("1. Add new node");
            System.out.println("2. Traverse");
            System.out.println("3. Reverse");
            System.out.println("4. Reverse without changing the list");
            System.out.println("5  Exit");
            System.out.print("Select a choice : ");
            ch=sc.nextInt();
            if(ch==1){
                System.out.print("Enter data to add : ");
                addNewNode(sc.nextInt());
            }else if(ch==2){
                traverse();
            }else if(ch==3){
                reverseList();
            }else if(ch==4){
                reverseWithoutChangingList();
            }else if(ch==5){
                System.out.println("You have exited the program. Thank You!");
            }else{
                System.out.println("Invalid choice!");
            }
        }while(ch!=5);
    }
}
