public class Stackclass<E> {

private double[] stackarray;
private int count;
private int top;

    /** Stackclass(default)
     *
     * A default constructor for the Stackclass class
     */

public Stackclass(){
    stackarray = new double[5];
    count = 5;
    top = 0;
}

    /** Stackclass(not default)
     *
     * A constructor for the Stackclass class that takes a parameter that is the size of the array.
     */
public Stackclass(int num){
    stackarray = new double[num];
    count = num;
    top = 0;
}


    /** isEmpty
     *
     * checks if the array list for the stackclass is empty
     *
     * Pre: no parameter but it does check the this variables at the top
     *
     * Post: a boolean true or false would be passed to say if the array list was empty
     *
     */
public boolean isEmpty(){

    if(top == 0){
        return true;
    }
    else{
        return false;
    }
}

    /** isFull
     *
     * checks if the array list for the stackclass is full
     *
     * Pre: no parameter but it does check the this variables at the top
     *
     * Post: a boolean true or false would be passed to say if the array list was full
     *
     */
public boolean isFull(){
    if(top >= count){
        return true;
    }
    else{
        return false;
    }
}



    /** push
     *
     * will add the parameter value into the stack array list
     *
     * Pre: takes a double number and will add the received number into the stack array
     *
     * Post: doesn't return anything but has added the value to the stack array list
     *
     */
public void push(double numadd){
    if(isFull()){
        System.out.println("Can't push (" + numadd + ") because stack is full");
        return;
    }
    if(top<0){
        top++;
    }
    stackarray[top] = numadd;
    top++;
}


    /** pop
     *
     * will remove the element that is on the top of the list from the array
     *
     * Pre: does not take a parameter but automatically takes the top variable
     *
     * Post: doesn't return anything but has removed the top element from the stack array
     *
     */
public double pop(){
    if(top >= 0){
        return stackarray[top--];
    }
        return 0;
}


    /** print
     *
     *
     * prints the stack array list
     */
    public void print(){
    if(isEmpty()){
        System.out.println("Nothing to print");
    }
        else{
        top--;
        for (int i = top; i >= 0; i--) {
            System.out.print(stackarray[i] + " ");
        }

    }
}


}
