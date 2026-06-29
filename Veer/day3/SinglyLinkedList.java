package org.example.day3;

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class SinglyLinkedList {
    public static java.util.Scanner sc=new java.util.Scanner(System.in);
    static Node head = null;
    public static void addNewNode(int data){
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
    public static void traverse(){
        if(head==null){
            System.out.println("Not Nodes Found!");
            return;
        }
        for(Node temp=head;temp!=null;temp=temp.next){
            System.out.print(temp.data + " -->");
        }
        System.out.print(" NULL\n");
    }
    public static void deleteNode(int data){
        if(head==null){
            System.out.println("Not Nodes Found!");
            return;
        }
        Node prev=null;
        for(Node temp=head;temp!=null;temp=temp.next){
            if(temp.data==data){
                if(temp==head){
                    head=head.next;
                }else if(temp.next==null){
                    prev.next=null;
                }else{
                    prev.next=temp.next;
                }
            }
            prev=temp;
        }

    }
    public static void deleteAfterNode(int data){
        if(head==null){
            System.out.println("Not Nodes Found!");
            return;
        }
        Node temp=head;
        while(temp!=null){
            if(temp.data==data){
                if(temp==head){
                    if(head.next==null){
                        head=null;
                    }else
                        head.next=head.next.next;
                }else if(temp.next==null){
                    System.out.println("No node exists after the given value!");
                }else{
                    temp.next=temp.next.next;
                }
            }
            temp=temp.next;
        }
    }

    public static void main(String [] args){
        int ch=1,val;
        do{
            System.out.println("Linked List Operation");
            System.out.println("1. Add new Node");
            System.out.println("2. Traverse");
            System.out.println("3. Delete Node");
            System.out.println("4. Delete After Node");
            System.out.println("5. Exit");
            System.out.print("Select a choice : ");
            ch=sc.nextInt();
            if(ch==1){
                System.out.print("Enter data to add : ");
                val=sc.nextInt();
                addNewNode(val);
            }else if(ch==2){
                traverse();
            }else if(ch==3){
                System.out.print("Enter data to delete : ");
                val=sc.nextInt();
                deleteNode(val);
            }else if(ch==4){
                System.out.print("Enter data to delete : ");
                val=sc.nextInt();
                deleteAfterNode(val);
            }else if(ch==5){
                System.out.println("Exited!, Thank You!");
            }else{
                System.out.println("Invalid choice");
            }
        }while(ch!=5);
    }
}
