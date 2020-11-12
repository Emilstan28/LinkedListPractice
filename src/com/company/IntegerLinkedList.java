package com.company;

public class IntegerLinkedList {


    private IntegerNode head;
    private int size;

    public void addToFront(Integer value) {
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public IntegerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        IntegerNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void insertSorted(Integer value) {
//        Given an integer, insert it into its correct sorted position in the linked list

        IntegerNode nodeToInsert = new IntegerNode(value);
        IntegerNode nodeToCheckAgainst = head;
        IntegerNode previousNode = head;
        boolean insertedAndSorted = false;


        while (!insertedAndSorted) {
            if (nodeToCheckAgainst == null){
                addToFront(value);
                insertedAndSorted = true;
            } else if (nodeToInsert.getValue() < nodeToCheckAgainst.getValue()) {
                if (nodeToCheckAgainst.getValue().equals(previousNode.getValue())) {
                    addToFront(value);
                } else {
                    previousNode.setNext(nodeToInsert);
                    nodeToInsert.setNext(nodeToCheckAgainst);
                }
                insertedAndSorted = true;
            } else if (nodeToInsert.getValue() > nodeToCheckAgainst.getValue()) {
                if (nodeToCheckAgainst.getNext() != null) {
                    if (nodeToInsert.getValue() < nodeToCheckAgainst.getNext().getValue()) {
                        nodeToInsert.setNext(nodeToCheckAgainst.getNext());
                        nodeToCheckAgainst.setNext(nodeToInsert);
                        insertedAndSorted = true;
                    }
                } else {
                    nodeToCheckAgainst.setNext(nodeToInsert);
                    insertedAndSorted = true;
                }
            }

            if (previousNode != null && nodeToCheckAgainst != null) {
                nodeToCheckAgainst = nodeToCheckAgainst.getNext();
                if (previousNode.getNext() != null) {
                    while (!previousNode.getNext().getValue().equals(nodeToCheckAgainst.getValue())) {
                        previousNode = previousNode.getNext();
                    }
                }
            }
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
