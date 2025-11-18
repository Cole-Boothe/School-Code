// Cole Boothe
// C00558477
// CMPS 261
//
// Program Description: description of actions of code
// Certificate of Authenticity: I certify that the code in the method functions including
// method function main of this project are entirely my own work.


import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        // Creating linked list for listmethod
        LinkedList<Integer> intlist = new LinkedList<Integer>();

        //print statements for time (ms) and listmethod trigger
        System.out.println("\nTime it took to generate the list of 5 million integers in a linked list: ");
        listmethod(intlist);
        System.out.println("(ms)");


        //print statements for the equations and triggering postfix method
        System.out.println("\nInputing postfix operations and calulating them using a stack: ");
        System.out.println("2 3 + = " + Postfix("2 3 +"));
        System.out.println("5.0 3.5 - 1.2 / = " + Postfix("5.0 3.5 - 1.2 /"));
        System.out.println("5.0 3.5 1.2 - / = " + Postfix("5.0 3.5 1.2 - /"));

    }




    /* listmethod
     *
     * Takes intlist in the parameter and adds a random number 5,000,000 times to the linked list.
     * The time it takes to add all these numbers is calculated in milliseconds(ms) and then the time is displayed.
     *
     *
     * Pre: the parameter given is the linked list that is to have 5,000,000 integers added to it
     *
     *
     *
     * Post: the method is void but the given linked list has had 5,000,000 integers
     * added and the time it took to add the numbers was measured in milliseconds(ms) and printed on screen
     *
     *
     */
    public static void listmethod(LinkedList<Integer> intlist){

        //initializing variables
        long starttime, endtime, totaltime;
        Random numgen = new Random();

        //starting timer
        starttime = System.currentTimeMillis();

        //for loop creating and assigning the 5,000,000 variables
        for (int i = 0; i < 4999999; i++) {
            intlist.add(numgen.nextInt());
        }

        // ending timer
        endtime = System.currentTimeMillis();

        // total time (ms)
        totaltime =endtime - starttime;

        //print time (ms)
        System.out.print(totaltime);
        System.gc();
    }



    /* Postfix
     *
     * Takes the String given in the parameter that is a postfix calculation.
     * The method then takes each section of the string using split(" ") and then goes
     * into a for loop calculating each operator sign and pops and pushes the variables
     * and answers into the stack.
     *
     *
     * Pre: This method takes a string parameter of the equation then separates it using split(" ")
     * to get each section of the equation
     *
     *
     * Post: Postfix will return the answer as the last pop from the stack because the
     * last pop will be the answer of the given equation
     *
     *
     *
     */
    public static double Postfix(String input) {
        // stack and string array creation
        Stack<Double> stack = new Stack<>();
        String[] Spots = input.split(" ");

        //for each loop to evaluate each spot of the array
        for (String Spot : Spots) {

            // if statement checking for operators
            if (Spot.equals("-") || Spot.equals("*") || Spot.equals("/") || Spot.equals("+")){

                //popping a and b for calculations
                double b = stack.pop();
                double a = stack.pop();
                double Answer = 0;


                // if statements for which operation to do
                switch (Spot) {
                    case "+":  Answer = a + b; break;
                    case "-":
                        Answer = a - b;
                        break;
                    case "*":
                        Answer = a * b;
                        break;
                    default:
                        Answer = a / b;
                        break;
                }
                stack.push(Answer);
            }

            // Pushing leftover into the stack
            else {
                stack.push(Double.parseDouble(Spot));
            }
        }

        // Popping the answer from the stack then returning it
        return stack.pop();

    }

}