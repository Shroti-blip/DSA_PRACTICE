package DoublyLinkedList;

import java.util.Scanner;

public class DLL2 {

    static class Node{
        int data;
        Node prev;
        Node next;
        Node(int data){
            this.data=data;
        }
    }

    static class DLinkedList{

        Node head;
        Node tail;
        void insertAtEnd(int data){
            Node node = new Node(data);
            if(head==null){
                head=tail=node;
                tail.next=null;
                return;
            }

            node.prev=tail;
            tail.next=node;
            tail=node;
        }

        void insertAtStart(int data){
            Node node = new Node(data);
            if(head==null){
                head=tail=node;
                tail.next=null;
                return;
            }
            head.prev=node;
            node.next=head;
            head=node;
            head.prev=null;
            tail.next=null;
        }

        void insertAnywhere(int idx , int data){
            Node node = new Node(data);
            Node temp=head;
            int count =0;
            if(head==null){
                head=tail=node;
                tail.next=null;
                return;
            }
            if(temp==null){
                System.out.println("Invalid.");
                return;
            }
            if(temp==tail){
                insertAtEnd(data);
                return;
            }
            while(count<idx-1){
                temp=temp.next;
                count++;
            }
            node.next=temp.next;
            node.prev=temp;
            temp.next.prev=node;
            temp.next=node;


        }

        void insertAfterGivenValue(int val1, int val2){
            Node node = new Node(val2);
            Node temp=head;

            while(temp!=null && temp.data!=val1){
                temp=temp.next;
            }

           if(temp==null){
               System.out.println("List empty");
               return;
           }


            if(temp==tail){
                insertAtEnd(val2);
                return;
            }

                node.next=temp.next;
                node.prev=temp;
                temp.next.prev=node;
                temp.next=node;


        }

        void insertBefore(int val1, int val2){
            Node node = new Node(val2);
            Node temp=head;
            while(temp!=null && temp.data!=val1){
                temp=temp.next;
            }

            if(temp==null){
                System.out.println("List empty");
                return;
            }
            if(temp==tail){
                insertAtEnd(val2);
                return;
            }

            node.prev=temp.prev;
            node.next=temp;
            node.prev.next=node;
                temp.prev=node;

        }

        void deleteByValue(int data){
            Node temp=head;
            while(temp!=null && temp.data!=data){
                temp=temp.next;
            }
            if(temp == null){
                System.out.println("Value not found");
                return;
            }

            if(head == tail){
                head = tail = null;
                return;
            }

            if(temp == head){
                head = head.next;
                head.prev = null;
                return;
            }

            if(temp == tail){
                tail = tail.prev;
                tail.next = null;
                return;
            }

                temp.prev.next=temp.next;
                temp.next.prev=temp.prev;

        }

        //bug
        void deleteAtSpecificPosition(int idx){
            Node temp=head;
            int count=0;
            if(temp!=null && count<idx-1){
                temp=temp.next;
                count++;
            }
            temp.prev.next=temp.next;
            temp.next.prev=temp.prev;
        }

        //incomplete
        void deleteAfterValue(int val){

        }
        void displayForward(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+"<->");
                temp=temp.next;
            }
            System.out.println("null");
        }

        void displayBackward(){
            Node temp=tail;
            while(temp!=null){
                System.out.print(temp.data+"<->");
                temp=temp.prev;
            }
            System.out.println("null");
        }


    }

    public static void main(String[] args) {

        DLinkedList list = new DLinkedList();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("======= DOUBLY LINKED LIST ==========");
            System.out.println("1. Insert At End");
            System.out.println("2. Insert At Start");
            System.out.println("3. Insert At Index");
            System.out.println("4. Insert After Given Value");
            System.out.println("5. Insert Before Given Value");
            System.out.println("6. Delete By Value");
            System.out.println("7. Delete At Specific Position");
            System.out.println("8. Delete After Given Value");
            System.out.println("9. Display Forward");
            System.out.println("10. Display Backward");
            System.out.println("11. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    list.insertAtEnd(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    list.insertAtStart(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter index: ");
                    int idx = sc.nextInt();
                    System.out.print("Enter value: ");
                    int data = sc.nextInt();
                    list.insertAnywhere(idx, data);
                    break;

                case 4:
                    System.out.print("Insert after value: ");
                    int val1 = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int val2 = sc.nextInt();
                    list.insertAfterGivenValue(val1, val2);
                    break;

                case 5:
                    System.out.print("Insert before value: ");
                    int before = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int newValue = sc.nextInt();
                    list.insertBefore(before, newValue);
                    break;

                case 6:
                    System.out.print("Enter value to delete: ");
                    list.deleteByValue(sc.nextInt());
                    break;

                case 7:
                    System.out.print("Enter index to delete: ");
                    list.deleteAtSpecificPosition(sc.nextInt());
                    break;

                case 8:
                    System.out.print("Delete node after value: ");
                    list.deleteAfterValue(sc.nextInt());
                    break;

                case 9:
                    list.displayForward();
                    break;

                case 10:
                    list.displayBackward();
                    break;

                case 11:
                    System.out.println("Program Khatam.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
