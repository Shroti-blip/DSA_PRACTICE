package Day10;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Stack2 {



    static class StackUsingArray{

       private static int STACK_SIZE = 5;
       private static int top =0;//top is next free position.
       private static int stack[] =new int[STACK_SIZE];

        public static void push(int data){
            if(top==stack.length){
                System.out.println("Overflow.");
                return;
            }
            stack[top++] = data;
            System.out.println("pushed");
        }


        public static void pop(){
            if(top==0){
                System.out.println("underflow");
                return;
            }
            top--;
            System.out.println("Deleted: "+stack[top]);
        }

        public static void display(){
            if(top==0){
                System.out.println("Underflow");
                return;
            }

            for(int i = top-1; i>=0; i--){
                System.out.println(stack[i]+"->");
            }
        }

        public static int peek(){

            if(top==0){
                System.out.println("underflow");
                return -1;
            }
            return stack[top];
        }
        public static int size(){
            return top;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackUsingArray s = new StackUsingArray();
          while(true){
            System.out.println("Enter choice");
            System.out.println("1.Add");
            System.out.println("2.Display");
            System.out.println("3.pop");
              System.out.println("4.Peek");
              System.out.println("5.size");
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
                case 5:
                    int size = s.size();
                    System.out.println("Size is : "+size);
                    break;
                default:
                    System.out.println("invalid index.");

            }
        }
    }
}
