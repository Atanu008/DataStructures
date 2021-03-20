package org.atanu.java.ds.linkedlist;

public class SinglyLinkedList {

    Node head;  // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;

        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node(int d) {
            data = d;
        }
    }


    // method to insert data in front of linked list. Time complexity is O (1)
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    /* This function is in LinkedList class.
       Inserts a new node after the given prev_node. This method is
       defined inside LinkedList class shown above. Time complexity is O (1)*/
    public void insertAfter(Node pre_node, int new_data) {
        if (pre_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = pre_node.next;
        pre_node.next = new_node;

    }

    // method to insert data in last of linked list. Time complexity is O (n)
    public void append(int new_data) {
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;

    }


    public void printList(Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;

        }

    }

    public void printListRec(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");

            node = node.next;
            printListRec(node);
        }

    }

    public void printListRecRev(Node node) {
        if (node != null) {
            printListRecRev(node.next);
            System.out.print(node.data + " ");
        }

    }

    public void deleteNode(int key) {

        Node temp = head;
        Node prev = null;
        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        // If key was not present in linked list
        if (temp == null)
            return;
        // Unlink the node from linked list
        prev.next = temp.next;
    }

    public void deleteNodeByPosition(int position) {

        // If linked list is empty
        if (head == null)
            return;
        Node temp = head;
        // If head needs to be removed
        if (position == 1) {
            head = temp.next;
        }
        // Find previous node of the node to be deleted
        for (int i = 1; temp != null && i < position - 1; i++) {
            //System.out.println("\nData in loop  "+temp.data);
            temp = temp.next;

        }

        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node nextNode = temp.next.next;
        temp.next = nextNode; // Unlink the deleted node from list

    }


    /* Function to reverse the linked list */
    Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    Node reverseRec(Node curr, Node prev) {

        Node head = null;
        /* If last node mark it head*/
        if (curr.next == null) {
            head = curr;

            /* Update next to prev node */
            curr.next = prev;
            return head;
        }

        /* Save curr->next node for recursive call */
        Node next = curr.next;

        /* and update next ..*/
        curr.next = prev;
        return reverseRec(next, curr);


    }

    public static void main(String[] args) {
        /* Start with the empty list */
        SinglyLinkedList llist = new SinglyLinkedList();

        // Insert 6.  So linked list becomes 6->NUllist
        llist.append(6);

        // Insert 7 at the beginning. So linked list becomes
        // 7->6->NUllist
        llist.push(7);

        // Insert 1 at the beginning. So linked list becomes
        // 1->7->6->NUllist
        llist.push(1);

        // Insert 4 at the end. So linked list becomes
        // 1->7->6->4->NUllist
        llist.append(4);

        // Insert 8, after 7. So linked list becomes
        // 1->7->8->6->4->NUllist
        //llist.insertAfter(llist.head.next, 8);

        //llist.deleteNode(6);

        System.out.println("\nCreated Linked list is: ");
        llist.printList(llist.head);
        llist.deleteNodeByPosition(2);
        System.out.println("\nAfter Deletion Linked list is: ");
        //llist.printList(llist.head);
        llist.printListRec(llist.head);

        System.out.println("\nPrinting Reverse: ");
        //llist.printList(llist.head);
        //llist.printListRecRev(llist.head);


        //llist.head = llist.reverse(llist.head);

        Node k = llist.reverseRec(llist.head, null);
        //System.out.println("KK" + k);
        llist.printListRec(k);


    }
}