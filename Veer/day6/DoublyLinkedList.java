package org.example.day6;


class Node{
    int data;
    Node next,prev;
    public Node(int data){
        this.data=data;
    }
}

public class DoublyLinkedList {
    public static java.util.Scanner sc=new java.util.Scanner(System.in);
    private static Node head=null,end=null;

    public static void addNewNode(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            end=newNode;
            newNode.prev=null;
            newNode.next=null;
        }else{
            newNode.prev=end;
            end.next=newNode;
            end=newNode;
            end.next=null;
        }
        System.out.println("New Node Added");
    }

    public static void forwardTraverse(){
        if(head==null){
            System.out.println("No Nodes Founds!");
            return;
        }
        System.out.print(" NULL <--> ");
        for(Node temp=head;temp!=null;temp=temp.next){
            System.out.print(temp.data+" <--> ");
        }
        System.out.print(" NULL\n");
    }
    public static void backwardTraverse(){
        if(head==null){
            System.out.println("No Nodes Founds!");
            return;
        }
        System.out.print(" NULL <--> ");
        for(Node temp=end;temp!=null;temp=temp.prev){
            System.out.print(temp.data+" <--> ");
        }
        System.out.print(" NULL\n");
    }

    public static void addSpecificPosition(int target,int data){
        if(head==null){
            System.out.println("No Nodes Founds, For specific position insertion");
            return;
        }
        Node newNode=new Node(data);
        for(Node temp=head;temp!=null;temp=temp.next){
            target--;
            if(target==0){
                temp.prev.next=newNode;
                newNode.prev=temp.prev;
                newNode.next=temp;
                temp.prev=newNode;
                return;
            }
        }
        System.out.println("Invalid Position!");

    }

    public static void addAfterGivenValue(int valueGiven,int data){
        if(head==null){
            System.out.println("No Nodes Founds, For after value insertion");
            return;
        }
        Node newNode=new Node(data);
        for(Node temp=head;temp!=null;temp=temp.next){
            if(temp.data==valueGiven){
                temp.next.prev=newNode;
                newNode.next=temp.next;
                newNode.prev=temp;
                temp.next=newNode;
                return;
            }
        }
        System.out.println("Given value not found!");

    }

    public static void addBeforeGivenValue(int valueGiven,int data){
        if(head==null){
            System.out.println("No Nodes Founds, For before value insertion");
            return;
        }
        Node newNode=new Node(data);
        for(Node temp=head;temp!=null;temp=temp.next){
            if(temp.data==valueGiven){
                temp.prev.next=newNode;
                newNode.prev=temp.prev;
                newNode.next=temp;
                temp.prev=newNode;
                return;
            }
        }
        System.out.println("Given value not found!");

    }
    public static void deleteByValue(int val){
        if(head==null){
            System.out.println("No Nodes Founds, For before value insertion");
            return;
        }
        for(Node temp=head;temp!=null;temp=temp.next){
            if(temp.data==val){
                if(temp==head){
                    if(head.next==null){
                        head=null;
                        end=null;
                    }else{
                        head=head.next;
                        head.prev=null;
                    }
                }else if(temp==end){
                    end=end.prev;
                    end.next=null;
                }else{
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                }
                System.out.println("Node Deleted!");
                return;
            }
        }
        System.out.println("Value doesn't exist to delete!");
    }
    public static void deleteByPosition(int position){
        if(head==null){
            System.out.println("No Nodes Founds, For specific position insertion");
            return;
        }
        for(Node temp=head;temp!=null;temp=temp.next){
            position--;
            if(position==0){
                if(temp==head){
                    if(head.next==null){
                        head=null;
                        end=null;
                    }else{
                        head=head.next;
                        head.prev=null;
                    }
                }else if(temp==end){
                    end=end.prev;
                    end.next=null;
                }else{
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                }
                System.out.println("Node Deleted!");
                return;
            }
        }
        System.out.println("Invalid Position to delete!");

    }
    public static void deleteAfterGivenValue(int val){
        if(head==null){
            System.out.println("No Nodes Founds, For before value insertion");
            return;
        }
        for(Node temp=head;temp!=null;temp=temp.next){
            if(temp.data==val && temp.next!=null){
                temp=temp.next;
                if(temp==head){
                    if(head.next==null){
                        head=null;
                        end=null;
                    }else{
                        head=head.next;
                        head.prev=null;
                    }
                }else if(temp==end){
                    end=end.prev;
                    end.next=null;
                }else{
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                }
                System.out.println("Node Deleted!");
                return;
            }
        }
        System.out.println("Value doesn't exist to delete!");
    }

    public static void main(String [] args){
        int ch,val,target;
        do{
            System.out.println("1. Add New Node");
            System.out.println("2. Forward Traverse");
            System.out.println("3. Backward Traverse");
            System.out.println("4. Insert At Position");
            System.out.println("5. Insert After Given value");
            System.out.println("6. Insert before given value");
            System.out.println("7. Delete by value");
            System.out.println("8. Delete specific position");
            System.out.println("9. Delete after given value");
            System.out.println("10. Exit");
            System.out.print("Select a choice : ");
            ch=sc.nextInt();
            switch (ch){
                case 1:
                    System.out.print("Enter data to add : ");
                    addNewNode(sc.nextInt());
                    break;
                case 2:
                    forwardTraverse();
                    break;
                case 3:
                    backwardTraverse();
                    break;
                case 4:
                    System.out.print("Enter position where you want to add : ");
                    target=sc.nextInt();
                    System.out.print("Enter Data : ");
                    val=sc.nextInt();
                    addSpecificPosition(target,val);
                    break;
                case 5:
                    System.out.print("Enter target after where do you want to insert : ");
                    target=sc.nextInt();
                    System.out.print("Enter Data : ");
                    val=sc.nextInt();
                    addAfterGivenValue(target,val);
                    break;
                case 6:
                    System.out.print("Enter target before where do you want to insert : ");
                    target=sc.nextInt();
                    System.out.print("Enter Data : ");
                    val=sc.nextInt();
                    addBeforeGivenValue(target,val);
                    break;
                case 7:
                    System.out.print("Enter value to delete : ");
                    val=sc.nextInt();
                    deleteByValue(val);
                    break;
                case 8:
                    System.out.print("Enter position to delete : ");
                    val=sc.nextInt();
                    deleteByPosition(val);
                    break;
                case 9:
                    System.out.print("Enter value after you want to delete node : ");
                    val=sc.nextInt();
                    deleteAfterGivenValue(val);
                    break;
                case 10:
                    System.out.println("You have exited the program, Thank you!");
                    break;
                default:
                    System.out.println("Invalid Choice, Try again!");
                    break;
            }
        }while(ch!=10);
    }
}
