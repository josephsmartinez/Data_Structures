<h3>Problem #1: (15 points)</h3><br>
You have two sorted lists, L1 and L2. You know the lengths of each list, L1 has length N1 and L2
has length N2.<br>

(a) Design an efficient algorithm (only pseudocode) to output a sorted list L1 Ç L2 (the
intersection of L1 and L2).<br>

(b) If you know that N2 > N1. What is the running time complexity of your algorithm? Justify.

<hr>

<h3>Problem #2: (40 points)</h3><br>
(a) Given an array of integers numbers, write a program in Java to find the stability index in it.
For an array A consisting n integers elements, index i is a stability index in A if
A[0] + A[1] + ... + A[i-1] = A[i+1] + A[i+2] + ... + A[n-1]; where 0 < i < n-1.
Similarly, 0 is an stability index if (A[1] + A[2] + ... + A[n-1]) = 0 and n-1 is an stability index
if (A[0] + A[1] + ... + A[n-2]) = 0
Example: Consider example, consider the array A = {0, -3, 5, -4, -2, 3, 1, 0}. The stability
index found at index 0, 3 and 7.<br>

(b) What is the running time complexity of your program? Justify.

<hr>

<h3>Problem #3: (45 points: 25 + 15 + 5)</h3><br>
(a) Write a program in Java to implement a recursive search function
public static int terSearch(int A[], int l, int r, int x)
that returns location of x in a given sorted array A[l…r] is present, otherwise -1.
The terSearch search function, unlike the binary search, must consider two dividing
points
int d1 = l + (r - l)/3
int d2 = d1 + (r - l)/3<br>

(b) Write a program in Java to implement an efficient function
public static long exponentiation(long x, int n)
to calculate x
n
<br>
Please note that in your function you can use only the basic arithmetic operators (+, -,
*, %, and /).
(b.2) What is the running time complexity of your function? Justify.
