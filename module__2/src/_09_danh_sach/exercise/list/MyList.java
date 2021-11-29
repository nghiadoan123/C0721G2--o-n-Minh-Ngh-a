package _09_danh_sach.exercise.list;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];


    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    public void add(int index, E e) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        } else {
            if (size == elements.length) {
                ensureCapa();
            }
            size++;
            for (int i = size - 1; i > index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = e;
        }
    }

    public E remove(int index) {
        ensureCapa();
        if (index >= 0 && index < size) {
            for (int i = index; i < elements.length - 1; i++) {
                elements[i] = elements[i + 1];
            }
        }
        size--;
        return (E) elements;
    }

    public int size() {
        return size;
    }

    public MyList<E> clone(){
        MyList<E> clone = new MyList<>();
        for (int i=0;elements[i]!=null;i++){
            clone.add((E) elements[i]);
        }
        return clone;
    }

    public boolean contains(E e) {
        for (int i = 0; i <elements.length ; i++) {
            if (e.equals(elements[i])){
                return true;
            }
        }
        return false;
    }
    public boolean addElement(E e) {
        if (size == elements.length) {
            ensureCapa();
            elements[size++] = e;
        }
        return true;
    }


    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        for (int i = 0; i <DEFAULT_CAPACITY ; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}
