package org.atanu.java.ds.queue;

import java.io.*;
import java.util.*;

// TODO: implement documents and print queue

//Defining an abstract Document class
abstract class Document {

    String name;
    String type;

    Document(String name, String type) {
        this.name = name;
        this.type = type;
    }
}

// PDFDocument sub class
class PDFDocument extends Document {

    String keywords;

    PDFDocument(String name, String type, String keywords) {

        super(name, type);
        this.keywords = keywords;
    }
}

// WordDocument sub class
class WordDocument extends Document {

    String comments;

    WordDocument(String name, String type, String comments) {

        super(name, type);
        this.comments = comments;
    }
}

// Simple Document Creation factory
class Documentfactory {

    Document createDocument(String name, String type, String comments, String keywords) {
        if (type.equals("pdf")) {
            return new PDFDocument(name, type, keywords);
        }
        if (type.equals("word")) {
            return new WordDocument(name, type, comments);
        }

        return null;
    }
}

// Generic Queue Using Linked List
class GenericQueueUsingLinkedList<E> {

    // Two Pointers
    Node<E> rear, front;

    int size;

    private class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;

        }
    }

    GenericQueueUsingLinkedList() {

        rear = null;
        front = null;
        size = 0;
    }

    public void enqueue(E data) {

        Node node = new Node(data);

        // In Case of Empty
        if (isEmpty()) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }

        size++;

    }

    public E dequeue() {

        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        }

        //Get Front
        E retVal = front.data;

        //Forward Front
        front = front.next;

        // In case of Empty again
        if (front == null) {
            rear = null;
        }

        //System.out.println("Removing "+ retVal);

        size--;
        return retVal;

    }

    public boolean isEmpty() {

        return rear == null && front == null;
    }
}

class Solution {
    public static void main(String args[]) throws Exception {
        // see stub code below for definition of InputItem
        List<InputItem> inputItems = ParseInput();
        // TODO: create a print queue

        // TODO: for each input item, add/remove a document to/from the print queue

        // TODO: after processing all input, report the documents contained in the print queue

        //Create Factory to Create Documents
        Documentfactory factory = new Documentfactory();
        GenericQueueUsingLinkedList<Document> queue = new GenericQueueUsingLinkedList<>();

        //Process Each InputItem
        for (InputItem item : inputItems) {

            //If the Operation is PUSH push it to the queue
            if (item.operation.equals("PUSH")) {
                Document d = factory.createDocument(item.name, item.type, null, null);
                queue.enqueue(d);
            }

            //POP from Queue
            if (item.operation.equals("POP")) {
                queue.dequeue();
            }
        }

        //Iterate the remaining Queue
        while (!queue.isEmpty()) {

            Document returnVal = queue.dequeue();
            //Print Queue
            DisplayDocument(returnVal.name, returnVal.type.toUpperCase());
        }

    }


    static class InputItem {
        public String operation;
        public String type;
        public String name;
    }

    // reads input and parses it into a collection of items
    static List<InputItem> ParseInput() {
        List<InputItem> inputItems = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            InputItem item = new InputItem();
            item.operation = scanner.next();
            if (item.operation.equals("END")) {
                break;
            }

            if (item.operation.equals("PUSH")) {
                item.type = scanner.next();
                item.name = scanner.next();
            }
            inputItems.add(item);
        }

        return inputItems;
    }

    // writes out a document's attributes in the expected format
    static void DisplayDocument(String name, String type) {
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println();
    }
}
