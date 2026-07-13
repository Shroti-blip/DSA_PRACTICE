package Day13;

import Day12.Queue;

import java.util.Scanner;

public class QueueArray {

    int QUEUE_SIZE=5;
    int front=0;//fixed.
    int rear=0;//next free position
    int[] queue = new int[QUEUE_SIZE];


        //Using Array;
       public void enqueue(int data){
//           if(rear==0){
//               queue[rear]=data;//update rare value instead of front
//               rear++;
//               return;
//           }
           queue[rear]=data;
           rear++;
        }

        void enqueue2(int data){
           if(rear>=QUEUE_SIZE){
               System.out.println("Overflow");
               return;
           }
           queue[rear]=data;
           rear++;
        }

        void display(){
            for(int i =front; i<rear; i++){
                System.out.print(queue[i]+"->");
            }
            System.out.println("null");
        }

        int frontValue(){
           if(front==rear){
               System.out.println("Queue is empty.");
               return -1;
           }
           return queue[front];
        }

        int rearValue(){
           return queue[rear-1];
        }

        void deQueue(){
           if(front==rear){
               System.out.println("Queue is empty");
               return;
           }

           front++;
        }


    public static void main(String[] args) {

           QueueArray q = new QueueArray();
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
