package org.example.day14;

public class CircularQueueArray {

    private static java.util.Scanner sc=new java.util.Scanner(System.in);
    private static final int MAX_SIZE=5;
    private static int front=-1,rear=-1;
    private static int [] queue=new int[MAX_SIZE];

    public static void enqueue(int data){
        if((rear+1)%MAX_SIZE==front){
            System.out.println("Queue is Overflow!");
            return;
        }
        if((rear+1)>=MAX_SIZE){
            System.out.println("Inside the After Popup insert if");
            for(int i=front;i>-1;i--){
                if(rear==i){
                    queue[++rear]=data;
                    return;
                }
                if(i==0){
                    queue[i]=data;
                    rear=i;
                    return;
                }
            }
        }
        if(front==-1){
            queue[++front]=data;
            rear++;
        }else
            queue[++rear]=data;
        System.out.printf("Value inserted");

    }

    public static void dequeue(){
        if(front==-1){
            System.out.println("Queue is Underflow!");
            return;
        }
        front++;
        if(front==MAX_SIZE)
            front=0;
        if(front==rear+1){
            front=rear=-1;
        }
        System.out.println("Value Deleted!");
    }

    public static void print(int i){
        if(i==front)
            System.out.print(queue[i]+"(FRONT["+i+"]) ==> ");
        else if(i==rear)
            System.out.print(queue[i]+"(REAR["+i+"]) ==> ");
        else
            System.out.print(queue[i]+" ==> ");    }

    public static void display(){
        if(front==-1){
            System.out.println("Queue is Underflow!");
            return;
        }
        if((rear+1)%MAX_SIZE==front){
            for(int i=0;i<MAX_SIZE;i++){
                print(i);
            }
            return;
        }
        for(int i=front;i!=rear+1;i++){
            if(i==MAX_SIZE)
                i=0;
            print(i);
        }
        System.out.println();
    }

    public static void peek(){
        if(front==-1){
            System.out.println("Queue is Underflow!");
            return;
        }
        System.out.println("Peek ==> "+queue[front]);
    }

    public static boolean isEmpty(){
        return front==-1;
    }

    public static boolean isFull(){
        return (rear+1)%MAX_SIZE==front;
    }

    public static int size(){
        int count=0;
       if (isEmpty()) return count;
       for(int i=front;i<=rear;i++)
            count++;
        return count;
    }

    public static void main(String [] args){
        int ch;
        while(true){
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Peek");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. Size");
            System.out.println("8. Exit");
            System.out.print("Select a choice : ");
            ch=sc.nextInt();
            if(ch==1){
                System.out.print("Enter data to add : ");
                enqueue(sc.nextInt());
            }else if(ch==2){
                dequeue();
            }else if(ch==3){
                display();
            }else if(ch==4){
                peek();
            }else if(ch==5){
                System.out.println("Is Queue Empty => "+isEmpty());
            }else if(ch==6){
                System.out.println("Is Queue Full => "+isFull());
            }else if(ch==7) {
                System.out.println("Queue Size is  => "+size());
            }else if(ch==8){
                System.out.println("You have exited the program!");
                break;
            }else{
                System.out.println("Invalid choice");
            }
        }
    }
}
