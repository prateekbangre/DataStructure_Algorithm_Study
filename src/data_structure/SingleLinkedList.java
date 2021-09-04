package data_structure;

/**
 * @author prateek.bangre on 22/05/21.
 * @Project Algorithm_Study
 */
/*
Today we will see how to make Single Linked List
*/
public class SingleLinkedList {

    // represent the head of the linked list
    Node head;

    // static inner class
    static class Node{
        int data;
        // connect each node to next node
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static SingleLinkedList insertAtBeginning(SingleLinkedList linkedList, int value){
        Node newNode = new Node(value);
        if (linkedList.head == null){
            linkedList.head = newNode;
        }else{
            newNode.next = linkedList.head;
            linkedList.head = newNode;
        }
        return linkedList;
    }

    static SingleLinkedList insertAtEnd(SingleLinkedList linkedList, int value){
        Node newNode = new Node(value);
        if (linkedList.head == null){
            linkedList.head = newNode;
        }else{
            Node temp = linkedList.head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return linkedList;
    }

    static SingleLinkedList insertAtPosition(SingleLinkedList linkedList, int value, int position){
        Node newNode = new Node(value);
        if (linkedList.head == null){
            linkedList.head = newNode;
        }else{
            Node temp = linkedList.head;
            int count = 1;
            while (temp.next != null){
                temp = temp.next;
                if (count++ == position){
                    break;
                }
            }
            temp.next = newNode;
        }
        return linkedList;
    }

    private static void display(SingleLinkedList linkedList){
        Node currentNode = linkedList.head;
        while (currentNode != null){
            System.out.print(currentNode.data +"  ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    private static SingleLinkedList removeFromBeginning(SingleLinkedList linkedList){

        if (linkedList.head != null) {
            linkedList.head = linkedList.head.next;
        }
        return linkedList;
    }

    private static SingleLinkedList removeFromEnd(SingleLinkedList linkedList){

        Node currentNode = linkedList.head;
        Node prev = null;
        while (currentNode.next != null){
            prev = currentNode;
            currentNode = currentNode.next;
        }

        prev.next = null;
        return linkedList;
    }

    private static SingleLinkedList removeFromPosition(SingleLinkedList linkedList, int position){
        Node currNode = linkedList.head, prev = null;

        // CASE 1: If index is 0, then head node itself is to be
        if (position == 0 && currNode != null) {
            linkedList.head = currNode.next;
            return linkedList;
        }

        //
        // CASE 2: If the index is greater than 0 but less than the
        int counter = 0;

        // Count for the index to be deleted, keep track of the previous node,
        // as it is needed to change currNode.next
        while (currNode != null) {
            if (counter == position) {
                prev.next = currNode.next;
                break;
            }
            else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        // CASE 3: The index is greater than the size of the
        // In this case, the currNode should be null
        if (currNode == null) {
            System.out.println(position + " position element not found");
        }
        return linkedList;
    }

    public static void main(String[] args) {

        SingleLinkedList linkedList = new SingleLinkedList();

//        insertAtBeginning(linkedList, value);
        linkedList = insertAtBeginning(linkedList, 10);
//        insertAtEnd(linkedList, value);
        linkedList = insertAtEnd(linkedList, 20);
        linkedList = insertAtEnd(linkedList, 40);
//        insertAtPosition(linkedList, value, position);
        linkedList = insertAtPosition(linkedList, 30, 2);

        display(linkedList);

//        removeFromBeginning(linkedList);
        linkedList = removeFromBeginning(linkedList);
//        removeFromEnd(linkedList);
        linkedList = removeFromEnd(linkedList);
//        removeFromPosition(linkedList, position);
        linkedList = removeFromPosition(linkedList, 0);

        display(linkedList);
    }
}
