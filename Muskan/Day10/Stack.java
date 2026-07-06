package Day10;

import java.util.Scanner;

public class Stack {


    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }

    static class StackOperation{
        Node top;
        void push(int data){
            Node node = new Node(data);
            if(top==null){
                top=node;
                return;
            }
                node.next=top;
                top=node;

        }

        void display(){
            Node temp=top;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.println("null");
        }

        void pop(){
            //top pop
            if(top==null){
                System.out.println("stack is empty");
                return;
            }
            top=top.next;
        }

        int countNodes(){
            Node temp=top;
            int count =0;
            if(top==null){
                System.out.println("Empty, 0 nodes");
                return 0;
            }
            while(temp!=null){
                count+=1;
                temp=temp.next;
            }
            return count;
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackOperation stackOperation  = new StackOperation();
        while(true){
            System.out.println("Enter choice");
            System.out.println("1.Add");
            System.out.println("2.Display");
            System.out.println("3.pop");
            System.out.println("4.Count nodes");
            int c = sc.nextInt();

            switch (c){
                case 1:
                    System.out.println("Enter data");
                    int d=sc.nextInt();
                    stackOperation.push(d);
                    break;
                case 2 :
                    stackOperation.display();
                    break;
                case 3:
                    stackOperation.pop();
                    break;
                case 4:
                    int res = stackOperation.countNodes();
                    System.out.println("Total nodes: "+res);
                    break;
                default:
                    System.out.println("invalid index.");

            }
        }
    }
}
