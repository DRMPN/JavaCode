package IntensiveCourse.Lesson1;

import java.util.Comparator;

public class Sort {

    /**
     * Recursively sorts a given list with a middle elements as
     * the Pivot from and to a given index.
     * 
     * @param array     - array to sort
     * @param fromIndex - first index of which to sort
     * @param toIndex   - last index of which to sort
     */
    public static <E> void quicksort(E[] array, int fromIndex, int toIndex) {
        if (fromIndex >= toIndex)
            return;

        int left = fromIndex, right = toIndex;
        E pivot = array[(fromIndex + toIndex) / 2];

        while (left <= right) {
            while (((Comparable) array[left]).compareTo(pivot) < 0)
                left++;
            while (((Comparable) array[right]).compareTo(pivot) > 0)
                right--;

            if (left > right)
                break;

            swap(left, right, array);
            left++;
            right--;
        }

        quicksort(array, fromIndex, right);
        quicksort(array, left, toIndex);
    }

    /**
     * Recursively sorts given list by a given comparator with a middle
     * elements as the Pivot from and to a given index.
     * 
     * @param array     - array to sort
     * @param fromIndex - first index of which to sort
     * @param toIndex   - last index of which to sort
     */
    public static <E> void quicksort(E[] array, int fromIndex, int toIndex, Comparator<E> c) {
        if (fromIndex >= toIndex)
            return;

        int left = fromIndex, right = toIndex;
        E pivot = array[(fromIndex + toIndex) / 2];

        while (left <= right) {
            while (c.compare(array[left], pivot) < 0)
                left++;
            while (c.compare(array[right], pivot) > 0)
                right--;

            if (left > right)
                break;

            swap(left, right, array);
            left++;
            right--;
        }

        quicksort(array, fromIndex, right);
        quicksort(array, left, toIndex);
    }

    private static <E> void swap(int i, int j, E[] array) {
        E temp = (E) array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
