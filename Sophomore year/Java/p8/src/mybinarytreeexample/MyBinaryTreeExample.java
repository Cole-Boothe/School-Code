/** @author Cole Boothe
 * C00558477
 * CMPS 261
 *
 * @version 11.0
 * @since 11/11/2025
 *
 * Program Description: This code is to examples using lazy deletion, searches, removing methods,
 * and breadth print all to show how Binary Trees work
 *
 * Certificate of Authenticity: I certify that the code in the method functions
 * including method function main of this project are
 * entirely my own work.
 */






        package mybinarytreeexample;

public class MyBinaryTreeExample {

    public static void main(String[] args) {
        MyBinaryTree<Integer> mbt = new MyBinaryTree();
        
        mbt.insert(4);
        mbt.insert(20);
        mbt.insert(1);
        mbt.insert(9);
        mbt.insert(3);
        mbt.insert(3);
        mbt.insert(7);
        mbt.insert(2);
        mbt.insert(-1);
        mbt.insert(19);
        mbt.insert(-5);
        mbt.insert(-2);
        mbt.insert(22);
        mbt.insert(15);
        mbt.insert(11);
        mbt.insert(0);
        
        mbt.inorder();
        mbt.preorder();
        mbt.postorder();
        
        System.out.println("\nIterator Example:");
        java.util.Iterator it = mbt.iterator();
        while(it.hasNext()) {
            System.out.printf("%3s", it.next());
        }
        System.out.println("\n");

        /** printing the elements added to tree in Breadth order */
        mbt.Breadthprint();

        /** Printing leaf nodes in the tree */
        System.out.println("\n\nPrint all the leafs");
        mbt.printleaves();
                
        System.out.println("\nDeleting Examples:");
        mbt.delete(4);        
        mbt.preorder();
        mbt.delete(-5);        
        mbt.preorder();
        mbt.delete(11);        
        mbt.preorder();
        mbt.delete(3);        
        mbt.preorder();
        mbt.delete(19);        
        mbt.preorder();
        mbt.delete(20);        
        mbt.preorder();
        mbt.delete(15);        
        mbt.preorder();
        mbt.delete(1);        
        mbt.preorder();
        mbt.delete(0);

        /** Searching for node 9 and printing true or false weather the methods find the given number */
        if(mbt.search(9)){
            System.out.println("\nTrue :)\n");
        }
        else{
            System.out.println("\nFalse :(\n");
        }

        mbt.preorder();
        mbt.delete(-1);        
        mbt.preorder();
        mbt.delete(1);        
        mbt.preorder();
        mbt.delete(-2);        
        mbt.preorder();
        mbt.delete(9);        
        mbt.preorder();

        /** Checking if the element 9 was there after being lazy deleted */
        if(mbt.search(9)){
            System.out.println("\nTrue :)\n");
        }
        else{
            System.out.println("\nFalse :(\n");
        }

        /** Printing everything within the tree to show a before and after from removing lazy deleted nodes */
        System.out.println("Printing all including lazy deleted");
        mbt.printall();

        /** deleting all marked with delete */
        mbt.removedeleted();

        /** Printing the tree nodes after removing all nodes marked as deleted */
        System.out.println("Printing after removing all marked with lazy delete");
        mbt.printall();

        System.out.println();
        mbt.delete(7);        
        mbt.preorder();
        mbt.delete(22);        
        mbt.preorder();
        mbt.delete(2);        
        mbt.preorder();
    }
    
}
