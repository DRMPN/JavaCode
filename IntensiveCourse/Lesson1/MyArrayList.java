package IntensiveCourse.Lesson1;

import java.util.Comparator;

/**
 * Personal implementation of the ArrayList class. Not thread safe.
 * 
 * @author DRMPN
 * 
 */
public class MyArrayList<E> implements MyList<E> {

    private int size = 0;
    private Object[] elementData;
    private final int DEFAULT_CAPACITY = 10;

    /**
     * Creates a new MyArrayList with default capacity.
     * 
     */
    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Creates a new MyArrayList with a given capacity.
     * 
     * @param capacity - the size of a newly created list
     * 
     */
    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        elementData = new Object[capacity];
    }

    /**
     * Appends the given element to the end of this list.
     * 
     * @param element - element to be appended to this list
     * @return true
     */
    @Override
    public boolean add(E element) {
        if (ensureCapacity(size)) {
            increaseCapacity(size);
        }
        elementData[size] = element;
        size++;
        return true;
    }

    /**
     * Inserts the given element to the given index of this list.
     * 
     * @param index   - index of the element to add
     * @param element - element to be appended to this list
     */
    @Override
    public void add(int index, E element) {
        if (ensureCapacity(size)) {
            increaseCapacity(size);
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    /**
     * Removes all of the elements from this list.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index - index of the element to return
     * @return Returns the element at the specified position in this list
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) elementData[index];
    }

    /**
     * Returns the index of the first occurrence of the specified element in this
     * list,
     * or -1 if this list does not contain the element.
     * 
     * @param o - element to search for
     * @return the index of the first occurrence of the specified element in this
     *         list,
     *         or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns true if this list contains no elements.
     * 
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left.
     * Returns the element that was removed from the list.
     * 
     * @param index - the index of the element to be removed
     * @return the element previously at the specified position
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E oldElement = (E) elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[size] = null;
        size--;
        // TODO: probably should write trim function
        return oldElement;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it
     * is present.
     * If this list does not contain the element, it is unchanged.
     * Returns true if this list contained the specified element.
     * 
     * @param o - element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     * 
     * @param index   - index of the element to replace
     * @param element - element to be stored at the specified position
     * @return the element previously at the specified position
     */
    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E oldElement = (E) elementData[index];
        elementData[index] = element;
        return oldElement;
    }

    /**
     * Returns the number of elements in this list.
     * 
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Sorts this list.
     */
    @Override
    public void sort() {
        Sort.quicksort(elementData, 0, size - 1);
    }

    /**
     * Sorts this list using comparator.
     * 
     * @param c - comparator
     */
    @Override
    public void sort(Comparator<? super E> c) {
        Sort.quicksort(elementData, 0, size - 1, c);
    }

    private boolean ensureCapacity(int currentSize) {
        return currentSize + 1 == elementData.length;
    }

    private void increaseCapacity(int oldCapacity) {
        Object[] newElementData = new Object[oldCapacity * 3 / 2 + 1];
        System.arraycopy(elementData, 0, newElementData, 0, size);
        elementData = newElementData;
    }

}
