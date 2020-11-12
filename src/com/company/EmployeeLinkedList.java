package com.company;

public class EmployeeLinkedList {

    private EmployeeNode headNode;
    private EmployeeNode tailNode;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(headNode);
        if (headNode != null)
            headNode.setPrevious(node);
        else
            tailNode = node;
        headNode = node;
    }

    public void addToBack(Employee employee){
        EmployeeNode node = new EmployeeNode(employee);
        node.setPrevious(tailNode);
        if (tailNode != null)
            tailNode.setNext(node);
        else
            headNode = node;
        tailNode = node;
    }

    public void printList() {
        EmployeeNode current = headNode;
        System.out.print("HEAD -> ");
        while (current != null){
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public void printListBackwards() {
        EmployeeNode current = tailNode;
        System.out.print("TAIL -> ");
        while (current != null){
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getPrevious();
        }
        System.out.println("null");
    }

    public EmployeeNode removeFromFront() {
        if (isEmpty())
            return null;

        EmployeeNode removedNode = headNode;

        headNode = headNode.getNext();
        headNode.setPrevious(removedNode.getPrevious());
        return removedNode;
    }

    public EmployeeNode removeFromBack() {
        if (isEmpty())
            return null;

        EmployeeNode removedNode = tailNode;

        tailNode = tailNode.getPrevious();
        tailNode.setNext(removedNode.getNext());
        return removedNode;
    }


    public boolean isEmpty(){
        return headNode == null;
    }
}
