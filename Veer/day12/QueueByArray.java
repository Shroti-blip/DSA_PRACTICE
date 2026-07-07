package org.example.day12;

public class QueueByArray {

    private static java.util.Scanner sc=new java.util.Scanner(System.in);
    private final static int MAX_SIZE=10;
    private static int front=-1,rear=-1;
    private static int queue []=new int[MAX_SIZE];

    public static void enqueue(int data){
        if(rear>=MAX_SIZE-1){
            System.out.println("Queue Overflow!");
            return;
        }
        if(front==-1 || rear==-1){
            queue[++front]=data;
            rear++;
        }else{
            queue[++rear]=data;
        }
        System.out.println("Data Added!");
    }

    public static void dequeue(){
        if(rear==-1){
            System.out.println("Queue Underflow!");
            return;
        }
        for(int i=0;i<=rear;i++){
                queue[i]=queue[i+1];
        }
        rear--;
        if(rear==-1)
            front--;

    }

    public static void display(){
        if(rear==-1){
            System.out.println("Queue Underflow!");
            return;
        }
        for(int i=front;i<=rear;i++){
            if(i==front)
                System.out.print(queue[i]+"(Front) ==> ");
            else if(i==rear)
                System.out.print(queue[i]+"(Rear) ==> ");
            else
                System.out.print(queue[i]+" ==> ");
        }
        System.out.println();
    }

    public static void peek(){
        if(rear==-1){
            System.out.println("Queue Underflow!");
            return;
        }
        System.out.println("Peek ==> "+queue[front]);
    }

    public static boolean isEmpty(){
        if(front==-1)
            return true;
        else
            return false;
    }

    public static boolean isFull(){
        if(rear>=MAX_SIZE)
            return true;
        else
            return false;
    }

    public static int size(){
        return rear+1;
    }

    public static void search(int data){
        if(rear==-1){
            System.out.println("Queue Underflow!");
            return;
        }
        for(int i=front;i<=rear;i++){
            if(queue[i]==data){
                System.out.println("Value exists!");
                return;
            }
        }
        System.out.println("Value doesn't exists!");
    }

    public static void clear(){
        front=rear=-1;
        System.out.println("Queue has been cleared");
    }

    public static void main(String [] args){
        int ch;
        do{
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Peek");
            System.out.println("5. Is Empty");
            System.out.println("6. Is Full");
            System.out.println("7. Size");
            System.out.println("8. Search");
            System.out.println("9. Clear");
            System.out.println("10. Exit");
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
                if(isEmpty())
                    System.out.println("Queue is empty");
                else
                    System.out.println("Queue isn't empty");
            }else if(ch==6){
                if(isFull()){
                    System.out.println("Queue is Full");
                }else{
                    System.out.println("Queue is not Full");
                }
            }else if(ch==7){
                System.out.println("Queue size is "+size());
            }else if(ch==8){
                System.out.print("Enter data to search : ");
                search(sc.nextInt());
            }else if(ch==9){
                clear();
            }else if(ch==10){
                System.out.println("You have exited the program!, Thank You.");
            }else{
                System.out.println("Invalid Choice!");
            }
        }while(ch!=10);
    }
}
