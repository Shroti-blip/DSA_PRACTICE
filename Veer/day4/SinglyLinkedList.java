package org.example.day4;

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
    private static Node head = null;

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
            System.out.println("No Node Founds!");
            return;
        }
        for(Node temp=head;temp!=null;temp=temp.next){
            System.out.print(temp.data+" -->");
        }
        System.out.print(" NULL\n");
    }

    public static void searchNodeByValue(int val){
        if(head==null){
            System.out.println("No Node Founds!");
            return;
        }
        for(Node temp=head;temp!=null;temp=temp.next){
            if(temp.data==val){
                System.out.println(val+" exist!");
                return;
            }
        }
        System.out.println(val+" doesn't exist!");
    }

    public static void countTotalNodes(){
        if(head==null){
            System.out.println("No Node Founds!");
            return;
        }
        int count=0;
        for(Node temp=head;temp!=null;temp=temp.next){
            count++;
        }
        System.out.println("Number of Node is "+count);
    }

    public static void countNodeOccurrences(int val){
        if(head==null){
            System.out.println("No Node Founds!");
            return;
        }
        int nodeCount=0;
        for(Node temp=head;temp!=null;temp=temp.next){
            if(temp.data==val)
                nodeCount++;
        }
        System.out.println("Occurrence of Node("+val+") is "+nodeCount);
    }

    public static void updateNodeByValue(int oldValue,int newValue){
        if(head==null){
            System.out.println("No Node Founds!");
            return;
        }
        for(Node temp=head;temp!=null;temp=temp.next){
            if(temp.data==oldValue){
                temp.data=newValue;
                System.out.println("Value Updated!");
                return;
            }
        }

    }


    public static void main(String [] args){
        int ch;
        do{
            System.out.println("Linked List Operation");
            System.out.println("1. Add a new node");
            System.out.println("2. Traverse");
            System.out.println("3. Search Node");
            System.out.println("4. Count Nodes");
            System.out.println("5. Count Node Occurrences");
            System.out.println("6. Update node by value");
            System.out.println("7. Exit");
            System.out.print("Select you choice : ");
            ch=sc.nextInt();
            if(ch==1){
                System.out.print("Enter data to add : ");
                int val=sc.nextInt();
                addNewNode(val);
            }else if(ch==2){
                traverse();
            }else if(ch==3){
                System.out.print("Enter value to search : ");
                int val=sc.nextInt();
                searchNodeByValue(val);
            }else if(ch==4){
                countTotalNodes();
            }else if(ch==5){
                System.out.print("Enter value to find occurrence : ");
                int val=sc.nextInt();
                countNodeOccurrences(val);
            }else if(ch==6){
                System.out.print("Enter Old Value : ");
                int oldValue=sc.nextInt();
                System.out.print("Enter New Value : ");
                int newValue=sc.nextInt();
                updateNodeByValue(oldValue,newValue);
            }else if(ch==7){
                System.out.println("Exited!, Thank You!");
            }else{
                System.out.println("Invalid choice!");
            }
        }while(ch!=7);
    }
}
