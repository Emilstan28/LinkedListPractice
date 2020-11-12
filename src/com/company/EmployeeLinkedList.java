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

    public void addBefore(Employee employeeExisting, Employee employee){
        EmployeeNode node = new EmployeeNode(employee);
        EmployeeNode nodeToSearchFor = new EmployeeNode(employeeExisting);
        boolean inserted = false;
        EmployeeNode backNode = tailNode;
        EmployeeNode frontNode = headNode;
        EmployeeNode secondInBetween;
        if (backNode != null && frontNode != null){
            while (!inserted)
            if (backNode.getPrevious().getEmployee().equals(nodeToSearchFor.getEmployee())){
                backNode = backNode.getPrevious();
                secondInBetween = backNode.getPrevious();
                secondInBetween.setNext(node);
                backNode.setPrevious(node);
                node.setNext(backNode);
                node.setPrevious(secondInBetween);
                inserted = true;
            } else if (frontNode.getNext().getEmployee().equals(nodeToSearchFor.getEmployee())){
                frontNode = frontNode.getNext();
                secondInBetween = frontNode.getPrevious();
                secondInBetween.setNext(node);
                frontNode.setPrevious(node);
                node.setNext(frontNode);
                node.setPrevious(secondInBetween);
                inserted = true;
            } else if (frontNode.getNext().getEmployee().equals(backNode.getEmployee())){
                System.out.println("Couldn't find the node to insert before, check the data provided");
                inserted = true;
            }
        }
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
