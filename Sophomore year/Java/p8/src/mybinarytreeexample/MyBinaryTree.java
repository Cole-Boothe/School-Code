package mybinarytreeexample;

import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryTree<E extends Comparable<E>> {

    private Node<E> root = null;

    public class Node<E> {

        public E e = null;
        public Node<E> left = null;
        public Node<E> right = null;
        public boolean deleted = false;
    }

    public boolean insert(E e) {
        // if empty tree, insert a new node as the root node
        // and assign the elementy to it
        if (root == null) {
            root = new Node();
            root.e = e;
            return true;
        }

        // otherwise, binary search until a null child pointer 
        // is found
        Node<E> parent = null;
        Node<E> child = root;

        while (child != null) {
            if (e.compareTo(child.e) < 0) {
                parent = child;
                child = child.left;
            } else if (e.compareTo(child.e) > 0) {
                parent = child;
                child = child.right;
            } else {
                return false;
            }
        }

        // if e < parent.e create a new node, link it to 
        // the binary tree and assign the element to it
        if (e.compareTo(parent.e) < 0) {
            parent.left = new Node();
            parent.left.e = e;
        } else {
            parent.right = new Node();
            parent.right.e = e;
        }
        return true;
    }

    public void inorder() {
        System.out.print("inorder:   ");
        inorder(root);
        System.out.println();
    }

    private void inorder(Node<E> current) {
        if (current != null) {
            inorder(current.left);
            if (!current.deleted) {
                System.out.printf("%3s", current.e);
            }
            inorder(current.right);
        }
    }

    public void preorder() {
        System.out.print("preorder:  ");
        preorder(root);
        System.out.println();
    }

    private void preorder(Node<E> current) {
        if (current != null) {
            if (!current.deleted) {
                System.out.printf("%3s", current.e);
            }
            preorder(current.left);
            preorder(current.right);
        }
    }

    public void postorder() {
        System.out.print("postorder: ");
        postorder(root);
        System.out.println();
    }

    private void postorder(Node<E> current) {

        if (current != null) {
            postorder(current.left);
            postorder(current.right);
            if (!current.deleted) {
                System.out.printf("%3s", current.e);
            }
        }
    }


    /**
     * delete
     *
     * This method removes the given number from the tree
     *
     * @param e receives the number to remove from the tree
     *
     * @return returns a boolean true or false say if the
     * node was found or not
     *
     * */
    public boolean delete(E e) {

        Node<E> child = root;

        /** while the current node isn't null the while loop
         *  will go through and mark the given node as deleted
         *
         */
        while (child != null) {

            // moves down the tree
            if (e.compareTo(child.e) < 0) {
                child = child.left;
            }
            else if (e.compareTo(child.e) > 0) {
                child = child.right;
            }
            // when node is found it will mark it deleted
            else {
                if (!child.deleted) {
                    child.deleted = true;
                    return true;
                } else {
                    return false;
                }
            }
        }


        //return false if it couldn't be found
        return false;

    }


    /**
     * search
     *
     * This method finds the given number in the tree
     *
     * @param e receives the number to find in the tree
     *
     * @return returns a boolean true or false say if the
     * node was found or not
     *
     * */
    public boolean search(E e) {
        Node<E> current = root;

        // while loops through the tree
        while (current != null) {
            // goes left or right child until found
            if (e.compareTo(current.e) < 0) {
                current = current.left;
            }
            else if (e.compareTo(current.e) > 0) {
                current = current.right;
            }
            //returns true or false is the node is deleted
            else {
                return !current.deleted;
            }
        }

        //returns false if it couldn't be found
        return false;
    }

    /**
     * removedeleted
     *
     * This method removes the given number from the tree
     *
     * does not receive anything but does remove any marked
     * nodes from the tree using its helper method
     *
     * this method return nothing but the tree that is still
     * being used has less nodes
     *
     *
     * */

    public void removedeleted() {
        // makes a temporary tree and sends it to helper method
        MyBinaryTree<E> temptree = new MyBinaryTree<>();
        removedeletedhelper(root, temptree);

        //replaces tree with temp tree
        this.root = temptree.root;


    }

    /**
     * removedeletedhelper
     *
     * This method removes the given number from the tree using a temporary tree
     *
     * @param node, temptree are given to the method so it can add
     *             the nodes that aren't marked to the temporary tree (temptree).
     *
     * this method doesn't return anything but the temp tree does replace the actual
     * tree in the method it's helping
     *
     *
     * */
    private void removedeletedhelper(Node<E> node, MyBinaryTree<E> temptree) {

        //return if the node is null
        if (node == null) {
            return;
        }

        // if the node is not deleted then the node is added to the temp array
        if (!node.deleted) {
            temptree.insert(node.e);
        }

        //goes through left and right child
        removedeletedhelper(node.left, temptree);
        removedeletedhelper(node.right, temptree);
    }

    /**
     * printall
     *
     * This method does not receive anything but does
     * use the current tree to print every node
     *
     * this method doesn't return anything but does print the "Print all: " at the start of the printing
     *
     *
     * */
    public void printall() {
        //prints everything
        System.out.print("Print all:  ");
        printall(root);
        System.out.println();
    }
    /**
     * printall
     *
     * this is the print all helper and the methods are in a helper format because
     * the order printing methods were the inspiration
     *
     * @param current receives the node called current and prints it if not null
     *
     * method is void but does recursively send back the next node to method its helping
     *
     *
     * */

    private void printall(Node<E> current) {
        //helper method that prints everything in the preorder order
        if (current != null) {
            System.out.printf("%3s", current.e);
            printall(current.left);
            printall(current.right);
        }
    }


    /**
     * printleaves
     *
     * This method prints all the leaves in the tree
     *
     * does not receive anything but does print any node deemed as a leaf
     *
     * this method returns nothing but does recursively call on helper method
     *
     *
     * */
    public void printleaves() {
        //prints the leaves
        System.out.print("Print leaves:  ");
        printleaves(root);
        System.out.println();
    }

    /**
     * printleaves
     *
     * This method is the helper method that prints the leaves of the tree
     *
     * @param current receives current as the current node and prints if it is a leaf.
     *
     * this method returns nothing but does recursively call on itself to print leaves
     *
     *
     * */
    private void printleaves(Node<E> current) {
        if (current != null) {
            // checks if the node is a leaf then prints
            if (current.left == null && current.right == null) {
                System.out.printf("%3s", current.e);

            }
            //goes through the left and right children
            printleaves(current.left);
            printleaves(current.right);
        }
    }

    /**
     * Breadthprint
     *
     * This method prints all the nodes in the tree in Breadth order
     *
     * does not receive anything but does make a temporary queue to print in breadth order
     *
     * this method is void but does print all the tree nodes in breadth order
     *
     *
     * */

    public void Breadthprint() {
        //prints Breadth
        System.out.print("Print Breadth:  ");
        System.out.println();

        //makes temp queue
        Queue<MyBinaryTree.Node> tempq = new LinkedList<>();

        //enqueues the root
        tempq.add(root);

        //loops through the queue until empty
        while (!tempq.isEmpty()) {
            MyBinaryTree.Node current = tempq.remove();

            if (!current.deleted) {
                System.out.print(" " + current.e);
            }

            // adds left child when not empty
            if (current.left != null) {
                tempq.add(current.left);
            }
            // adds right child when not empty
            if (current.right != null) {
                tempq.add(current.right);
            }

        }
    }









    
    
    // an iterator allows elements to be modified, but can mess with
    // the order if element not written with immutable key; it is better
    // to use delete to remove and delete/insert to remove or replace a
    // node
    public java.util.Iterator<E> iterator() {
        return new PreorderIterator();
    }
    
    private class PreorderIterator implements java.util.Iterator<E> {
        
        private java.util.LinkedList<E> ll = new java.util.LinkedList();
        private java.util.Iterator<E> pit= null;
        
        // create a LinkedList object that uses a linked list of nodes that
        // contain references to the elements of the nodes of the binary tree 
        // in preorder
        public PreorderIterator() {
            buildListInPreorder(root);
            pit = ll.iterator();
        }
        
        private void buildListInPreorder(Node<E> current) {
            if (current != null) {
                ll.add(current.e);
                buildListInPreorder(current.left);
                buildListInPreorder(current.right);
            }
        }

        
        // check to see if their is another node in the LinkedList
        @Override
        public boolean hasNext() {
            return pit.hasNext();
        }

        // reference the next node in the LinkedList and return a 
        // reference to the element in the node of the binary tree
        @Override
        public E next() {
            return pit.next();
        }

        @Override
        public void remove() { 
            throw new UnsupportedOperationException("NO!");
        }
    }
}
