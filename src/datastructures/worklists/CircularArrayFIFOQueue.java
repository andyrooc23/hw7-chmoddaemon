package datastructures.worklists;

import egr221a.exceptions.NotYetImplementedException;
import egr221a.interfaces.worklists.FixedSizeFIFOWorkList;

import java.util.NoSuchElementException;

import egr221a.interfaces.worklists.WorkList;

/**
 * See egr221a/interfaces/worklists/FixedSizeLIFOWorkList.java
 * for method specifications.
 */
public class CircularArrayFIFOQueue<E> extends FixedSizeFIFOWorkList<E> {
    private E[] array;
    private int size;
    private int front;

    public CircularArrayFIFOQueue(int capacity) {
        super(capacity);
        array = (E[]) new Object[capacity];
        size = 0;
        front = 0;
    }

    /**
     * This method adds work to the workList.
     *
     * @param work the work to add to the worklist
     */
    @Override
    public void add(E work) {
        if (work == null) {
            throw new IllegalArgumentException("Work is null");
        } else if (size == capacity()) {
            throw new IllegalStateException("Buffer is full");
        } else {
            array[(front + size) % capacity()] = work; // find the last spot in the circular list and add it to the next
            size++;
        }
    }

    /**
     * This method takes a gander at what the next item is in the list and returns it.
     *
     * @return the next item on the list.
     */
    @Override
    public E peek() {
        if (!hasWork()) {
            throw new NoSuchElementException("Peek is not possible on an item that is null");
        } else {
            return array[front]; // return that item!
        }
    }

    /**
     * This method looks at the ith item in the array and returns it.
     *
     * @param i the index of the element to peek at
     * @return the item at the ith index of the array
     */
    @Override
    public E peek(int i) {
        if (i > capacity() || i < 0) {
            throw new IndexOutOfBoundsException("Index is not within the array's capacity");
        } else if (!hasWork()) {
            throw new IllegalArgumentException("Peek is not possible when the list is empty");
        } else {
            return array[(front + i) % capacity()]; // return the ith item in the array
        }
    }

    /**
     * This method returns the next item in the array and then deletes it from the array.
     *
     * @return the next item in the array
     */
    @Override
    public E next() {
        if (!hasWork()) {
            throw new NoSuchElementException("The item you are trying to return does not exist");
        } else {
            E temp = array[front]; // temp variable holding the next item
            array[front] = null; // next = null
            if (front == capacity() - 1) { // if the index of the front was the last value in the array
                front = 0; // now the front is the first value in the array
            } else {
                front++; // otherwise just the next value in the array
            }
            size--; // decrement the size!
            return temp; // return the value!!
        }
    }

    /**
     * This method changes the ith element in the array by replacing it with value.
     *
     * @param i     the index of the element to update
     * @param value the item that is replacing the ith value in the array
     */
    @Override
    public void update(int i, E value) {
        if (i >= capacity()) {
            throw new IndexOutOfBoundsException("Index is not within the array's capacity");
        } else if (array[(front + i) % capacity()] == null) {
            throw new IllegalArgumentException("Piece you are accessing is null");
        } else if (value == null) {
            throw new IllegalArgumentException("That's illegal (value = null)");
        } else {
            array[(front + i) % capacity()] = value; // find the ith value and replace it
        }
    }

    /**
     * this method returns the size
     * @return the size (were you paying any attention at all?)
     */
    @Override
    public int size() {
        return size; // get returned nerd
    }

    /**
     * This method clears out the array.
     */
    @Override
    public void clear() {
        array = (E[]) new Object[capacity()];
        front = 0;
        size = 0;
    }

    @Override
    public int compareTo(FixedSizeFIFOWorkList<E> other) {
        // You will implement this method in p2. Leave this method unchanged for p1.
        throw new NotYetImplementedException();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        // You will finish implementing this method in p2. Leave this method unchanged for p1.
        if (this == obj) {
            return true;
        } else if (!(obj instanceof FixedSizeFIFOWorkList<?>)) {
            return false;
        } else {
            FixedSizeFIFOWorkList<E> other = (FixedSizeFIFOWorkList<E>) obj;

            // Your code goes here

            throw new NotYetImplementedException();
        }
    }

    @Override
    public int hashCode() {
        // You will implement this method in p2. Leave this method unchanged for p1.
        throw new NotYetImplementedException();
    }
}
