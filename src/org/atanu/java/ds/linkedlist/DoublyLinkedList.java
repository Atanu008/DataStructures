package org.atanu.java.ds.linkedlist;

public class DoublyLinkedList {

    Node head;  // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;
        Node prev;

        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node(int d) {
            data = d;
        }
    }

    // Adding a node at the front of the list
    public void push(int new_data) {
        /* 1. allocate node
         * 2. put in the data */
        Node new_Node = new Node(new_data);

        /* 3. Make next of new node as head and previous as NULL */
        new_Node.next = head;
        new_Node.prev = null;

        /* 4. change prev of head node to new node */
        if (head != null)
            head.prev = new_Node;

        /* 5. move the head to point to the new node */
        head = new_Node;
    }

    /* Given a node as prev_node, insert a new node after the given node */
    public void InsertAfter(Node prev_Node, int new_data) {

        /*1. check if the given prev_node is NULL */
        if (prev_Node == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }

        /* 2. allocate node
         * 3. put in the data */
        Node new_node = new Node(new_data);

        /* 4. Make next of new node as next of prev_node */
        new_node.next = prev_Node.next;

        /* 5. Make the next of prev_node as new_node */
        prev_Node.next = new_node;

        /* 6. Make prev_node as previous of new_node */
        new_node.prev = prev_Node;

        /* 7. Change previous of new_node's next node */
        if (new_node.next != null)
            new_node.next.prev = new_node;
    }


    /* Given a node as prev_node, insert a new node after the given node */
    public void InsertBefore(Node next_Node, int new_data) {

        /*1. check if the given prev_node is NULL */
        if (next_Node == null) {
            System.out.println("The given next node cannot be NULL ");
            return;
        }

        /* allocate node  */
        /*  put in the data */
        Node new_node = new Node(new_data);

        /* 4. Make prev of new node as prev of next_node */
        new_node.prev = next_Node.prev;

        /* 5. Make next_node as next of new_node */
        new_node.next = next_Node;

        /* 6. Make the prev of next_node as new_node */
        next_Node.prev = new_node;

        /* 7. Change next of new_node's previous node */
        if (new_node.prev != null) {
            new_node.prev.next = new_node;
        }
		/* 8. If the prev of new_node is NULL, it will be 
        the new head node */
        else
            head = new_node;
    }

    // Add a node at the end of the list
    void append(int new_data) {
        /* 1. allocate node
         * 2. put in the data */
        Node new_node = new Node(new_data);

        Node last = head; /* used in step 5*/

        /* 3. This new node is going to be the last node, so
         * make next of it as NULL*/
        new_node.next = null;

        /* 4. If the Linked List is empty, then make the new
         * node as head */
        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }

        /* 5. Else traverse till the last node */
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = new_node;

        /* 7. Make last node as previous of new node */
        new_node.prev = last;
    }

    public void deleteNodeByKey(int key) {

        Node temp = head;
        if (temp == null) {
            return;
        }

        if (temp != null && temp.data == key) {
            deleteNode(temp);
            return;
        }

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp != null)
            deleteNode(temp);
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
        for (int i = 1; temp != null && i < position; i++) {
            //System.out.println("\nData in loop  "+temp.data);
            temp = temp.next;

        }

        // If position is more than number of nodes
        if (temp == null)
            return;

        deleteNode(temp);
    }

    private void deleteNode(Node deleteNode) {
        if (deleteNode.next != null) {
            deleteNode.next.prev = deleteNode.prev;
        }

        if (deleteNode.prev != null) {
            deleteNode.prev.next = deleteNode.next;
        }
    }

    public void printlist(Node node) {
        Node last = null;
        System.out.println("Traversal in forward Direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversal in reverse direction");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
    }


    public static void main(String[] args) {

        /* Start with the empty list */
        DoublyLinkedList dll = new DoublyLinkedList();

        // Insert 6. So linked list becomes 6->NULL
        dll.append(6);

        // Insert 7 at the beginning. So linked list becomes 7->6->NULL
        dll.push(7);

        // Insert 1 at the beginning. So linked list becomes 1->7->6->NULL
        dll.push(1);

        // Insert 4 at the end. So linked list becomes 1->7->6->4->NULL
        dll.append(4);

        // Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL
        dll.InsertAfter(dll.head.next, 8);

        dll.InsertBefore(dll.head.next.next, 99);

        System.out.println("Created DLL is: ");
        dll.printlist(dll.head);

        //dll.deleteNodeByKey(4);
        dll.deleteNodeByPosition(6);

        System.out.println("\n After Deletion by POs");
        dll.printlist(dll.head);


    }

}
