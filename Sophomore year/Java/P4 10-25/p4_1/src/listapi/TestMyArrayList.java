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

import java.util.Iterator;

/**
 * @author Y. Daniel Liang
 */
public class TestMyArrayList {

    public TestMyArrayList() {
        // Create a list
        MyList<String> list = new MyArrayList<>();

        // Add elements to the list
        list.add("America"); // Add it to the list
        System.out.println("(1) " + list);

        list.add(0, "Canada"); // Add it to the beginning of the list
        System.out.println("(2) " + list);

        list.add("Russia"); // Add it to the end of the list
        System.out.println("(3) " + list);

        list.add("France"); // Add it to the end of the list
        System.out.println("(4) " + list);

        list.add(2, "Germany"); // Add it to the list at index 2
        System.out.println("(5) " + list);

        list.add(5, "Norway"); // Add it to the list at index 5
        System.out.println("(6) " + list);

        // Remove elements from the list
        list.remove("Canada"); // Same as list.remove(0) in this case
        System.out.println("(7) " + list);

        list.remove(2); // Remove the element at index 2
        System.out.println("(8) " + list);

        list.remove(list.size() - 1); // Remove the last element
        System.out.print("(9) " + list + "\n(10) ");

        for (String s : list) {
            System.out.print(s.toUpperCase() + " ");
        }

        //creating a new list to add
        MyList<String> otherlist = new MyArrayList<>();

        // populating the list
        otherlist.add("Norway");
        otherlist.add("France");
        otherlist.add("Russia");
        System.out.println("\n");

        //Adding the list
        boolean changed = list.addALL(otherlist);

        //creating iterator for the while loop
        Iterator<String> iterator = list.iterator();

        //While loop for printing iterator
        System.out.println("Print of list after being fully added:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //if statement that prints if there were any changes
        if(changed){
            System.out.println();
            System.out.println("the list was changed and returned true");
        }
        else{
            System.out.println();
            System.out.println("the list was not changed and returned false");
        }


        //removing elements from the list to show adding an empty list
        otherlist.remove(0);
        otherlist.remove(0);
        otherlist.remove(0);

        //getting the new boolean
        changed = list.addALL(otherlist);

        //printing the statement when nothing changes.
        if(changed){
            System.out.println();
            System.out.println("the list was changed and returned true");
        }
        else{
            System.out.println();
            System.out.println("the list was not changed and returned false");
        }



    }
}
