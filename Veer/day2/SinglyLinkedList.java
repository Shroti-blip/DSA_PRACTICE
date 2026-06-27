package org.example.day2;
class Node{
    int data;
    Node next;
    public Node(int data){
        this.next=null;
        this.data=data;
    }
}

public class SinglyLinkedList {
    static java.util.Scanner sc=new java.util.Scanner(System.in);
    static Node head= null;
    public static void addNode(){
        System.out.print("Enter Data to add : ");
        int data=sc.nextInt();
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
        System.out.println("New Node Added");
    }

    public static void addNodeAtSpecificPosition(){
        System.out.print("Enter Data to add : ");
        int data=sc.nextInt();
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }else{
            System.out.println("Where Do you want to insert new Node At ? : ");
            System.out.println("1. At Head");
            System.out.println("2. At Specific Node");
            System.out.println("3. At the end");
            System.out.print("Select a Choice : ");
            int ch=sc.nextInt();
            Node temp=head,last=null;
            if(ch==1){
                newNode.next=head;
                head=newNode;
            }else if(ch==2){
                System.out.print("Enter the node after you want to insert : ");
                int val=sc.nextInt();
                while(temp!=null){
                    if(temp.data==val){
                        newNode.next=temp.next;
                        temp.next=newNode;
                    }
                    temp=temp.next;
                }
            }else if(ch==3){
                while(temp!=null){
                    last=temp;
                    temp=temp.next;
                }
                last.next=newNode;
            }
        }
    }

    public static void traverse(){
        if(head==null){
            System.out.println("record not found!");
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
            System.out.println("2. Add Node At Specific Position");
            System.out.println("3. Traverse");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Select a choice : ");
            ch=sc.nextInt();
            if(ch==1){
                addNode();
            }else if(ch==2){
                addNodeAtSpecificPosition();
            }else if(ch==3){
                traverse();
            }else if(ch==4){
                deleteNode();
            }else if(ch==5){
                System.out.println("Exited! Thank You.");
            }else{
                System.out.println("Invalid choice!");
            }
        }while(ch!=5);
    }
}
