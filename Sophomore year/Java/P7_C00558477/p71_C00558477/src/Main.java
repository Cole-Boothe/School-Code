//
//
//  @author Cole Boothe C00558477
//  @version 11.0
//  @since 2025-11-2
//  CMPS 261
//
//  Program Description: This project is to demonstrate using a set then read
//  from a file and print them out in ascending order
//
//  Certificate of Authenticity: I certify that the code in the method functions
//  including method function main of this project are entirely my own work.
//
//


/**
 * @author Cole Boothe
 * @version 11.0
 *
 * */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {


        /** initiating the TreeSet */
        TreeSet<String> tset = null;

        /** Try Catch to read from file */
        try {

            /** initiating Scanner and HashSet for reading */
            Scanner scanner = new Scanner(new File("fstein.txt"));
            Set<String> set = new HashSet<>();

            /** while loop to read each line */
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                set.add(line.replaceAll("\\p{Punct}", ""));
            }

            /** closing the scanner and sorting the HashSet into a TreeSet */
            scanner.close();
            tset = new TreeSet<>(set);
        }

        /** Catch if it could not find the file */
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }


        /** printing the TreeSet */
        System.out.println(tset);


    }
}