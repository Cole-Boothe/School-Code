// Cole Boothe
// Your ULID
// CMPS 261
//
//
// Program Description: This program is a simple text argument that uses the
// Stackclass class. the program will push, pop, and print the stacks
// generated from the class
//
//
// Certificate of Authenticity: I certify that the code in the method functions
// including method function main of this project are
// entirely my own work.





public class Main {
    public static void main(String[] args) {

        // spacing and creating the first stack making it default
        System.out.println();
        System.out.println("Creating stack class with defaults and printing empty stack: ");
        Stackclass stack1 = new Stackclass();

        // printing the stack to show it is currently empty
        stack1.print();

        // inserting numbers into the stack and purposefully adding extra to
        // show default is 5 and can detect when adding extra
        System.out.println("\npushing nums into the stack");
        for(int i = 1; i <= 7; i++){
            System.out.println("push num: " + (i+3));
            stack1.push(i + 3);

        }

        // printing stack
        System.out.println("\nPrinting Stack after pushing:");
        stack1.print();

        // popping the stack and going over to show it can detect when empty
        System.out.println("\n");
        for(int i = 0; i <= 7; i++){
            double num = stack1.pop();
            if(num == 0){
                System.out.println("can't pop because stack is empty");
            }
            else {
                System.out.println("getting pop num: " + num);
            }
        }

        // adding more numbers to stack to show it can be
        // added to even when empty
        System.out.println("\nPushing 16 and 20 into stack after popping till empty: ");
        stack1.push(16);
        stack1.push(20);
        stack1.print();

        // spacing
        System.out.println();
        System.out.println();

        // creating a new stack object that has a size of three
        System.out.println("Creating stack class with size 3 then attempting to add 4 numbers");
        Stackclass stack2 = new Stackclass(3);

        // inserting numbers into the second stack object and going over again
        // to show that the custom parameter works
        for(int i = 1; i <= 4; i++){
            System.out.println("Inserting num: " + (i+12));
            stack2.push(i + 12);
        }

        //printing what was added
        System.out.println("\nPrinting what was added");
        stack2.print();
        System.out.println();

    }
}