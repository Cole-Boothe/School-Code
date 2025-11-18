// Cole Boothe
// Your ULID
// CMPS 261
//
//
// Program Description: added the addALL method to the program and added
// text to display method in the "TestMyArrayLisy.java" file.
//
//
// Certificate of Authenticity: I certify that the code in the method functions
// including method function main of this project are
// entirely my own work.







package listapi;

/**@author Y. Daniel Liang*/
public abstract class MyAbstractList<E> implements MyList<E> {

    protected int size = 0; // The size of the list

    /**Create a default list*/
    protected MyAbstractList() {
    }

    /**Create a list from an array of objects*/
    protected MyAbstractList(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    @Override
    /**Add a new element at the end of this list*/
    public void add(E e) {
        add(size, e);
    }

    @Override
    /**Return true if this list contains no elements*/
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    /**Return the number of elements in this list*/
    public int size() {
        return size;
    }

    @Override
    /**Remove the first occurrence of the element e from this list. Shift any
     * subsequent elements to the left. Return true if the element is removed.
     */
    public boolean remove(E e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        } else {
            return false;
        }
    }


    /** addALL
     *
     * Adds all the elements from the list inside the parameter into the this list.
     * returns a boolean to say if there was changes.
     *
     * Pre: The array passed is populated and will be added.
     *
     * Post: the parameter list has been added to the this list and returned a
     * boolean variable.
     *
     *
     */
    @Override
    public boolean addALL(MyList<E> otherList) {
        if(otherList.isEmpty()){
            return false;
        }
        else {
            for (int i = 0; i < otherList.size(); i++) {
                this.add(otherList.get(i));
            }
            return true;
        }
    }
}
