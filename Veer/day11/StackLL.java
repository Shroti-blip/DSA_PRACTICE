package org.example.day11;
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
    }
}

public class StackLL {
    public static java.util.Scanner sc=new java.util.Scanner(System.in);
    private static Node top=null;

    public static void push(int data){
        Node newNode=new Node(data);
        if(top==null){
            top=newNode;
            newNode.next=null;
        }else{
            newNode.next=top;
            top=newNode;
        }
        System.out.println("Pushed");
    }

    public static void pop(){
        if(top==null){
            System.out.println("Stack is Underflow!");
            return;
        }
        top=top.next;
        System.out.println("Popped");
    }

    public static void display(){
        if(top==null){
            System.out.println("Stack Underflow!");
            return;
        }
        Node temp=top;
        while(temp!=null){
            if(temp==top)
                System.out.println(temp.data+"(TOP)" +"\n^");
            else
                System.out.println(temp.data +"\n^");
            temp=temp.next;
        }
    }

    public static void peek(){
        if(top==null){
            System.out.println("Stack Underflow!");
            return;
        }
        System.out.println("TOP -> "+top.data);
    }

    public static void isEmpty(){
        if(top==null){
            System.out.println("Stack is Empty!");
            return;
        }
        System.out.println("Stack isn't Empty!");
    }

    public static int stackSize(){
        int size = 0;
        Node temp=top;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        return size;
    }

    public static void main(String args[]){
        int ch;
        do{
            System.out.println("===================================");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Peek");
            System.out.println("5. Is Empty");
            System.out.println("6. Size of Stack");
            System.out.println("7. Exit the program");
            System.out.print("Select a choice : ");
            ch=sc.nextInt();
            switch(ch){
                case 1:
                    System.out.print("Enter data to add : ");
                    push(sc.nextInt());
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    peek();
                    break;
                case 5:
                    isEmpty();
                    break;
                case 6:
                    System.out.println("Stack Size is "+stackSize());
                    break;
                case 7:
                    System.out.println("You have existed successfully!, Thank You!");
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }while(ch!=7);
    }
}
