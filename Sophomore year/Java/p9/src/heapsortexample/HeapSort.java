/**
 * @author Cole Boothe
 *         C00558477
 *         CMPS261
 *
 *
 * Program Description: This program was
 * rewrittin from a maxheap to a minheap
 *
 *
 * Certificate of Authenticity: I certify that the code in
 * the method functions including method function main of
 * this project are entirely my own work.
 *
 */



package heapsortexample;

/**@author Y. Daniel Liang*/
public class HeapSort {

    /**Heap sort method*/
    public static <E extends Comparable> void heapSort(E[] list) {
        // Create a Heap of integers
        Heap<E> heap = new Heap<E>();

        // Add elements to the heap
        for (int i = 0; i < list.length; i++) {
            heap.add(list[i]);
        }

        // Remove elements from the heap and return to list in ascending order
        for (int i = 0; i < list.length; i++) {
            list[i] = heap.remove();
        }
    }


    /**test the heap sort*/
    public static void main(String[] args) {
        Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        heapSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}
