package org.example;
class Node{
    int data;
    Node next;
    public Node(){
        this.next=null;
    }
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class SinglyLinkedList {
    static java.util.Scanner sc=new java.util.Scanner(System.in);
    static Node head=null;
    public static void addNode(){
        int data;
        System.out.print("Enter data : ");
        data=sc.nextInt();
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }else{
            Node temp=head,last=null;
            while(temp!=null){
                last=temp;
                temp=temp.next;
            }
            last.next=newNode;
        }
        System.out.println("Node Added!");
    }

    public static void traverse(){
        if(head==null){
            System.out.println("No Nodes Found!");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" --> ");
            temp=temp.next;
        }
        System.out.print(" NULL\n");
    }

    public static void deleteNode(){
        if(head==null){
            System.out.println("No Nodes Found!");
            return;
        }
        System.out.print("Enter node to delete : ");
        int val=sc.nextInt();
        Node temp=head,prev=null;
        while(temp!=null){
            if(temp.data==val){
                if(temp==head){
                    head=head.next;
                }else if(temp.next==null){
                    prev.next=null;
                }else{
                    prev.next=temp.next;
                }
                System.out.println("Node Deleted!");
            }
            prev=temp;
            temp=temp.next;
        }
    }

    public static void main(String [] args){
        System.out.println("Jay Shree My Bestie");
        int ch=1;
        do{
            System.out.println("-------Linked List Option----------");
            System.out.println("1. Add a Node");
            System.out.println("2. Traverse");
            System.out.println("3. Delete");
            System.out.println("4. Exit");
            System.out.print("Select a choice : ");
            ch=sc.nextInt();
            if(ch==1){
                addNode();
            }else if(ch==2){
                traverse();
            }else if(ch==3){
                 deleteNode();
            }else if(ch==4){
                System.out.println("Exited! Thank You.");
            }else{
                System.out.println("Invalid choice!");
            }
        }while(ch!=4);
    }
}
