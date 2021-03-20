package org.atanu.java.ds.heap;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @param <T>
 * @author atanu
 * Ref : https://gist.github.com/snarkbait/86c7a4bc743e8f327dbc
 */
public class BinaryHeap<T extends Comparable> {

    private static int MAX_SIZE = 40;
    private T[] array;
    private int count = 0;
    private boolean min;

    public BinaryHeap(Class<T> clazz, T[] input) {
        this(clazz, input, MAX_SIZE, true);
    }

    public BinaryHeap(Class<T> clazz, T[] input, int size, boolean minMaxflag) {

        array = (T[]) Array.newInstance(clazz, size);
        min = minMaxflag;
        // add each element to the heap
        for (T each : input) {
            insert(each);
        }
    }

    public int getLeftChildIndex(int index) {
        int leftChildIndex = 2 * index + 1;
        if (leftChildIndex >= count) {
            return -1;
        }
        return leftChildIndex;
    }

    public int getRightChildIndex(int index) {
        int rightChildIndex = 2 * index + 2;
        if (rightChildIndex >= count) {
            return -1;
        }
        return rightChildIndex;
    }

    public int getParentIndex(int index) {
        if (index < 0 || index > count) {
            return -1;
        }

        return (index - 1) / 2; // This is also sufficient.

    }

    public void swap(int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == array.length;
    }

    public T getElementAtIndex(int index) {
        return array[index];
    }

    /**
     * Add DEFAULT_CAPACITY to length of <code>heap</code> array
     *
     * @return new array of type T
     */
    public T[] resize() {
        // add 10 to array capacity
        return Arrays.copyOf(array, array.length + MAX_SIZE);
    }

    public void trickleDown(int index) {
        if (min) {
            int leftChildIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);

            //Find minimum of the left and right child
            int smallerIndex = -1;
            if (leftChildIndex != -1 && rightChildIndex != -1) {
                smallerIndex = getElementAtIndex(leftChildIndex).compareTo(getElementAtIndex(rightChildIndex)) < 0 ? leftChildIndex : rightChildIndex;
            } else if (leftChildIndex != -1) {
                smallerIndex = leftChildIndex;
            } else if (rightChildIndex != -1) {
                smallerIndex = rightChildIndex;
            }

            if (smallerIndex == -1)
                return;
            // Comapare the smaller child with current index to see if a swap and further trickle down is needed
            if (getElementAtIndex(smallerIndex).compareTo(getElementAtIndex(index)) < 0) {
                swap(smallerIndex, index);
                trickleDown(smallerIndex);
            }
        } else {
            int leftChildIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);

            //Find maximum of the left and right child
            int biggerIndex = -1;
            if (leftChildIndex != -1 && rightChildIndex != -1) {
                biggerIndex = getElementAtIndex(leftChildIndex).compareTo(getElementAtIndex(rightChildIndex)) > 0 ? leftChildIndex : rightChildIndex;
            } else if (leftChildIndex != -1) {
                biggerIndex = leftChildIndex;
            } else if (rightChildIndex != -1) {
                biggerIndex = rightChildIndex;
            }

            if (biggerIndex == -1)
                return;
            // Comapare the smaller child with current index to see if a swap and further trickle down is needed
            if (getElementAtIndex(biggerIndex).compareTo(getElementAtIndex(index)) > 0) {
                swap(biggerIndex, index);
                trickleDown(biggerIndex);
            }
        }
    }

    public void trickleUp(int index) {
        int parentIndex = getParentIndex(index);

        if (min) {
            if (parentIndex != -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) < 0) {
                swap(parentIndex, index);
                trickleUp(parentIndex);
            }
        } else {
            if (parentIndex != -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) > 0) {
                swap(parentIndex, index);
                trickleUp(parentIndex);
            }
        }
    }

    public void insert(T value) {
        if (count >= array.length) {
            array = resize();
        }

        array[count] = value;
        trickleUp(count);
        count++;

    }

    public T removeHighestPriorityElement() {
        if (isEmpty()) return null;

        T highestPriorityElem = getHighestPriorityElement();
        array[0] = array[count - 1];
        array[count - 1] = null;
        count--;
        trickleDown(0);

        return highestPriorityElem;

    }

    public T getHighestPriorityElement() {

        return array[0];
    }

    public void print() {
        for (T elem : array) {
            System.out.println(elem);
        }
    }

    @Override
    public String toString() {
        String retval = "";
        for (T each : array) {
            if (each != null) retval += each + " : ";
        }
        return retval + "\n";

    }


}
