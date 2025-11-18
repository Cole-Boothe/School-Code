// Cole Boothe
// C00558477
// CMPS 261
//
//
//
// Program Description: This program will read from a URL that leads to a txt file.
// It will organize the names and ranking into two HashMaps that the user can then search
// names on to see the ranking of most used names of the chosen year
//
//
// Certificate of Authenticity: I certify that the code in the method
// functions including method function main of this project are entirely
// my own work.
//
//
//
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Cole Boothe
 * @version 11.0
 *
 * */


public class Main {
    public static void main(String[] args) {

        /**initializing the maps and scanner */
        Map<String, Integer> boymap = new HashMap<>();
        Map<String, Integer> girlmap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        /** initializing other vairables */
        int year, gender;
        String name, filename, buffer;

        /** selecting a year and making sure the selected year is within the range */
        System.out.println("Please select a year from 2001 to 2010 for the names");
        year = scanner.nextInt();
        while(year < 2001 || year > 2010){
            System.out.println("Please enter a valid from 2001-2010");
            year = scanner.nextInt();
        }

        /** switch statement that changes filename to the URL of the chosen year*/
        switch (year) {
        case 2001:
                filename = "https://liveexample.pearsoncmg.com/data/babynameranking2001.txt";
            break;
        case 2002:
                filename = "https://liveexample.pearsoncmg.com/data/babynameranking2002.txt";
            break;
        case 2003:
                filename = "https://liveexample.pearsoncmg.com/data/babynameranking2003.txt";
            break;
        case 2004:
                filename = "https://liveexample.pearsoncmg.com/data/babynameranking2004.txt";
            break;
        case 2005:
                filename = "https://liveexample.pearsoncmg.com/data/babynameranking2005.txt";
            break;
        case 2006:
                filename = "https://liveexample.pearsoncmg.com/data/babynameranking2006.txt";
            break;
        case 2007:
                filename = "https://liveexample.pearsoncmg.com/data/babynameranking2007.txt";
            break;
        case 2008:
                filename = "https://liveexample.pearsoncmg.com/data/babynameranking2008.txt";
            break;
        case 2009:
                filename = "https://liveexample.pearsoncmg.com/data/babynameranking2009.txt";
            break;

        default:
            filename = "https://liveexample.pearsoncmg.com/data/babynameranking2010.txt";
            break;

        }


        /** try catch that reads the URl txt file of the chosen year */
        try (java.util.Scanner input = new java.util.Scanner(new java.net.URL(filename).openStream())) {


            /** while loop that assigns the maps values and keys */
            while (input.hasNextLine()) {
                String lineinput = input.nextLine();

                String[] line = lineinput.split("\\s+");

                boymap.put(line[1], Integer.parseInt(line[0]));
                girlmap.put(line[3], Integer.parseInt(line[0]));

            }
        }


        /** catch statements for error */
        catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }

        /**selecting the gender */
        System.out.println("Please select a gender: 1 = boy, 0 = girl");
        gender = scanner.nextInt();

        /** while loop making sure a gender is chosen */
        while(gender < 0 || gender > 1){
            System.out.println("Please enter 1 or 0: 1 = Boy, 0 = Girl");
            gender =scanner.nextInt();
        }


        /** asking for a name to search for */
        System.out.println("Now enter a name to search for (capitalized name)");
        buffer = scanner.nextLine();
        name = scanner.nextLine();



        /** Checking and finding the rankings */
        if(boymap.containsKey(name) && gender == 1){
            System.out.println("The ranking for " + name + " is rank " + boymap.get(name) + " for most used boy name of " + year);
        }
        else if(girlmap.containsKey(name) && gender == 0){
            System.out.println("the ranking for " + name + " is rank " + girlmap.get(name) + " for most used girl name of " + year);
        }

        /** else statement if the name wasn't found */
        else{

            /** aksing for another name */
            System.out.println("That name is not in the " + year + " database\n\nWould you like to enter a different name: Y/N");
            name = scanner.nextLine();
            boolean notfound = true;

            if(name.compareTo("N") == 0 || name.compareTo("n") == 0){
                return;
            }
            else{

                /** checking the entered name */
                System.out.println("Please enter a name (capitalized): ");
                name = scanner.nextLine();

                /** while loop to continuously ask for a name until one is found */
                while(notfound){
                    if(boymap.containsKey(name) && gender == 1){
                        System.out.println("The ranking for " + name + " is rank " + boymap.get(name) + " for most used boy name of that year");
                        notfound = false;
                    }
                    else if (girlmap.containsKey(name) && gender == 0){
                        System.out.println("the ranking for " + name + " is rank " + girlmap.get(name) + " for most used girl name of that year");
                        notfound = false;
                    }
                    else{
                        System.out.println("That name also isn't in the chosen Dataset. Please pick another Name (make sure to capitalize the name)");
                        name = scanner.nextLine();
                    }

                }

            }

        }

    }

}