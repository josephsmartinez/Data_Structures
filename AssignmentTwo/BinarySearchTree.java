/** *******************************************************************
 * Purpose/Description:
 * In this problem, you will write some Java code for simple operations on binary search
 * trees where keys are integers.
 *
 * Author’s Panther ID: 3816842
 *
 * Certification:
 * I hereby certify that this work is my own and none of it is the work of
 * any other person
 *
 * (a) Add a method public int keySum() to the BinarySearchTree class that returns the sum
 * of all the keys in the tree. You will need an assistant/helper method.
 *
 * (b) Add method public void deleteMin() to the BinarySearchTree class that deletes the
 * minimum element in the tree (or does nothing if the tree has no elements).
 *
 * (c) Add method public void printTree() to the BinarySearchTree class that iterates over
 * the nodes to print then in increasing order. So the tree...
 *
 * Author’s Panther ID: 3816842
 * Certification:
 * I hereby certify that this work is my own and none of it is the work of
 * any other person.
 *
 * Resources for this project:
 * Data Structures by Mark Allen
 * - http://users.cis.fiu.edu/~weiss/cop3530_sum09/Day13.java
 * Carnegie Mellon’s School of Computer Science
 * - https://www.cs.cmu.edu/~adamchik/15-121/lectures/Recursions/recursions.html
 * Design and Implementation of the Interface
 * - https://www.sqa.org.uk/e-learning/LinkedDS04CD/page_18.htm
 ******************************************************************* */
package tree;

/**
 *
 * @author Joseph S Martinez
 */
public class BinarySearchTree {

    //Class variables
    Node root;
    private int theSize;
    private static int sumOfNodes = 0;

    /**
     * Constructor for the Binary Search Tree Sets the root to null, and the
     * size to zero
     */
    public BinarySearchTree() {
        root = null;
        theSize = 0;
    }

    /**
     * This addNode method uses a iterative loop to traverse the BST
     *
     * @param key is the element to be add into the BST.
     */
    public void addNode(int key) {
        //Create a new Node and initialize it
        Node newNode = new Node(key);
        //If the tree is empty new node becomes root
        if (root == null) {
            root = newNode;
        } else {
            //Set root as the Node we will compare with
            Node currentNode = root;
            //Parent will be reassigned as we move down the tree
            Node parent;
            //We will start moving down the tree to find a position for newNode
            while (true) {
                //Start with root
                parent = currentNode;
                //Check the condition Left-Tree < Root < Right-Tree
                //If the key is less than the root, we continue on the left-side
                if (key < currentNode.key) {
                    //Set the currentNode to the next leftNode
                    currentNode = currentNode.leftNode;
                    //Check if the left-next node is null
                    if (currentNode == null) {
                        //If so, the newNode is now the left-child
                        parent.leftNode = newNode;
                        theSize++;
                        return;//Exit
                    }
                } else { //If the key is grater than the root, we continue on the right-side
                    //Set the currentNode to the next rightNode
                    currentNode = currentNode.rightNode;
                    //Check if the right-next node is null
                    if (currentNode == null) {
                        //If so, the newNode is now the right-child
                        parent.rightNode = newNode;
                        theSize++;
                        return; //Exit
                    }
                }
            }
        }
    }//end add method

    /**
     * This recursive method will print the tree elements in a "In Order
     * Traversal".
     *
     * @param node starts with root and continues to be resigned as we continue
     * down the tree
     */
    public void printTree(Node node) {
        if (node != null) {
            //Traverse the left node
            printTree(node.leftNode);
            //Print the current node
            System.out.print(node + " ");
            //Traverse the right node
            printTree(node.rightNode);
        }
    }

    /**
     * This recursive method will print the tree elements in a "Post Order
     * Traversal".
     *
     * @param node starts with root and continues to be resigned as we continue
     * down the tree
     */
    public void postOrderTraverseTree(Node node) {
        if (node != null) {
            //Traverse the left most side first
            postOrderTraverseTree(node.leftNode);
            //One the left-most-side find the right child
            postOrderTraverseTree(node.rightNode);
            System.out.print(node + " ");
        }
    }

    /**
     * This class method is a recursive method that sums all the key values
     * within the tree structure.
     *
     * @param node
     */
    private static void sum(Node node) {
        if (node != null) {
            sum(node.leftNode);
            sumOfNodes += node.key;
            sum(node.rightNode);
        }
    }

    /**
     * Returns the total of the calculated keys within the BST
     *
     * @return an integer value of the sum of key (int) within the BST
     */
    public int keySum() {
        sumOfNodes = 0;
        sum(root);
        return sumOfNodes;
    }

    /**
     * Method will remove the minimum value within the tree. 
     * @Mark Allen Data Structures  PG 117 (FindMin) & 120(Removal)
     * 
     * If the number of deletions is expected to be small, then a popular strategy to use is
     * lazy deletion: When an element is to be deleted, it is left in the tree and merely marked
     * 
     * If the number of real nodes in the tree is the same as the number of “deleted” nodes, then the depth of
     * the tree is only expected to go up by a small constant, so there is a very small time
     * penalty associated with lazy deletion. Also, if a deleted item is reinserted, the overhead of
     * allocating a new cell is avoided.
     * 
     * @param node is the root value, then continues until the smallest value
     * found in the BST
     * @return the next left-node
     */
    private Node deleteMin(Node node) {
        //Base Case
        if (node.leftNode == null) {
            theSize--;
            return node.rightNode;
        }
        //Assign the node the value found at the furtest left side of the tree. 
        node.leftNode = deleteMin(node.leftNode);
        return node;
    }

    /**
     * Resets the Binary Search Tree
     */
    public void clear() {
        theSize = 0;
        root = null;
    }

    //INNER NODE CLASS
    public class Node {

        int key;
        Node leftNode;
        Node rightNode;

        /**
         * Inner Class Constructor
         *
         * @param key is an integer value
         */
        Node(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return Integer.toString(key);
        }
           public int minValue() {
            if (leftNode == null)
                  return key;
            else
                  return leftNode.minValue();

      }
    }//end inner class

    public static void main(String[] args) {

        //UNIT TESTING I
        BinarySearchTree bst = new BinarySearchTree();
        //Full the tree with numbers 
        bst.addNode(7);
        bst.addNode(3);
        bst.addNode(4);
        bst.addNode(5);
        bst.addNode(8);
        bst.addNode(2);
        bst.addNode(1);
        bst.addNode(6);
        bst.addNode(9);
        
       // System.out.println(bst.root.minValue());

        //Print tree
        System.out.println("Printing the BST");
        bst.printTree(bst.root);
        System.out.println("");

        //Sum the values within the tree using the keySum methods
        System.out.println("Three sum is: " + bst.keySum());
      //  System.out.println("Three sum is: " + bst.keySum());

        //Remove the minimum value withing the tree. 
        System.out.println("Removing the Minimum value in the tree:");
        bst.deleteMin(bst.root);

        //Re-print the BST for Proof
        bst.printTree(bst.root);
        System.out.println("");

        //Reset Tree
        bst.clear();

        //UNIT TESTING II
        //Add new elements
        bst.addNode(4);
        bst.addNode(2);
        bst.addNode(1);
        bst.addNode(3);
        bst.addNode(5);

        //Printing post-order traversal 
        System.out.println("Printing the post order traversal");
        bst.postOrderTraverseTree(bst.root);
        System.out.println("");

    }//end main
}//end class
