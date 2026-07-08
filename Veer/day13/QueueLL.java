package org.example.day13;

class Queue{
    int data;
    Queue next;
    public Queue(int data){
        this.data=data;
    }
}

public class QueueLL {

    private static java.util.Scanner sc=new java.util.Scanner(System.in);
    private static Queue front=null,rear=null;

    public static void enqueue(int data){
        Queue newNode=new Queue(data);
        if(front==null){
            front=newNode;
            rear=newNode;
        }else{
            rear.next=newNode;
            rear=newNode;
        }
        newNode.next=null;
        System.out.println("Data Added");
    }
    public static void dequeue(){
        if (front == null || rear == null) {
            System.out.println("Queue Underflow!");
            return;
        }
        front=front.next;
        if(front==null)
            rear=null;
        System.out.println("Value Deleted!");
    }
    public static void display(){
        if (front == null || rear == null) {
            System.out.println("Queue Underflow!");
        }else{
            Queue temp=front;
            while(temp!=null){
                if(temp==front)
                    System.out.print(temp.data+"(FRONT) => ");
                else if(temp==rear)
                    System.out.print(temp.data+"(REAR) => ");
                else
                    System.out.print(temp.data+" => ");
                temp=temp.next;
            }
            System.out.println();
        }
    }

    public static void peek(){
        if (front == null || rear == null) {
            System.out.println("Queue Underflow!");
            return;
        }
        System.out.println("Peek "+front.data);
    }
    public static boolean isEmpty(){
        if (front == null || rear == null)
            return true;
        return false;
    }
    public static int size(){
        int size=0;
        Queue temp=front;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        return size;
    }
    public static void search(int data){
        Queue temp=front;
        while(temp!=null){
            if(temp.data==data){
                System.out.println("Value exists!");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Value doesn't exist!");
    }
    public static void clear(){
        front=rear=null;
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
            System.out.println("6. Size");
            System.out.println("7. Search");
            System.out.println("8. Clear");
            System.out.println("9. Exit");
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
                System.out.println("Queue size is "+size());
            }else if(ch==7){
                System.out.print("Enter data to search : ");
                search(sc.nextInt());
            }else if(ch==8){
                clear();
            }else if(ch==9){
                System.out.println("You have exited the program!, Thank You.");
            }else{
                System.out.println("Invalid Choice!");
            }
        }while(ch!=9);
    }
}
