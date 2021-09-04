package data_structure;

import java.util.Scanner;

/**
 * @author prateek.bangre on 23/05/21.
 * @Project Algorithm_Study
 */
public class Stack_Using_LinkedList {

    Node top = null;

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private void push(int value){

        Node newNode = new Node(value);
        if (top != null)
            newNode.next = top;

        top = newNode;
        System.out.println("Item pushed");
    }

    private void pop(){

        if (top == null)
            System.out.println("Stack is Empty");
        else {

            top = top.next;
            System.out.println("Item popped");
        }
    }

    private void display(){
        System.out.println("Printing stack elements .....");
        Node temp = top;
        while (temp != null){
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int choice=0;
        Scanner scanner = new Scanner(System.in);
        Stack_Using_LinkedList stack = new Stack_Using_LinkedList();
        System.out.println("*********Stack operations using LinkedList*********");
        System.out.println("------------------------------------------------");
        while(choice != 4)
        {
            System.out.println("Chose one from the below options...");
            System.out.println("1.Push\n2.Pop\n3.Show\n4.Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter Value: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
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
