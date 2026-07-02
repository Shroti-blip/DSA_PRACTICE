package CircularSinglyLL;

import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

public class CSLL1 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static class CLinkedList {
        Node head;

        void insertAtEnd(int data) {
            Node node = new Node(data);
            Node temp = head;
            if (head == null) {
                head = node;
                head.next = head;
                return;
            }
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = node;
            node.next = head;
        }

        void insertAtStart(int data) {
            Node node = new Node(data);
            Node temp = head;
            if (head == null) {
                head = node;
                head.next = head;
                return;
            }
            while (temp.next != head) {
                temp = temp.next;
            }

            node.next = head;
            temp.next = node;
            head = node;
        }

        void insertAtSpecific(int idx, int data) {

            Node node = new Node(data);
            Node temp = head;
            int curr = 0;
            if (idx == 0) {
                insertAtStart(data);
                return;
            }
            if (temp.next == head) {
                insertAtEnd(data);
                return;
            }
            while (curr < idx - 1) {
                temp = temp.next;
                curr++;
            }

            node.next = temp.next;
            temp.next = node;

        }

        //
        void deleteByValue(int data) {
            Node temp = head;

            if (head == null) {
                System.out.println("List is empty.");
                return;
            }
            while (temp.next != head && temp.next.data != data) {
                temp = temp.next;
            }
//            temp.next=
        }

        int countNode() {
            Node temp = head;
            int count = 0;
            if (temp == null) {
                return 0;
            }
            do {
                count += 1;
                temp = temp.next;
            }
            while (temp != head);//not clear


            return count;
        }

        boolean searchNode(int data) {
            Node temp = head;
            if (temp == null) {
                System.out.println("List is Empty.");
                return false;
            }
            do {
                if (temp.data == data) {
                    return true;
                }
                temp = temp.next;
            } while (temp != head);
            return false;
        }

        void disPlay() {
            Node temp = head;

            if (temp == null) {
                System.out.println("empty");
                return;
            }
            do {
                System.out.print(temp.data + "->");
                temp = temp.next;
            } while (temp != head);
            System.out.println("Head");
        }


    }


    public static void main(String[] args) {
        CLinkedList list = new CLinkedList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your choice");
            System.out.println("1)Insert at end");
            System.out.println("2)Display");
            System.out.println("3)Insert at start");
            System.out.println("4)Insert Anywhere");
            System.out.println("5)Delete by value.");
            System.out.println("6)Count Nodes.");
            System.out.println("7)Search Node");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter data");
                    list.insertAtEnd(sc.nextInt());
                    break;
                case 2:
                    list.disPlay();
                    break;
                case 3:
                    System.out.println("Enter value ");
                    list.insertAtStart(sc.nextInt());
                    break;
                case 4:
                    System.out.println("Enter idx");
                    int idx = sc.nextInt();
                    System.out.println("Enter data");
                    int d = sc.nextInt();
                    list.insertAtSpecific(idx, d);
                    break;
                case 5:
                    System.out.println("Enter node to delete");
                    list.deleteByValue(sc.nextInt());
                    break;
                case 6:
                    int res = list.countNode();
                    System.out.println("Total nodes: " + res);
                    break;
                case 7:
                    System.out.println("Enter node for search");
                    int n = sc.nextInt();
                    boolean r = list.searchNode(n);
                    System.out.println("Exist or not ? " + r);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
