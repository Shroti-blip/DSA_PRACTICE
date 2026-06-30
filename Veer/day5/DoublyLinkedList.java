package org.example.day5;

class Node{
    int data;
    Node prev;
    Node next;
    public Node(){

    }
    public Node(int data){
        this.data=data;
    }
}

public class DoublyLinkedList {
    public static java.util.Scanner sc=new java.util.Scanner(System.in);
    private static Node head=null,end=null;

    public static void insertAtBeginning(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            end=newNode;
            newNode.prev=null;
            newNode.next=null;
        }else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            head.prev = null;
        }
        System.out.println("Node Added At The Beginning");
    }

    public static void insertAtEnd(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            end=newNode;
            newNode.prev=null;
            newNode.next=null;
        }else{
            end.next=newNode;
            newNode.prev=end;
            end=newNode;
            end.next=null;
        }
        System.out.println("Node Added At the End");
    }

    public static void traverseForward(){
        if(head==null){
            System.out.println("No nodes found!");
            return;
        }
        Node temp=head;
        System.out.print("NULL <-->");
        do{
            System.out.print(temp.data+" <--> ");
            temp=temp.next;
        }while(temp!=null);
        System.out.print(" NULL\n");
    }

    public static void traverseBackward(){
        if(head==null){
            System.out.println("No nodes found!");
            return;
        }
        Node temp=end;
        System.out.print("NULL <-->");
        do{
            System.out.print(temp.data+" <--> ");
            temp=temp.prev;
        }while(temp!=null);
        System.out.print(" NULL\n");
    }

    public static void main(String [] args){
        int ch;
        do{
            System.out.println("Doubly Linked List Operation");
            System.out.println("1. Insert node at Beginning.");
            System.out.println("2. Insert node at the end.");
            System.out.println("2. Traverse Forward.");
            System.out.println("3. Traverse Backward.");
            System.out.println("5. Exit");
            System.out.print("Select a choice : ");
            ch=sc.nextInt();
            if(ch==1){
                System.out.print("Enter Data to add : ");
                insertAtBeginning(sc.nextInt());
            }else if(ch==2){
                System.out.print("Enter Data to add : ");
                insertAtEnd(sc.nextInt());
            }else if(ch==3){
                traverseForward();
            }else if(ch==4){
                traverseBackward();
            }else if(ch==5){
                System.out.println("Exited, Thank You!");
            }else{
                System.out.println("Invalid Choice!");
            }
        }while(ch!=5);
    }

}
