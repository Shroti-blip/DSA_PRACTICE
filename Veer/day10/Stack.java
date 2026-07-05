package org.example.day10;

public class Stack {
    public static java.util.Scanner sc=new java.util.Scanner(System.in);
    private static final int STACK_SIZE=10;
    private static int top=0;
    private static int stack[] =new int[STACK_SIZE];

    public static void push(int data){
        if(top>=STACK_SIZE){
            System.out.println("Stack Overflow!");
            return;
        }
        stack[top++]=data;
        System.out.println("Pushed");
    }

    public static void pop(){
        if(top==0){
            System.out.println("Stack Underflow!");
            return;
        }
        top-=1;
        System.out.println("Popped");
    }

    public static void display(){
        if(top==0){
            System.out.println("Stack Underflow!");
            return;
        }
        for(int data=top-1;data>=0;data--){
            if(data==(top-1))
                System.out.println(stack[data] + "(TOP)\n^");
            else
                System.out.println(stack[data] + "\n^");
        }
    }

    public static void peek(){
        if(top==0){
            System.out.println("Stack Underflow!");
            return;
        }
        System.out.println("Peek -> "+stack[top-1]);
    }
    public static void isEmpty(){
        if(top==0)
            System.out.println("Stack is Empty");
        else
            System.out.println("Stack isn't Empty");
    }

    public static int stackSize(){
        return top;
    }

    public static void main(String [] args){
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
