package Day11;

import Day10.Stack2;

import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node (int data){
        this.data=data;
    }
}

public class StackLL {

    Node top=null;
    void push(int data){
        Node node = new Node(data);
        if(top==null){
            top=node;
            return;
        }
        node.next=top;
        top=node;
    }

    void pop(){
        if(top==null){
            System.out.println("Underflow.");
            return ;
        }
        System.out.println(top.data+" , " +top);
        top=top.next;
        System.out.println(top.data+" , " +top);
        return;
    }

    int peek (){
        if(top==null){
            System.out.println("Underflow.");
            return -1;
        }
        return top.data;
    }

    void display(){
        Node temp=top;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       StackLL s = new StackLL();
        while(true){
            System.out.println("Enter choice");
            System.out.println("1.Add");
            System.out.println("2.Display");
            System.out.println("3.pop");
            System.out.println("4.Peek");
            int c = sc.nextInt();

            switch (c){
                case 1:
                    System.out.println("Enter data");
                    int d=sc.nextInt();
                    s.push(d);
                    break;
                case 2 :
                    s.display();
                    break;
                case 3:
                    s.pop();
                    break;
                case 4:
                    int res = s.peek();
                    System.out.println("peek value: "+res);
                    break;
//                case 5:
//                    int size = s.size();
//                    System.out.println("Size is : "+size);
//                    break;
                default:
                    System.out.println("invalid index.");

            }
        }
    }
}
