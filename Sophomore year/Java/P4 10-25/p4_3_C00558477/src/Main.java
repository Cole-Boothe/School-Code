// Cole Boothe
// Your ULID
// CMPS 261
//
//
// Program Description: This program is a simple text argument that uses the
// queue class. the program will enqueue, dequeue, and print the queues
// generated from the class
//
//
// Certificate of Authenticity: I certify that the code in the method functions
// including method function main of this project are
// entirely my own work.







public class Main {
    public static void main(String[] args) {

        //Prints explaining the creation of the array
        System.out.println();
        System.out.println("Creating queue class with size 7\n");
        //creating the queue object
        queue queue1 = new queue(7);

        //printing the empty object
        System.out.println("Printing empty queue:");
        queue1.print();


        //enqueuing more numbers than size of array to show the error
        System.out.println("\nenqueuing nums into the queue");
        for(int i = 1; i <= 8; i++){
            System.out.println("enqueuing num: " + (i+3));
            queue1.enqueue(i + 3);
        }

        //showing the added elements to the array
        System.out.println("\nPrinting queue after enqueuing");
        queue1.print();

        //dequeuing more than what's in the array to show the error
        System.out.println("\n\ndequeueing more than what's in the queue:");
        for(int i = 0; i <= 7; i++){
            double num = queue1.dequeue();

            // if statement for if the number goes over the amount in the stack
            if(num == 0){
                System.out.println("can't dequeue anymore because queue is empty");
            }
            else {
                System.out.println("getting dequeue num: " + num);
            }
        }

        //printing the empty array
        System.out.println("\nPrinting after dequeue: ");
        queue1.print();


        // adding numbers after dequeueing
        System.out.println();
        System.out.println("enqueuing num: " + (3));
        queue1.enqueue(3);
        queue1.print();


        //making and adding new elements to a new object
        System.out.println("\n\nMaking a queue with defaults and enqueuing some numbers:");
        queue queue2 = new queue();
        for(int i = 1; i <= 5; i++){
            System.out.println("enqueuing num: " + (i+12));
            queue2.enqueue(i + 12);
        }

        //printing the new object after enqueuing
        System.out.println("\nPrinting default queue:");
        queue2.print();
        System.out.println();

    }


}