package data_structure;

import java.util.Scanner;

/**
 * @author prateek.bangre on 24/05/21.
 * @Project Algorithm_Study
 */
class Queue_Using_LinkedList{

    Node front = null;
    Node rear = null;

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    boolean isEmpty(){
        return (front == null);
    }

    boolean enQueue (int value){
            Node newNode = new Node(value);
            if (rear == null) {
                front = newNode;
                rear = newNode;
            }else {
                rear.next = newNode;
                rear = newNode;
            }
            System.out.println("Item inserted");
            return true;
    }

    boolean deQueue (){
        if (front == null){
            System.out.println("Queue is EMPTY!!!");
            return false;
        } else {
            front = front.next;
//            if (front == rear)
//                front = rear = null;
            System.out.println("Item popped");
            return true;
        }
    }

    void display (){
        if (front == null){
            System.out.println("Queue is EMPTY!!!");
        } else {
            System.out.println("Printing stack elements .....");

            Node currentNode = front;
            while (currentNode != null){
                System.out.print(currentNode.data +"  ");
                currentNode = currentNode.next;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int choice=0;
        Scanner scanner = new Scanner(System.in);
        Queue_Using_LinkedList queue = new Queue_Using_LinkedList();
        System.out.println("*********Queue operations using LinkedList*********");
        System.out.println("------------------------------------------------");
        while(choice != 4)
        {
            System.out.println("Chose one from the below options...");
            System.out.println("1.Insertion\n2.Deletion\n3.Display\n4.Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter Value: ");
                    int value = scanner.nextInt();
                    queue.enQueue(value);
                    break;
                case 2:
                    queue.deQueue();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.out.println("Exiting....");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please Enter valid choice ");
            }
        }
    }
}
