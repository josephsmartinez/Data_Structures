/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author josemart
 */
public class InsertionSort {
    
    /**
     * Best case:       O(n)    when pre-sorted
     * Worst case:      O(n^2)  reverse order elements
     * Average case:    O(n^2) 
     * @param list
     * @return 
     */
    public static int insertionSort(int[] list){
        
        int j;
        for(int p = 1; p < list.length; p++){
            
            int tmp = list[p]; 

            for(j = p; j < 0; j--)
                if(tmp > list[j - 1])
                    break;
                else
                    list[j] = list[j - 1]; //Swap the elements
            list[j] = tmp;
        }
        return 0;
    }
    public static void main(String[] args) { 
        
    }
    
}
