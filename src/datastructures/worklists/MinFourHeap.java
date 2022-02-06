package datastructures.worklists;

import egr221a.interfaces.worklists.PriorityWorkList;
import egr221a.exceptions.NotYetImplementedException;
import java.util.NoSuchElementException;

/**
 * See egr221a/interfaces/worklists/PriorityWorkList.java
 * for method specifications.
 */
public class MinFourHeap<E extends Comparable<E>> extends PriorityWorkList<E> {
    /* Do not change the name of this field; the tests rely on it to work correctly. */
    private E[] data;
    private static final int INITIAL_CAPACITY = 256;
    private int size;

    /**
     * Calls the clear method which resets everything to initial state
     */
    public MinFourHeap() {
        clear();
    }

    @Override
    public boolean hasWork() {
        return size > 0;
    }

    /**
     * This method takes any work and adds it to the heap worklist.
     * It does thi by adding it to the very bottom of the heap and
     * then percolating that up the ree to the proper position.
     * @param work to add
     */
    @Override
    public void add(E work) {

        if(size == data.length - 1){
            E[] oldArray = data;
            data = (E[]) new Comparable[data.length * 2];
            for(int i = 0; i < oldArray.length; i++){
                data[i] = oldArray[i];
            }
        }

        int hole = size++;
        data[hole] = work;
        percolateUp(hole);

    }

    /**
     * Simply returns the smallest item without removing it
     * @return smallest in the heap
     */
    @Override
    public E peek() {
        if(size <= 0){
            throw new NoSuchElementException("There is nothing in the heap");
        }else{
            return data[0];
        }
    }

    /**
     * This method removes the minimum node in the heap and
     * updates the heap to account for the gap at the top of the
     * heap.
     * @return
     */
    @Override
    public E next() {
        E toReturn;
        if(size <= 0){
            throw new NoSuchElementException("The heap is epmty");
        }else{
            toReturn = data[0];
        }
        data[0] = data[--size];
        data[size] = null;
        if(size > 0) {
            percolateDown(0);
        }

        return toReturn;
    }

    /**
     * @return the size of the heap at any given point, or
     * the number of elements in the heap
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Creates a new array to keep track of the heap
     * Size is initially zero, array is initially empty
     */
    @Override
    public void clear() {
        data = (E[]) new Comparable[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * This is a private helper method that moves inserted data
     * into the heap to its proper position on the heap
     * @param hole
     */
    private void percolateUp(int hole){
        E work = data[hole];
        int parentIndex = (hole - 1) / 4;
        while (hole > 0 && work.compareTo(data[parentIndex]) < 0) {
            data[hole] = data[parentIndex];
            hole = parentIndex;
            parentIndex = (hole - 1) / 4;
        }
        data[hole] = work;
    }

    /**
     * A private helper method that helps with removing the minimum
     * item from the root of the heap and resets the heap to
     * its proper set up.
     * @param index
     */
    private void percolateDown(int index){

        E work = data[index];
        int childIndex = getSmallestChildIndex(index);
        while(childIndex > 0 && childIndex < size() && work.compareTo(data[childIndex]) > 0){
            data[index] = data[childIndex];
            index = childIndex;
            childIndex = getSmallestChildIndex(index);
        }
        data[index] = work;
    }

    /**
     * This method is a private helper method that finds the
     * smallest child of any given parent or hole on the heap.
     * @param index of the parent or hole
     * @return the smallest child
     */
    private int getSmallestChildIndex(int index) {
        int outerLeft = 4 * index + 1;
        int min = outerLeft;
        for (int i = outerLeft; i < outerLeft + 4; i++) {
            if (i < size && data[i].compareTo(data[min]) < 0 ) {
                min = i;
            }
        }
        return min;
    }
}
