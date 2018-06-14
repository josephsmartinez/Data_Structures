/** *******************************************************************
 * Purpose/Description:
 * The new method will replace the first occurrence of oldKey with the newKey,
 * and restore the Max-Heap property after the change.
 *
 * Author’s Panther ID: 3816842
 *
 * Certification:
 * I hereby certify that this work is my own and none of it is the work of
 * any other person
 *
 * (c) Write (in Java) a method replaceKey in the MaxHeap class with the following
 * signature:
 * public void replaceKey(Integer oldKey, Integer newKey)
 * The method will replace the first occurrence of oldKey with the newKey, and restore
 * the Max-Heap property after the change. If the oldKey does not exist in the heap, the
 * method prints an appropriate message and returns without changing the heap.
 * Example: Suppose our binary heap object (bh) has the following keys:
 *** 99 64 42 54 32 28 6 19 7 26 4
 * Then the method call: bh.replaceKey (new Integer(54), new Integer(105) should
 * change the keys to:
 *** 105 99 42 64 32 28 6 19 7 26 4
 *
 * Note: You can assume that the methods perlocateUp and perlocateDown are already
 * implemented in your MaxHeap class
 *
 * Resources for this project:
 * Data Structures by Mark Allen
 * - http://users.cis.fiu.edu/~weiss/cop3530_sum08/July16.java
 * Sesh Venugopal
 * - https://www.cs.rutgers.edu/~venugopa/
 * www.zybooks.com
 * - https://learn.zybooks.com/zybook/DataStructuresEssentialsR27/chapter/4/section/10
 ******************************************************************* */
package heap;

import java.util.Arrays;

/*
 * @author: Joseph Martinez
 */
public class Heap {

    //Class variables
    int[] heap;
    int size;

    /**
     * Constructor for the Max-Heap will initialize an array to hold elements
     *
     * @param heap is an array of elements (integers)
     */
    public Heap(int[] heap) {
        this.size = heap.length;
        this.heap = Arrays.copyOf(heap, size);
    }

    /**
     * At each step, the largest of the elements A[i], A[LEFT(i)], and
     * A[RIGHT(i)] is determined, and its index is stored in largest. If A[i] is
     * largest, then the subtree rooted at node i is a heap and the procedure
     * terminates.
     *
     * The heapify operation is used to turn an array into a heap.
     * http://staff.ustc.edu.cn/~csli/graduate/algorithms/book6/chap07.htm
     *
     * @param index
     */
    public void heapify(int index) {
        int largest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < size && heap[index] < heap[leftChild]) {
            largest = leftChild;
        }
        if (rightChild < size && heap[largest] < heap[rightChild]) {
            largest = rightChild;
        }
        //Swaps the child with the parent node if the child is larger
        if (largest != index) {
            int temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;
            heapify(largest);
        }
    }

    /**
     * The function of HEAPIFY is to let the value at A[i] "float down" in the
     * heap so that the subtree rooted at index i becomes a heap.
     */
    public void buildMaxHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    /**
     * Data Structures by Mark Allen PG: 230 This general strategy is known as a
     * percolate up; the new element is percolated up the heap until the correct
     * location is found.
     *
     * @param elem the integer to be inserted
     */
    public void insert(int elem) {
        //Increase the size of the heap
        heap = Arrays.copyOf(heap, size + 1);
        int i = size;
        int parentIndex = (int) Math.floor((i - 1) / 2);
        // Percolate up until the right position if found
        while (i > 0 && elem > heap[parentIndex]) {
            heap[i] = heap[parentIndex];
            i = parentIndex;
            parentIndex = (int) Math.floor((i - 1) / 2);
        }
        heap[i] = elem;
        size++;
    }

    /**
     * @return the largest element in the heap
     */
    public int findMax() {
        if (size == 0) {
            return -1;
        } else {
            return heap[0];
        }
    }

    /**
     * @return removes the largest element within the heap and moves the last
     * element to the top of the heap
     */
    public int extractMax() {
        if (size == 0) {
            return -1;
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return min;
    }

    public int getSize() {
        return size;
    }

    public int[] getHeap() {
        return heap;
    }

    /**
     * Prints all the elements of the heap
     */
    public void printHeap() {
        for (int i = 0; i < heap.length; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println("");
    }

    /**
     * The method will replace the first occurrence of oldKey with the newKey,
     * and restore the Max-Heap property after the change. If the oldKey does
     * not exist in the heap, the method prints an appropriate message and
     * returns without changing the heap.
     *
     * Worst case running time = O(N) if the node is not found Best case running
     * time = O(1) if the node to change is the root
     *
     * @param oldKey
     * @param newKey
     *
     * https://courses.csail.mit.edu/6.006/fall10/handouts/recitation10-8.pdf
     * Heap Algorithms
     *
     * Heap-Increase-Key(A, i, key) Input: A: an array representing a heap, i:
     * an array index, key: a new key greater than A[i] Output: A still
     * representing a heap where the key of A[i] was increased to key Running
     * Time: O(log n) where n =heap-size[A] if key < A[i]
     * error(“New key must be larger than current key”)
     * A[i] ← key
     * while i > 1 and A[Parent(i)] < A[i] exchange A[i] and A[Parent(i)] i ←
     * Parent(i)
     *
     */
    public void replaceKey(Integer oldKey, Integer newKey) {
        int i;
        boolean elementFound = false;
        for (i = 0; i < heap.length; i++) {
            if (oldKey == heap[i]) {
                heap[i] = newKey;
                elementFound = true;
                break;
            }
        }
        if (elementFound) {
            //Swap all elements
            int j = i - 1;
            int temp;
            while (j >= 0) {
                if (heap[j] < heap[i]) {
                    //Swap elements
                    temp = heap[j];
                    heap[j] = heap[i];
                    heap[i] = temp;
                }
                j--;
                i--;
            }
        } else {
            System.out.println("Element: " + oldKey + " not found!");
        }
    }

    /**
     * Main method will test numbers based on example
     *
     * @param args
     */
    public static void main(String[] args) {
        //UNIT TEST I
        int[] a = new int[]{4, 26, 7, 19, 6, 28, 23, 54, 42, 64, 99};
        int oldKey = 54;
        int newKey = 105;
        Heap maxHeap = new Heap(a);
        System.out.println("Example: Suppose our binary heap object (bh) has the following keys");
        maxHeap.buildMaxHeap();
        maxHeap.printHeap();
        System.out.println("");

        System.out.println("method call: bh.replaceKey (new Integer(54), new Integer(105)");
        maxHeap.replaceKey(oldKey, newKey);
        maxHeap.printHeap();
        System.out.println("");

        System.out.println("If the oldKey does not exist in the heap, the\n"
                + "method prints an appropriate message and returns without changing the heap");
        maxHeap.replaceKey(oldKey, newKey);
    }
}
