#include <iostream>
#include <iomanip>
#include <string>
#include <fstream>
#include <vector>
#include "classifier.h"
#include "Dataset.h"

using namespace std;


/*
 * This method uses the insertion sort method sorting in ascending order using the AverageLoss score.
 *
 * Precondition: the function receives the Classifier object vector and uses it to do the sorting
 *
 *
 * Postcondition: The function is void so it doesn't return anything
 * but does sort the vector in ascending order
 *
 *
 */


void InsertionSort (vector<Classifier>& collection) {

    // insertion sort for loop
    for (int i = 1; i < collection.size(); i++) {
        Classifier key = collection[i];
        int j = i - 1;
        while (j >= 0 && collection[j].AverageLoss > key.AverageLoss) {
            collection[j + 1] = collection[j];
            j--;
        }
        collection[j + 1] = key;
    }
}


/*
 *
 * This function accepts a reference to a vector of classifier objects and returns a
 * new vector of classifier objects.
 *
 *
 * Precondition: receives a classifier vector that is already in ascending order
 * containing a new generation of the top 10 best performing and 5 new classifier
 * objects from the default constructor
 *
 *
 * Postcondition: returns a vector of the 10 surviving objects and the new random models
 * to diversify the pool of candidate solutions and will help to ensure
 * that the genetic algorithm converges to a strong set of solutions.
 *
 *
 */

vector<Classifier> Selection (vector<Classifier>& pop) {
    vector<Classifier> returnVector;
    returnVector.reserve(15);

    // for loop for the top 10 best performing
    for(int i = 0; i < 10; i++){
        returnVector.push_back(pop[i]);
    }

    //for loop for the 5 new classifiers
    for(int i = 0; i < 5; i++){
        returnVector.emplace_back();
    }

    //returning the surviving members and new random models
    return returnVector;
}

/*
 * This function will be used as the second phase of the iterative genetic
 * optimization process to create an additional 15 new Classifiers whose
 * weights are random combinations of the W1 and W2 weight sets of the fittest
 * Classifiers selected by function Selection above.
 *
 *
 * Precondition: receives a reference to a classifier vector and uses it to
 * generate the next 15 new classifiers
 *
 *
 * Postcondition: Appends the classifier objects that hase the weights from
 * the random parents to population vector and repeats
 *
 *
 */


void Crossover (vector<Classifier>& collection) {

    //
    for(int i = 0; i < 15; i++){

        //generating the two inclusive random ints
        int p1 = rand() % 10;
        int p2 = rand() % 10;

        //making sure they don't equal each other
        while(p2 == p1){
            p2 = (rand() % 10);
        }


        //creating classifier object
        Classifier crossova;

        //the 50/50 probability variable
        int fiftyfifty = rand() % 2 ;


        //assigning the random parents
        if(fiftyfifty == 0){
            crossova.W1 = collection[p1].W1;
            crossova.W2 = collection[p2].W2;
        }

        //other combination of random parents
        else{
            crossova.W1 = collection[p2].W1;
            crossova.W2 = collection[p1].W2;
        }

        //append to the population vector
        collection.push_back(crossova);
    }


}



/*
 *
 * This operation will be used to generate an additional 20 Classifier objects
 * for the next generation of the population vector managed in int main below.
 *
 *
 * Precondition: the function receives a reference to a vector of Classifier
 * objects and returns nothing.
 *
 *
 * Postcondition: after performing the random mutation on all elements affecting both sets of weights then appends
 * it to the reference vector and repeats for the next iteration.
 *
 *
 */


void Mutate(vector<Classifier>& collection) {

    // looping 20 times for the 20 classifier objects
    for(int i = 0; i < 20; i++){

        //creating mutation classifier

        Classifier mutation = collection[i];

        //nested for each loops that iterate each element in W1
        for (vector<double> & i : mutation.W1) {
            for (double & j : i) {

                //random number to see if weight needs to be increased or decreased
                int randInt = rand() % 100;

                //if statements that determine the addition or subtraction
                if (randInt < 5) {
                    j += 0.1;
                }
                if (randInt > 4 && randInt < 10) {
                    j -= 0.1;
                }
                if (randInt > 9) {
                    j = j;
                }
            }
        }


        //nested for each loops that iterate each element in W2
        for (vector<double> & i : mutation.W2) {
            for (double & j : i) {

                //random number to see if weight needs to be increased or decreased
                int randInt = rand() % 100;

                //if statements that determine the addition or subtraction
                if (randInt < 5) {
                    j += 0.1;
                }
                if (randInt > 4 && randInt < 10) {
                    j -= 0.1;
                }
                if (randInt > 9) {
                    j = j;
                }
            }
        }


        //appending the mutation
        collection.push_back(mutation);

    }
}



int main() {
    // making sure the random doesn't repeat
    srand(time(nullptr));

    //try catch to open and read the file
    try {

        //opening the file
        ifstream file("Iris - Copy.csv");


        //fail statement if it can't
        if(!file.is_open()){
            throw runtime_error("Error opening file");
        }

        // Getting the header
        string line;
        getline(file, line); // header
        cout << line << endl;

        //loop to get the whole document
        int count = 0;
        while (getline(file, line)) {
            count++;
            cout << "[" << count << "] " << line << endl;
        }
        cout << "Total Samples: " << count << endl;

        //closing the file
        file.close();
    }

    //catches for errors
    catch (const ios_base::failure& e){
        cerr << "file I/O Error: " << e.what() << endl;
    }

    catch (const runtime_error& e) {
        cerr << "Custom Error: " << e.what() << endl;
    }
    catch (const exception& e) {
        cerr << "General Exception: " << e.what() << endl;
    }
    catch (...) {
        cerr << "An unknown error occurred." << endl;
    }

    // creating Dataset object containing the Iris file
    Dataset data("Iris - Copy.csv");

    //population vector
    vector<Classifier> population(50);

    // for each loop to assess the initial fitness of the random population
    for (Classifier &clas : population) {
        //initiating totalerror
        double totalError = 0.0;
        //for loop that goes through the population
        for (size_t i = 0; i < data.Data.size(); ++i) {
            //creating prediction vector with operator overloading for temp class
            vector<double> prediction = clas << data.Data[i];
            totalError += clas.Score(prediction, data.Labels[i]);
        }
        //giving the temp class the AverageLoss
        clas.AverageLoss = totalError / data.Data.size();
    }



    double populationAvg = 0.0;
    //for loop to calculate the population average
    for (Classifier &clas : population) {
        populationAvg += clas.AverageLoss;
    }
    populationAvg /= population.size();

    //printing the initial population average
    cout << "Initial average population error: " << fixed << setprecision(6) << populationAvg << endl;



    //initiating the first generation
    int generation = 1;
    //while loop until the population average is below 0.145
    while (populationAvg > 0.145) {

        // sorting the population
        InsertionSort(population);
        // getting the top 10 and adding 5 new objects
        population = Selection(population);
        // creates 15 new random classifiers
        Crossover(population);
        // mutates 20 new object for the next generation
        Mutate(population);

        //same score loop that was used to initialize but is now in a while loop
        for (Classifier &clas : population) {
            double totalError = 0.0;
            for (size_t i = 0; i < data.Data.size(); ++i) {
                vector<double> prediction = clas << data.Data[i];
                totalError += clas.Score(prediction, data.Labels[i]);
            }
            clas.AverageLoss = totalError / data.Data.size();
        }

        //resorting after new calculations
        InsertionSort(population);

        // getting average population
        populationAvg = 0.0;
        for (Classifier &c : population) populationAvg += c.AverageLoss;
        populationAvg /= population.size();

        // printing the average population
        cout << generation++ << ") Population average error: " << fixed << setprecision(6) << populationAvg << endl;
    }
    //printing the lowest error
    cout << "Best classifier error: " << population[0].AverageLoss << endl;




    //printing out to the prediction file
    ofstream outFile("Predictions.txt");
    outFile << "Cole Boothe\nC00558477\n";
    outFile << "i\t\tP0\tP1\tP2\tL0\tL1\tL2\n";

    //try catch for the printing
    try{
        //for loop to print each layer
    for (size_t i = 0; i < data.Data.size(); ++i) {
        //getting the predictions
        vector<double> Prediction = population[0] << data.Data[i];
        //getting the labels
        vector<double> Label = data.Labels[i];
        //the print statement
        outFile << (i+1) << ":  \t" << fixed << setprecision(2) << "\t" <<  Prediction[0]  << "\t" << Prediction[1] << "\t"  << Prediction[2] << "\t" << Label[0] << "\t" << Label[1] << "\t" << Label[2] << "\n";
    }

        //closing file
        outFile.close();
        //printing that the writing was successful
        cout << "successfully wrote predictions.txt.\n";
    }


    //catch if it couldn't write the file
    catch (const exception &e) {
    cerr << "Error: " << e.what() << endl;
    }


}
