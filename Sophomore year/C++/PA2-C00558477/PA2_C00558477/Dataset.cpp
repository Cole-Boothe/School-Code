//
// Created by coleb on 10/18/2025.
//

#include "Dataset.h"
#include <fstream>
#include <iostream>
#include <sstream>
#include <vector>

using namespace std;



/*
 * Is the constructor for Dataset that receives a line of text from the iris file
 * indefinites the species and its specs, sorts accordingly and appends it to the
 * data vector, and Labels vector
 *
 *
 * Precondition: receives the string and sets all other variables like Data, Label, Fields.
 *
 *
 * Postcondition: Creates the Dataset object.
 *
 *
 */


//constructor for the Dataset class
Dataset::Dataset(const string &) {

    //opening the file
    ifstream File;
    File.open("Iris - Copy.csv");

    //initiating the string
    string line;

    //getting the header to put into fields
    getline(File,line);
    Fields = line;


    //while loop to sort each line
    while (getline(File,line)) {
        stringstream ss(line);
        string numbers;

        //loop to get all the double variables from the line
        vector<double> alldouble;
        for (int i = 0; i < 4; i++) {
            getline(ss, numbers, ',');
            alldouble.push_back(stod(numbers));
        }

        //pushing the numbers to the data vector
        Data.push_back(alldouble);

        // getting and determining the species
        string species;
        getline(ss, species);

        vector<double> onehot(3, 0.0);

        if (species == "Iris-setosa") {
            onehot[0] = 1.0;
        }
        else if (species == "Iris-versicolor") {
            onehot[1] = 1.0;
        }
        else if (species == "Iris-virginica") {
            onehot[2] = 1.0;
        }

        // pushing the name to the label
        Labels.push_back(onehot);

    }


}