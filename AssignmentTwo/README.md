<h3>Problem #1: (35 points)</h3><br>
In this problem, you will write some Java code for simple operations on binary search
trees where keys are integers. Assume you already have the following code and assume
that the method bodies, even though not shown, are correct and implement the operations
as we defined them in class.
public class BinarySearchTreeNode
{
public int key;
public BinarySearchTreeNode left;
public BinarySearchTreeNode right;
}
public class BinarySearchTree
{
private BinarySearchTreeNode root;
public void insert(int key) { ... }
public void delete(int key) { ... }
public boolean find(int key) { ... }
}
(a) Add a method public int keySum() to the BinarySearchTree class that returns the sum
of all the keys in the tree. You will need an assistant/helper method.
(b) Add method public void deleteMin() to the BinarySearchTree class that deletes the
minimum element in the tree (or does nothing if the tree has no elements).
c) Add method public void printTree() to the BinarySearchTree class that iterates over
the nodes to print then in increasing order. So the tree...

Produces the output "1 3 2 5 4".
Note: You will need an assistant/helper method.

<hr>

<h3>Problem #2: (35 points)</h3><br>
a) Show the result of inserting the following sequence of elements into an initially empty
AVL-tree: 10, 20, 15, 25, 30, 16, 18, 19.
b) Show the resulting AVL-tree, after physical deletion (NOT a lazy deletion) of the record
with the key 30 from the AVL tree that you got in the previous exercise.
c) Show the result when an initially empty AVL tree has keys 1 through 7 inserted in order.
d) Draw an AVL tree of height 4 that contains the minimum possible number of nodes.
<hr>

<h3>Problem #3: (30 point)</h3><br>
(a) Consider a binary min-heap. We have a method that print the keys as encountered in a
preorder traversal. Is the output sorted? Justify your answer. Attempt the same question
for inorder and postorder traversal.
(b) Propose an efficient algorithm (only pseudocode) to find all nodes less than some value
X in a binary min-heap. Analyze its complexity.
(c) Write (in Java) a method replaceKey in the MaxHeap class with the following
signature:
public void replaceKey(Integer oldKey, Integer newKey)
The method will replace the first occurrence of oldKey with the newKey, and restore
the Max-Heap property after the change. If the oldKey does not exist in the heap, the
method prints an appropriate message and returns without changing the heap.
Example: Suppose our binary heap object (bh) has the following keys:
*** 99 64 42 54 32 28 6 19 7 26 4
Then the method call: bh.replaceKey (new Integer(54), new Integer(105) should
change the keys to:
*** 105 99 42 64 32 28 6 19 7 26 4
Note: You can assume that the methods perlocateUp and perlocateDown are already
implemented in your MaxHeap class.
