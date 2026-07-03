package CircularDoublyLL;

import java.util.Scanner;

public class CDLL1 {

    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
        }
    }

    static class DoublyCLL{
        Node head;
        Node tail;
        void insertAtEnd(int data){
            Node node = new Node(data);
            Node temp=head;
            if(head==null){
                head=tail=node;
                head.next=tail;
                head.prev=head;
                return;
            }

            node.prev=tail;
            node.next=head;
            tail.next=node;
            head.prev=node;
            tail=node;
        }

        void display(){
            Node temp=head;
            if(temp==null){
                System.out.println("List is empty");
                return;
            }
            do{
                System.out.print(temp.data+"<->");
                temp=temp.next;
            }while(temp!=head);
            System.out.println("head");
        }

        void insertAtStart(int data){
            Node node=new Node(data);
            Node temp=head;

            if(temp==null){
                head=tail=node  ;
                head.next=head;
                head.prev=head;
                return;
            }
            node.prev=tail;
            head.prev=node;
            node.next=head;
            tail.next=node;
            head=node;//must update value.

        }

        void insertAtSpecificPosition(int idx , int data){
            Node node=new Node(data);
            Node temp=head;
            int count=0;
            int totalNodes=0;
            if(temp==null){
                System.out.println("List is empty");
                return;
            }

            while(count<idx-1 ){
                count++;
                temp=temp.next;
                totalNodes +=1;
            }
              if(idx<0 && idx>totalNodes){
                System.out.println("Invalid idx");
                return;
            }
            if(idx==0){
                insertAtStart(data);
                return;
            }

         node.next=temp.next;
          node.prev=temp;
          temp.next.prev=node;
            temp.next=node;

        }

        void deleteByValue(int data){
            Node temp=head;

            if(temp==null){
                System.out.println("List is empty");
                return;
            }
            //for head
            while(temp.next!=tail){
                if(temp.data==data){
                    if(temp==head){
                        head=head.next;
                        head.prev=tail;
                        tail.next=head;
                        return;
                    }

                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                }
                temp=temp.next;
            }
        }
    }
    public static void main(String[] args) {
        DoublyCLL cll=new DoublyCLL();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter your choice");
            System.out.println("1)Add node at end");
            System.out.println("2)display");
            System.out.println("3)Add at start");
            System.out.println("4)At specific position");
            System.out.println("5)Delete by value");
            System.out.println("6)Exit");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter data: ");
                    cll.insertAtEnd(sc.nextInt());
                    break;
                case 2:
                    cll.display();
                    break;
                case 3:
                    System.out.println("Enter data: ");
                    cll.insertAtStart(sc.nextInt());
                    break;
                case 4:
                    System.out.println("Enter idx: ");
                    int idx = sc.nextInt();
                    System.out.println("Enter data");
                    int data = sc.nextInt();
                    cll.insertAtSpecificPosition(idx, data);
                    break;
                case 5:
                    System.out.println("Enter value");
                    cll.deleteByValue(sc.nextInt());
                    break;
                case 6:
                    System.out.println("Successfully exited");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
