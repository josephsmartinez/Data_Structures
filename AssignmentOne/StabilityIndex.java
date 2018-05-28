/*********************************************************************
Purpose/Description: Given an array of integers numbers, write a program 
                     in Java to find the stability index in it.
Author’s Panther ID: 3816842
Certification:
I hereby certify that this work is my own and none of it is the work of
any other person.
********************************************************************/
package datastructureshomework;

import java.util.ArrayList;
/**
 *
 * @author Joseph
 */
public class StabilityIndex {
    
    /**
     * Time Complexity for the method is N + N = O(n) 
     * @param list  Excepts an array[] of integers.
     * @return      Return an ArrayList of found stability index(s).
     */
    static ArrayList<Integer> stability_index(int[] list){
        // Store Stability index(s)
        ArrayList<Integer> stabilityList = new ArrayList<>();
        
        // Sum the right side of the array from A[1] - A[n-1] O(n)
        int sum_right =0; 
        for (int i = 1; i < list.length; i++) {
            sum_right += list[i];
        }
        //Check if the sum from A[1] - A[n-1] is equal to zero
        if(sum_right == 0){
            stabilityList.add(sum_right);
        }
            
        // Similarly, 0 is an stability index if... 
        // (A[1] + A[2] + ... + A[n-1]) = 0 and n-1 is an stability index if...
        // (A[0] + A[1] + ... + A[n-2]) = 0
        // O(n)
        int right = sum_right; int left = 0;
        for (int i = 0; i < list.length - 1; i++) {
            
            int point = i;
            int lead = point +1;
            
            // Start at the second index and continue until the length
            // This side will shrink unit n-2 
            right -= (list[lead]);
            
            // Start at the first index and grow
            // This side will grow unil n-1
            left += list[point];
            
            //If right and left are equal then stability index found
            if(right == left){
                stabilityList.add(lead);
            }   
        }
        return stabilityList;
    }
    
    static void print(ArrayList<Integer> list){
        list.forEach((integer) -> {
            System.out.println("Stability Index is: " + integer);
        });
        System.out.println("---------------------------\n");
    }
    
    public static void main(String[] args) {
        //UNIT TESTING / TEST CASES
        int[] list = {0, -3, 5, -4, -2, 3, 1, 0};
        //Stability Index is:  0
        //Stability Index is:  3
        //Stability Index is:  7
        
        int[] list1 = {0, 1, -1, 2, -2, 1, -1, 0};
        //Stability Index is:  0
        //Stability Index is:  7
        
        int[] list2 = {10, 2, 3, 4, 3};
        //Stability Index is:  1
        
        int[] list3 = {0, -2, -3, 2, 3, 2, 3, -2, -3, 0};
        //Stability Index is:  0
        //Stability Index is:  9
        
        System.out.println("L1: {0, -3, 5, -4, -2, 3, 1, 0}");
        print(stability_index(list));
        System.out.println("L2: {0, 1, -1, 2, -2, 1, -1, 0}");
        print(stability_index(list1));
        System.out.println("L3: {10, 2, 3, 4, 3}");
        print(stability_index(list2));
        System.out.println("L4: {0, -2, -3, 2, 3, 2, 3, -2, -3, 0}");
        print(stability_index(list3));
        }
    }

