package Day14;

import java.util.Scanner;

public class CircularQueueArray {

     int QUEUE_SIZE=5;
     int front = -1;
     int rear=-1;//next free position
    int[] queue = new int[QUEUE_SIZE];

    //circular queue.
    public  void enqueue(int data){



        if( (rear+1)%QUEUE_SIZE==front){
            System.out.println("Queue is Full");
            return;
        }


        if(rear==-1) {
        rear=0;
        front=0;
        }else {
            //update rear value circularly
            rear=(rear+1)%QUEUE_SIZE;
        }
        queue[rear]=data;

    }

     void display(){
        for(int i=front; i<=rear; i++){
            System.out.print(queue[i]+"->");
        }
         System.out.println("Null");
    }

     void deQueue(){
        if(front==rear){
            System.out.println("Queue is Empty");
            return;
        }
        front++;
    }

     int rearValue(){
        return queue[rear-1];
    }

     int frontValue(){
        return queue[front];
    }


    public static void main(String[] args) {

      CircularQueueArray q = new CircularQueueArray();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Enter your choice");
            System.out.println("1.Add");
            System.out.println("2.Display");
            System.out.println("3.Front value");
            System.out.println("4.Rear Value");
            System.out.println("5.Delete");
            System.out.println("7.Exit");
            int c= sc.nextInt();

            switch (c){
                case 1:
                    System.out.println("Enter data: ");
                    q.enqueue(sc.nextInt());
                    break;
                case 2 :
                    q.display();
                    break;
                case 3:
                    System.out.println(q.frontValue());
                    break;
                case 4:
                    System.out.println(q.rearValue());
                    break;
                case 5:
                    q.deQueue();
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }
}
