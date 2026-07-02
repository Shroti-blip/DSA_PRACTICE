package org.example.day7;

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
    }
}

public class SinglyCircularLL {
    public static java.util.Scanner sc=new java.util.Scanner(System.in);
    private static Node head=null;

    public static void addNewNode(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }else{
            Node last=head;
            while(last.next!=head){
                last=last.next;
            }
            last.next=newNode;
        }
        newNode.next=head;
        System.out.println("New Node Added");
    }

    public static void addAtBeginning(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            newNode.next=head;
        }else{
            Node last=head;
            while(last.next!=head){
                last=last.next;
            }
            newNode.next=head;
            head=newNode;
            last.next=head;
        }
        System.out.println("Node Added At Beginning");
    }
    public static void display(){
        if(head==null){
            System.out.println("No node found");
            return;
        }
        Node temp=head;
        do{
            System.out.print(temp.data+ " --> ");
            temp=temp.next;
        }while(temp!=head);
        System.out.print(" (Head)"+head.data);
    }
    public static void deleteNode(int data){
        if(head==null){
            System.out.println("No node found");
            return;
        }
        Node temp=head,prev=null;
        do{
            if(temp.data==data){
                if(temp==head){
                    if(temp.next==head){
                        head=null;
                    }else{
                        Node last=head;
                        while(last.next!=head){
                            last=last.next;
                        }
                        head=head.next;
                        last.next=head;
                    }
                }else if(temp.next==head){
                    prev.next=head;
                }else{
                    prev.next=temp.next;
                }
                System.out.println("Node Deleted!");
                return;
            }
            prev=temp;
            temp=temp.next;
        }while(temp!=head);
        System.out.println("Value doesn't exist to delete.");
    }
    public static void searchValue(int data){
        if(head==null){
            System.out.println("No node found");
            return;
        }
        Node temp=head;
        do{
            if(temp.data==data){
                System.out.println(data+" exist in LL!");
                return;
            }
            temp=temp.next;
        }while(temp!=head);
        System.out.println(data+ " doesn't exist LL.");
    }
    public static void main(String [] args){
        int ch;
        do{
            System.out.println("1. Add new node");
            System.out.println("2. Insert at Beginning");
            System.out.println("3. Display");
            System.out.println("4. Delete By Value");
            System.out.println("5. Search a value");
            System.out.println("6. Exit");
            System.out.print("Select a choice : ");
            ch=sc.nextInt();
            if(ch==1){
                System.out.print("Enter data to add : ");
                addNewNode(sc.nextInt());
            }else if(ch==2){
                System.out.print("Enter data to add : ");
                addAtBeginning(sc.nextInt());
            }else if(ch==3){
                display();
            }else if(ch==4){
                System.out.print("Enter value to delete : ");
                deleteNode(sc.nextInt());
            }else if(ch==5){
                System.out.print("Enter value to search : ");
                searchValue(sc.nextInt());
            }else if(ch==6){
                System.out.println("Exited!, Thank you!");
            }else{
                System.out.println("Invalid choice!");
            }
        }while(ch!=6);
    }
}
