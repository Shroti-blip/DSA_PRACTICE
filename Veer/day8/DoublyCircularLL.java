package org.example.day8;

class Node{
    int data;
    Node next,prev;
    public Node(int data){
        this.data=data;
    }
}

public class DoublyCircularLL {
    public static java.util.Scanner sc=new java.util.Scanner(System.in);
    private static Node head=null,end=null;

    public static boolean isListEmpty(){
        if(head==null){
            System.out.println("Node nodes found!");
            return true;
        }
        return false;

    }

    public static void addNewNode(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            end=newNode;
            newNode.prev=end;
            newNode.next=head;
        }else{
            newNode.prev=end;
            end.next=newNode;
            newNode.next=head;
            end=newNode;
            head.prev=end;
        }
        System.out.println("New Node Added!");
    }
    public static void addAtBeginning(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            end=newNode;
            newNode.prev=end;
            newNode.next=head;
        }else{
            newNode.next=head;
            head.prev=newNode;
            newNode.prev=end;
            head=newNode;
            end.next=head;
        }
        System.out.println("New Node Added At Beginning!");
    }
    public static void forwardTraverse(){
        if(isListEmpty())
            return;
        Node temp=head;

        System.out.print("Connect to End("+end.data+") <--> ");
        do{
            System.out.print(temp.data+" <--> ");
            temp=temp.next;
        }while(temp!=head);
        System.out.print("Connect to Head("+head.data+")\n");
    }
    public static void backwardTraverse(){
        if(isListEmpty())
            return;
        Node temp=end;

        System.out.print("Connect to Head("+head.data+") <--> ");
        do{
            System.out.print(temp.data+" <--> ");
            temp=temp.prev;
        }while(temp!=end);
        System.out.print("Connect to End("+end.data+")\n");
    }
    public static void insertAtPosition(int target,int data){
        if(isListEmpty())
            return;
        Node newNode=new Node(data);
        Node temp=head;
        do{
            target--;
            if(0==target){
                if(temp==head){
                    newNode.next=head;
                    head.prev=newNode;
                    newNode.prev=end;
                    head=newNode;
                    end.next=head;
                }else {
                    temp.prev.next = newNode;
                    newNode.prev = temp.prev;
                    newNode.next = temp;
                    temp.prev = newNode;
                }
                System.out.println("Node inserted!");
                return;
            }
            temp=temp.next;
        }while(temp!=head);
        System.out.println("Position doesn't exist in the list");
    }
    public static void insertAfterValue(int value,int data){
        if(isListEmpty())
            return;
        Node newNode=new Node(data);
        Node temp=head;
        do{
            if(temp.data==value){
                if(temp==end){
                    newNode.prev=end;
                    end.next=newNode;
                    newNode.next=head;
                    end=newNode;
                    head.prev=end;
                }else {
                    newNode.next=temp.next;
                    temp.next.prev=newNode;
                    temp.next=newNode;
                    newNode.prev=temp;
                }
                System.out.println("After value new node inserted!");
                return;
            }
            temp=temp.next;
        }while(temp!=head);
        System.out.println("Value doesn't exist in the list");
    }
    public static void insertBeforeValue(int value,int data){
        if(isListEmpty())
            return;
        Node newNode=new Node(data);
        Node temp=head;
        do{
            if(temp.data==value){
                if(temp==head){
                    newNode.next=head;
                    head.prev=newNode;
                    newNode.prev=end;
                    head=newNode;
                    end.next=head;
                }else {
                    newNode.prev=temp.prev.next;
                    temp.prev.next=newNode;
                    newNode.next=temp;
                    temp.prev=newNode;
                }
                System.out.println("After value new node inserted!");
                return;
            }
            temp=temp.next;
        }while(temp!=head);
        System.out.println("Value doesn't exist in the list");
    }
    public static void deleteByValue(int val){
        if(isListEmpty())
            return;
        Node temp=head;
        do{
            if(temp.data==val){
                if(temp==head){
                    if(temp.next==head){
                        head=null;
                        end=null;
                    }else{
                        head=head.next;
                        head.prev=end;
                        end.next=head;
                    }
                }else if(temp.next==head) {
                    end=end.prev;
                    end.next=head;
                    head.prev=end;
                }else {
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                }
                System.out.println("Value Deleted!");
                return;
            }
            temp=temp.next;
        }while(temp!=head);
        System.out.println("Value doesn't exist in the list to delete!");
    }
    public static void deleteByPosition(int position){
        if(isListEmpty())
            return;
        Node temp=head;
        do{
            position--;
            if(0==position){
                if(temp==head){
                    if(temp.next==head){
                        head=null;
                        end=null;
                    }else{
                        head=head.next;
                        head.prev=end;
                        end.next=head;
                    }
                }else if(temp.next==head) {
                    end=end.prev;
                    end.next=head;
                    head.prev=end;
                }else {
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                }
                System.out.println("Position node deleted!");
                return;
            }
            temp=temp.next;
        }while(temp!=head);
        System.out.println("Position doesn't exist in the list");
    }
    public static void searchValue(int val){
        if(isListEmpty())
            return;
        Node temp=head;
        do{
            if(temp.data==val){
                System.out.println("Value exists in the list!");
                return;
            }
            temp=temp.next;
        }while(temp!=head);
        System.out.println("Value doesn't exist in the list");
    }

    public static void main(String [] args){
        int ch,target;
        do{
            System.out.println("==== Operation ====");
            System.out.println("1. Add new node");
            System.out.println("2. Insert at beginning");
            System.out.println("3. Forward traverse");
            System.out.println("4. Backward traverse");
            System.out.println("5. Insert at position");
            System.out.println("6. Insert after value");
            System.out.println("7. Insert before value");
            System.out.println("8. Delete by value");
            System.out.println("9. Delete at position");
            System.out.println("10. Search value");
            System.out.println("11. Exit the program");
            System.out.print("Select a choice : ");
            ch=sc.nextInt();
            if(ch==1){
                System.out.print("Enter data to add : ");
                addNewNode(sc.nextInt());
            }else if(ch==2){
                System.out.print("Enter data to add at beginning : ");
                addAtBeginning(sc.nextInt());
            }else if(ch==3){
                forwardTraverse();
            }else if(ch==4){
                backwardTraverse();
            }else if(ch==5){
                System.out.print("Enter position where do you want to insert : ");
                target=sc.nextInt();
                System.out.print("Enter data to add : ");
                insertAtPosition(target,sc.nextInt());
            }else if(ch==6){
                System.out.print("Enter value after where do you want to insert : ");
                target=sc.nextInt();
                System.out.print("Enter data to add : ");
                insertAfterValue(target,sc.nextInt());
            }else if(ch==7){
                System.out.print("Enter value before where do you want to insert : ");
                target=sc.nextInt();
                System.out.print("Enter data to add : ");
                insertBeforeValue(target,sc.nextInt());
            }else if(ch==8){
                System.out.print("Enter value to delete : ");
                deleteByValue(sc.nextInt());
            }else if(ch==9){
                System.out.print("Enter position to delete : ");
                deleteByPosition(sc.nextInt());
            }else if(ch==10){
                System.out.print("Enter value to search : ");
                searchValue(sc.nextInt());
            }else if(ch==11){
                System.out.println("You have successfully exited!, Thank you!");
            }else{
                System.out.println("Invalid choice ");
            }

        }while(ch!=11);
    }
}
