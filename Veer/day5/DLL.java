package org.example.day5;

public class DLL {

    public static class Node{
        int data;
        Node next,prev;
        public Node(int data){
            this.data=data;
        }
    }
    public static java.util.Scanner sc=new java.util.Scanner(System.in);
    private static Node head=null,end=null;
    public static void addAtBeginning(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            end=newNode;
            newNode.prev=null;
            newNode.next=null;
        }else{
            head.prev=newNode;
            newNode.next=head;
            newNode.prev=null;
            head=newNode;
        }
        System.out.println("New Node Added At The Beginning");
    }

    public static void addAtTheEnd(int data){
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
    }

    public static void traverseForward(){
        if(head==null){
            System.out.println("No Node Found!");
            return;
        }
        System.out.print("NULL <--> ");
        for(Node temp=head;temp!=null;temp=temp.next){
            System.out.print(temp.data+" <--> ");
        }
        System.out.print(" NULL\n");
    }

    public static void traverseBackward(){
        if(head==null){
            System.out.println("No Node Found!");
            return;
        }
        System.out.print("NULL <-->  ");
        for(Node temp=end;temp!=null;temp=temp.prev){
            System.out.print(temp.data+" <--> ");
        }
        System.out.print(" NULL\n");
    }

    public static void main(String args[]){
        int ch;
        do{
            System.out.println("1. Add At The Beginning.");
            System.out.println("2. Add At The End");
            System.out.println("3. Traverse Forward");
            System.out.println("4. Traverse Backward");
            System.out.println("5. Exit");
            System.out.print("Select a choice : ");
            ch=sc.nextInt();
            if(ch==1){
                System.out.print("Enter data to add : ");
                addAtBeginning(sc.nextInt());
            }else if(ch==2){
                System.out.print("Enter data to add : ");
                addAtTheEnd(sc.nextInt());
            }else if(ch==3){
                traverseForward();
            }else if(ch==4){
                traverseBackward();
            }else if(ch==5){
                System.out.println("Exited, Thank you!");
            }else{
                System.out.println("Invalid Choice!");
            }
        }while(ch!=5);
    }
}
