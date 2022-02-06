package datastructures.worklists;

import egr221a.exceptions.NotYetImplementedException;
import egr221a.interfaces.worklists.FIFOWorkList;

import java.util.NoSuchElementException;

/**
 * See egr221a/interfaces/worklists/FIFOWorkList.java
 * for method specifications.
 */
public class ListFIFOQueue<E> extends FIFOWorkList<E> {
    private FIFONode<E> first;
    private FIFONode<E> last;
    private int size;

    //Basic constructor
    public ListFIFOQueue() {
        first = null;
        last = null;
        size = 0;
    }

    //Adds work to the Queue
    @Override
    public void add(E work) {
        if (work == null) {
            throw new IllegalArgumentException("Work is null");
        }else if (first == null) {
            first = new FIFONode<>(work);
            last = first;
        } else {
            FIFONode temp = new FIFONode<>(work);
            last.next = temp;
            last = temp;
        }
        size++;
    }

    //Returns front of the queue data
    @Override
    public E peek() {
        if (first != null) {
            return first.data;
        } else {
            throw new NoSuchElementException("There is no element to return");
        }
    }

    //Returns front of the queue data and updates first
    @Override
    public E next() {
        if (first != null) {
            E tempData = first.data;

            if(last == first){
                clear();
                return tempData;
            }else {
                first = first.next;
                size--;
                return tempData;
            }
        }else{
            throw new NoSuchElementException("There is no element to return");
        }
    }

    //Returns the size of the queue
    @Override
    public int size() {
        return size;
    }

    //Resets the queue to how it was right after the constructor
    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * A private class of Nodes that store generic data
     * and holds data necessary for each node
     * @param <E> data for the node
     */
    private static class FIFONode<E> {
        //The next Node in the queue
        public FIFONode next;
        public E data;

        public FIFONode(E data) {
            this.data = data;
            this.next = null;
        }
    }
}