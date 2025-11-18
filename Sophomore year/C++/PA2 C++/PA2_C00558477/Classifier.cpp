//
// Created by coleb on 10/18/2025.
//

#include "Classifier.h"
#include <fstream>
#include <iostream>
#include <vector>

using namespace  std;


/*
 * This is the default constructor for the Classifier class. it creates the weight
 * vectors and initializes them.
 *
 * Precondition: Receives nothing, it's a default constructor. but it does set the
 * weight vectors W1, and W2.
 *
 *
 * Postcondition: creates the classifier object that stores the weight arrays
 *
 *
 */


//default constructor
Classifier::Classifier() {
    //resizing the weight vectors
    W1.resize(4, vector<double>(12, 0.0));
    W2.resize(12, vector<double>(3, 0.0));

    //initializing the W1 vector
    for (vector<double> &i : W1){
        for (double &j : i) {
            j = rand() / (RAND_MAX + 1.0);
        }
    }

    //initializing the W2 vector
    for (vector<double> &i : W2) {
        for (double &j : i) {
            j = rand() / (RAND_MAX + 1.0);
        }
    }

}

/*
 * This method will be using a loss function known as mean squared error (MSE) to
 * compute the score for each sample.
 *
 * Precondition: receives two 1D vector arrays Prediction, and label to calculate
 * the MSE equation.
 *
 *
 * Postcondition: After the calculation the method returns score of the error.
 *
 *
 */

//Score method
double Classifier::Score(vector<double> prediction, vector<double> label) {

    //initializing the total variable
    double total = 0.0;

    //for loop calculating the score
    for (int i = 0; i < prediction.size(); ++i) {
        total += pow(label[i] - prediction[i], 2);
    }

    //average loss
    return total / prediction.size();

}


/*
 * As an overload to the insertion operator, this will allow you to “insert” a data
 * sample into a Classifier model to obtain its prediction.
 *
 *
 * Precondition: accepts a 1D double vector corresponding to a data sample’s 4 features
 *
 *
 * Postcondition: returns a 1D double vector of length 3 containing the Classifier’s
 * predictions for the label of that data sample.
 *
 *
 */

//operator overloader
vector<double> Classifier::operator<<(vector<double> sample) {

    //Computing the activations of the first and second layers of each Classifier using the activation method
    vector<double> activation1 = Activate(sample, W1);

    vector<double> activation2 = Activate(activation1, W2);


    return activation2;



}
