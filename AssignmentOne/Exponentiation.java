/*********************************************************************
Purpose/Description: Write a program in Java to implement an efficient function.
Author’s Panther ID: 3816842
Certification:
I hereby certify that this work is my own and none of it is the work of
any other person.
********************************************************************/
package datastructureshomework;
/**
 * @author Joseph
 */
public class Exponentiation {
    /**
     * This recursive function will calculate the number by an exponent b^x
     * The Complexity time for this function if O(n)
     * @param b can be many number within integers
     * @param x must be >= 0
     * @return results
     */
    public static long exponentiation(long b, int x){
        if(x < 1){
            return 1;
        }else
            return b * exponentiation(b, x-1);
    }
    
    public static void test(int base, int power){
        long answer = exponentiation(base, power);
        System.out.println(base + "^" + power + " = " + answer);
    }
    /**
     * This method will calculate number raised by an exponent, if and only if, 
     * the exponent >= 0;
     * @param args 
     */
    public static void main(String[] args) {  
        //UNIT TESTING / TEST CASES
        test(10, 10);
        test(5, 5);
        test(1, 1000);
        test(-3, 2);
    }
}
