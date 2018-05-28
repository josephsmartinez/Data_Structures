/*********************************************************************
Purpose/Description: You have two sorted lists, L1 and L2. You know the lengths 
*                    of each list, L1 has length N1 and L2 has length N2
Author’s Panther ID: 3816842
Certification:
I hereby certify that this work is my own and none of it is the work of
any other person.
********************************************************************/
package datastructureshomework;
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author Joseph
 */
public class IntersectionOf_TwoList {
    /**
     * This method will take two list and find the intersection between both.
     * The Complexity time for this function if O(n) given the size of the list.
     * @param list1 a list
     * @param list2 a list
     */
    static void intersection(int[] list1, int[] list2) {
        int i = 0, j = 0;
        while (i < list1.length && j < list2.length) {
            if (list1[i] < list2[j]) {
                i++;
            } else if (list2[j] < list1[i]) {
                j++;
            } else {
                System.out.println("Intersection FOUND!:" + list2[j]);
                j++;
            }
        }
    }
    /**
     * Method prints list
     * @param list a list of integers
     */
    static void printList(int[] list){
         for (int i : list) {
            System.out.print(i + " ");
        }
    }
    /**
     * Main method will unit test with random list and random numbers
     * @param args 
     */
    public static void main(String[] args) {
        // UNIT TESTING / CREATING RANDOM LIST AND RANDOM NUMBERS
        // Create two randomly sized list that have random numbers sorted. 
        Random random = new Random();
        int random_size1 = random.nextInt(10) + 5;
        int random_size2 = random.nextInt(10) + 5;
        int[] list1 = new int[random_size1];
        int[] list2 = new int[random_size2];
        
        // Printing list
        for (int i = 0; i < list1.length; i++) {
            list1[i] = random.nextInt(20) + 5;
        }

        for (int i = 0; i < list2.length; i++) {
            list2[i] = random.nextInt(20) + 10;
        }
        //Sorting List
        Arrays.sort(list1);
        Arrays.sort(list2);

        System.out.println("List One");
        printList(list1);
        System.out.println("\nList Two");
        printList(list2);
        //Print Results
        System.out.println("");
        System.out.println("The L1 ∩ L2 is: ");
        intersection(list1, list2);
    }

}
