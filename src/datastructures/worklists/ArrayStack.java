package datastructures.worklists;

import egr221a.exceptions.NotYetImplementedException;
import egr221a.interfaces.worklists.LIFOWorkList;

import java.util.NoSuchElementException;

/**
 * See egr221a/interfaces/worklists/LIFOWorkList.java
 * for method specifications.
 */
public class ArrayStack<E> extends LIFOWorkList<E> {
    //Array of work: this is essentially the work list
    private E[] array;
    private int size;
    final private static int INITIALSIZE = 10;

    public ArrayStack() {
        array = (E[]) new Object[INITIALSIZE];
        size = 0;
    }

    /**
     * This method adds work to the array stack. It only alllows non null values
     * @param work
     */
    @Override
    public void add(E work) {
        if(work == null){
            throw new IllegalArgumentException("Work is null");
        }else if (!hasWork()){
            array[0] = work;
            size++;
        }else if(size % INITIALSIZE == 0){
            E[] tempArray = (E[]) new Object[array.length * 2];
            for(int i = 0; i < array.length; i++){
                tempArray[i] = array[i];
            }
            array = tempArray;
            array[size] = work;
            size++;
        }else{
            array[size] = work;
            size++;
        }
    }

    /**
     * This method returns the top of the arrays value
     * @return top value
     */
    @Override
    public E peek() {
        if(hasWork()) {
            return array[size - 1];
        }else{
            throw new NoSuchElementException("There is no element in the stack");
        }
    }

    /**
     * This method returns the top of the array stack and removes it from
     * the array
     * @return next value
     */
    @Override
    public E next() {
        if(size != 0) {
            E toReturn = array[size - 1];
            array[size - 1] = null;
            size--;
            return toReturn;
        }else{
            throw new NoSuchElementException("The stack is empty");
        }
    }

    /**
     * Returns the number of pieces of data in the array
     * @return size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Resets the array and all instance fields to how they were
     * right after the constructor
     */
    @Override
    public void clear() {
        array = (E[]) new Object[INITIALSIZE];
        size = 0;
    }
}