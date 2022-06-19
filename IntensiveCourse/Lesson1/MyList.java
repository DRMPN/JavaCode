package IntensiveCourse.Lesson1;

import java.util.Comparator;

/**
 * Simple interface of list with CRUD functions.
 * 
 * @author DRMPN
 */
public interface MyList<E> {

    /**
     * Appends the specified element to the end of this list.
     * 
     * @param element - element to be inserted
     * @return true on success
     */
    boolean add(E element);

    /**
     * Inserts the specified element at the specified position in this list.
     * 
     * @param index - index at which the specified element is to be inserted
     * @param element - element to be inserted
     */
    void add(int index, E element);

    /**
     * Removes all of the elements from this list.
     */
    void clear();

    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     */
    E get(int index);

    /**
     * Returns the index of the first occurrence of the specified element in this list.
     * @param o - element to search for 
     * @return the index of the first occurrence of the specified element in this list
     */
    int indexOf(Object o);

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements
     */
    boolean isEmpty();

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left.
     * 
     * @param index - the index of the element to be removed
     * @return the element previously at the specified position
     */
    E remove(int index);

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * @param o - element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    boolean remove(Object o);

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param index - index of the element to replace
     * @param element - element to be stored at the specified position
     * @return the element previously at the specified position
     */
    E set(int index, E element);

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    int size();

    /**
     * Sorts this list according to the natural ordering of its elements.
     * 
     */
    void sort();

    /**
     * Sorts this list according to the order induced by the specified Comparator.
     * @param c - the Comparator used to compare list elements
     */
    void sort(Comparator<? super E> c);
}
