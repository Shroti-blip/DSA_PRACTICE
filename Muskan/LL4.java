package LinkedList;

import java.util.Scanner;

public class LL4 {

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }

    static class LinkedList{
        Node head;
        void insertAtEnd(int n){
            Node node = new Node(n);
            Node temp=head;
            if(head==null){
                head=node;
                return;
            }
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;
        }

        void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.println("null");
        }

        void delete(){

        }

        boolean search(int val){
            Node temp = head;
            while(temp!=null){
                if(temp.data==val){
                    return true;
                }
                temp=temp.next;
            }
            return false;
        }

        int countNodes(){
            Node temp=head;
            int count =0;
            while(temp!=null){
                count +=1;
                temp=temp.next;
            }
            return count;
        }

        int occurrence(int val){
            Node temp=head;
            int count =0;
            while(temp!=null){
                if(temp.data==val){
                    count+=1;
                }
                temp=temp.next;
            }
            return count;
        }

        void updateNode(int oldValue , int newValue){
            Node temp = head;

            if(head==null){
                System.out.println("List is empty");
                return;
            }
            while(temp!=null){
                if(temp.data==oldValue){
                    temp.data=newValue;
//                    return;
                }
                temp=temp.next;
            }

        }
    }


    public static void main(String[] args) {


        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("Enter Your choice");
            System.out.println("1)Enter at the end");
            System.out.println("2)Display");
            System.out.println("3)delete");
            System.out.println("4)search");
            System.out.println("5)Count Node.");
            System.out.println("6)Count occurrences of a node");
            System.out.println("7)Update any node.");

            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter val.");
                    int n = sc.nextInt();
                    list.insertAtEnd(n);
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    list.delete();
                    break;
                case 4:
                    System.out.println("Enter val to find");
                    int val = sc.nextInt();
                    boolean result = list.search(val);
                    System.out.println("Entered value exist ? " + result);
                    break;
                case 5:
                    System.out.println("Total number of nodes");
                   int res =  list.countNodes();
                    System.out.println(res);
                    break;
                case 6:
                    System.out.println("Enter number to find its occurrences");
                    int o = sc.nextInt();
                    int occ=list.occurrence(o);
                    System.out.println("Total Occurrence is " + occ +" times1");
                    break;
                case 7:
                    System.out.println("Enter old Value: ");
                    int old = sc.nextInt();
                    System.out.println("Enter new value");
                    int newV = sc.nextInt();
                    list.updateNode(old , newV);
                default:
                    System.out.println("Wrong Choice ");
            }
        }
    }
}
