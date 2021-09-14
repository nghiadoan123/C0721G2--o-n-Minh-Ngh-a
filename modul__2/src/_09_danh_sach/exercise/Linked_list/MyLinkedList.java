package _09_danh_sach.exercise.Linked_list;

import java.util.Arrays;
import java.util.LinkedList;

public class MyLinkedList<E> {
    Node head;
    private int numNodes;

    public MyLinkedList(Object data) {
        head = new Node(data);
        numNodes++;
    }

    private class Node {
        Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    private void ensureCapa(int minCapacity) {
        numNodes = minCapacity;
    }

    public void add(int index, Object data) {
        Node temp = head;
        index--;
        Node holder;
        if (index<0 || index>numNodes){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        } else {
            for (int i = 0; i < index && temp.next != null; i++) {
                temp = temp.next;
            }
            holder = temp.next;
            temp.next = new Node(data);
            temp.next.next = holder;
            numNodes++;
        }

    }

    public void add( Object data) {
        Node temp = head;
        Node holder;

        for (int i = 0;  temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(Object data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    public void addLast(Object data) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < numNodes && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public E remove(int index) {
        Node temp;
        if (numNodes == 0) {
            return null;
        }
        if (index == 0) {
            temp = head;
            head = head.next;
            numNodes--;
            if (head == null) {
                return (E) temp;
            }
        } else {

            Node previous = head;
            for (int i = 0; i <= index - 2; i++) {
                previous = previous.next;
            }

            Node current = previous.next;
            previous.next = current.next;
            temp = current.next.next;
            numNodes--;
            return (E) temp;
        }
        return (E) temp;
    }

    public int size() {
        return numNodes;
    }

    public boolean contains(Object data) {
        Node temp = head;
        for (int i = 0; i < numNodes && temp.next != null; i++) {
            temp = temp.next;
            if (temp!= null && data.equals(temp.data)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object data) {
        Node temp = head;
        final int COUNT =1;
        final int COUNT_1 =-1;
        for (int i = 0; i < numNodes && temp.next != null ; i++) {
            if (i == 0) {
                if (data.equals(temp.data)) {
                    return COUNT;
                }
            } else {
                temp = temp.next;
                //Node holder = temp.next;
                if (temp!= null && data.equals(temp.data)) {
                    return COUNT;
                }
            }
        }
        return COUNT_1;
    }

    public boolean addElement(Object data) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < numNodes && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
        return true;
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node getFirst() {
        Node temp = head;
        return temp;
    }

    public Node getLast() {
        Node temp = head;
        for (int i = 0; i < numNodes - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public MyLinkedList<E> clone(){
        if (numNodes ==0){
            throw new NullPointerException();
        }
        MyLinkedList<E> temp = new MyLinkedList<E>(0);
        Node tempNode = head;
        temp.addFirst((E) tempNode.data);
        tempNode = tempNode.next;
        while (tempNode!=null){
            temp.addLast((E)tempNode.data);
            tempNode = tempNode.next;
        }
        return temp;
    }

    public void clear() {
        head = null;
    }
}
