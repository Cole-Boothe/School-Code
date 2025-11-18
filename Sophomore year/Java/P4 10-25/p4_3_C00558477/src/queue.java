public class queue {

private double[] queuearray;

private int count;

private int rear;
private int front;

private int currentelecount;


    /** queue(default)
     *
     * A default constructor for the queue class
     */
public queue(){
    queuearray = new double[5];
    count = 5;
    rear=0;
    front=0;
    currentelecount = 0;
}

    /** queue(not default)
     *
     * A constructor for the queue class that takes a parameter that is the size of the array.
     */
public queue(int num){
    queuearray = new double[num];
    count = num;
    rear=0;
    front=0;
    currentelecount = 0;
}


    /** enqueue
     *
     * adds the parameter element to the rear position of the queue array
     *
     * Pre: the method receives the number that is to be inserted at the end
     *
     * Post: does not return anything but did add the number to the rear of the queue array
     *
     */
public void enqueue(double numinsert) {
    if (isFull()) {
        System.out.println("Can't enqueue (" + numinsert + ") because queue is full");
        return;
    }

    queuearray[rear] = numinsert;
    rear = (rear + 1) % count;
    currentelecount++;

}

    /** dequeue
     *
     * removes the first element of the queue array
     *
     * Pre: no parameter but it does check the this variables at the bottom
     *
     * Post: return the element that was removed from the front of the array
     *
     */

public double dequeue(){
    if(isEmpty()){
//        System.out.println("can't dequeue because queue is empty");
        return 0;

    }

    double returnamount = queuearray[front];
    front = (front +1 )&count;
    currentelecount--;
    return returnamount;
}


    /** isEmpty
     *
     * checks if the array list for the queue is empty
     *
     * Pre: no parameter but it does check the this variables at the top
     *
     * Post: a boolean true or false would be passed to say if the array list was empty
     *
     */
public boolean isEmpty(){
    if(currentelecount==0){
        return true;
    }
    else{
        return false;
    }
}

    /** isFull
     *
     * checks if the array list for the queue is full
     *
     * Pre: no parameter but it does check the this variables at the top
     *
     * Post: a boolean true or false would be passed to say if the array list was full
     *
     */

public boolean isFull(){
    if(currentelecount >= count){
        return true;
    }
    else{
        return false;
    }
}


    /** print
     *
     *
     *
     * prints the queue array list
     */
    public void print(){
        if(isEmpty()){
            System.out.println("Nothing to print");
        }
        else{
            for (int i = 0; i < currentelecount; i++) {
                int idx = (front + i) % count;
                System.out.print(queuearray[idx] + " ");
            }

        }
    }


}







