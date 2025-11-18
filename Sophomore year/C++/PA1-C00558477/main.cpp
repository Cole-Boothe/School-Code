#include <iostream>
using namespace std;

/*
 * this method initializes the forest by deciding if there will
 * be a tree, fire, or a empty space in the array spot
 *
 * Precondition: the function receives the forest array, the int n
 * that is the size of the array, and the initial probability of fire in each spot
 *
 *
 * Postcondition: The function is void so it doesn't return anything
 * but does adjust the forest array so each slot will eather have a tree,
 * fire, or an empy slot.
 *
 *
 */

void initializeforest(int forest[], int n,int initialprob) {
    // for loop going though each spot in the array
    for (int i = 0; i < n * n; i++) {
        int randomnum = rand() % 100;
        //initiating the fire, empty, or tree spots
        if (randomnum < 80) {
            if (rand() % 100 < initialprob) {
                forest[i] = 2;
            }
            else {forest[i] = 1;}
        }
        else { forest[i] = 0; }
    }
}


/*
 * this method prints the array in a 2D array format with some decorations
 * around it to make it nice to look at.
 *
 * Precondition: the function receives the forest array, and the int n
 * that is the size of the array.
 *
 *
 * Postcondition: The function is void so it doesn't return anything
 * but does print the 1D array in a 2D format.
 *
 *
 */

void printForest(const int forest[], int n) {
    // for loop for the dashes
    for (int i = 0; i < 3*n+2; i++) {
         cout << char(45);
    }
    cout << endl;
    //nested for loops for the 2D array
    for (int i = 0; i < n; i++) {
        cout << "|";
        for (int j = 0; j < n; j++) {
            int cell = forest[n * i + j];
            char character;
            //switch case for what each cell will print
            switch (cell) {
                case 1: character = 84 ; break;
                case 2: character = 126 ; break;
                case 3: character = '#'; break;
                default: character = ' '; break;
            }
            cout << " " << character << " ";
        }
        cout << "|" << endl;
    }
    //secend for loop for the dashes
    for (int i = 0; i < 3*n+2; i++) {
        cout << char(45);
    }
    cout << endl;
}




/*
 * this method iterates the next phase of the array simulation
 *
 * Precondition: the function receives the forest array, the int n
 * that is the size of the array, and the fire probability for the
 * fire to spread
 *
 *
 * Postcondition: the method is void but does adjust the array by keeping
 * empty cells empty, fire cells turn to ash, ash cells become empty, a tree
 * cell with a fire neighbor can turn into a fire cells considering the fire spread
 * prob, and checks if a tree cell has a ash neighbor also using the fire prob but
 * dividing it by half.
 *
 *
 */

void spreadFire(int *&forest, int n, int fireprob) {
    int *newforest = new int[n * n];
    bool isfire = false;
    bool isash = false;

    //nested for loop for the 2D array
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {

            int idx = i * n + j;
            int cell = forest[n * i + j];
            int rows = idx/n;
            int cols = idx%n;

            //switch case for each number for the cell
            switch (cell) {
                //case 1 checks the corners, edges, and middle cases for fire and ash neighbors wi
                case 1:
                    //top left corner
                    if (idx == 0) {
                        if (forest[i*n+j+1] == 2 || forest[(i+1)*n+j] == 2 || forest[(i+1)*n+j+1] == 2){
                            isfire = true;
                        }
                        else if (forest[i*n+j+1] == 3 || forest[(i+1)*n+j] == 3 || forest[(i+1)*n+j+1] == 3){
                            isash = true;
                        }
                    }
                    //top right corner
                    else if (idx == n - 1) {
                        if (forest[i*n+j-1] == 2 || forest[(i+1)*n+j] == 2 || forest[(i+1)*n+j-1] == 2){
                            isfire = true;
                        }
                        else if (forest[i*n+j-1] == 3 || forest[(i+1)*n+j] == 3 || forest[(i+1)*n+j-1] == 3){
                            isash = true;
                        }
                    }
                    //bottom left corner
                    else if (idx == (n - 1)*n) {
                        if (forest[(i-1)*n+j] == 2 || forest[(i-1)*n+j+1] == 2 || forest[i*n+j+1] == 2){
                            isfire = true;
                        }
                        else if (forest[(i-1)*n+j] == 3 || forest[(i-1)*n+j+1] == 3 || forest[i*n+j+1] == 3){
                            isash = true;
                        }
                    }
                    //bottom right corner
                    else if (idx == n*n-1) {
                        if (forest[(i-1)*n+j] == 2 || forest[(i-1)*n+j-1] == 2 || forest[i*n+j-1] == 2){
                            isfire = true;
                        }
                        else if (forest[(i-1)*n+j] == 3 || forest[(i-1)*n+j-1] == 3 || forest[i*n+j-1] == 3){
                            isash = true;
                        }
                    }
                    //top edge
                    else if (rows == 0) {
                         if (forest[i*n+j-1] == 2 || forest[(i+1)*n+j] == 2 || forest[(i+1)*n+j-1] == 2 || forest[i*n+j+1] == 2 || forest[(i+1)*n+j+1] == 2){
                             isfire = true;
                         }
                         else if (forest[i*n+j-1] == 3 || forest[(i+1)*n+j] == 3 || forest[(i+1)*n+j-1] == 3 || forest[i*n+j+1] == 3 || forest[(i+1)*n+j+1] == 3) {
                             isash = true;
                         }
                     }
                    //botteom edge
                    else if (rows == n-1) {
                        if (forest[(i-1)*n+j] == 2 || forest[(i-1)*n+j+1] == 2 || forest[i*n+j+1] == 2 || forest[(i-1)*n+j-1] == 2 || forest[i*n+j-1] ==2){
                             isfire = true;
                        }
                        else if (forest[(i-1)*n+j] == 3 || forest[(i-1)*n+j+1] == 3 || forest[i*n+j+1] == 3 || forest[(i-1)*n+j-1] == 3 || forest[i*n+j-1] ==3){
                             isash = true;
                        }
                     }
                    //left edge
                    else if (cols == 0) {
                        if (forest[(i-1)*n+j] == 2 || forest[(i-1)*n+j+1] == 2 || forest[i*n+j+1] == 2 || forest[(i+1)*n+j] == 2 || forest[(i+1)*n+j+1] == 2){
                            isfire = true;
                        }
                        else if (forest[(i-1)*n+j] == 3 || forest[(i-1)*n+j+1] == 3 || forest[i*n+j+1] == 3 || forest[(i+1)*n+j] == 3 || forest[(i+1)*n+j+1] == 3){
                            isash = true;
                        }
                    }
                    //right edge
                    else if (cols == n-1) {
                        if (forest[(i-1)*n+j] == 2 || forest[(i-1)*n+j-1] == 2 || forest[i*n+j-1] == 2 || forest[(i+1)*n+j] == 2 || forest[(i+1)*n+j-1] == 2){
                            isfire = true;
                        }
                        else if (forest[(i-1)*n+j] == 3 || forest[(i-1)*n+j-1] == 3 || forest[i*n+j-1] == 3 || forest[(i+1)*n+j] == 3 || forest[(i+1)*n+j-1] == 3){
                            isash = true;
                        }
                    }
                    //middle peices
                    else {
                        if (forest[(i-1)*n+j] == 2 || forest[(i-1)*n+j-1] == 2 || forest[i*n+j-1] == 2 || forest[(i+1)*n+j] == 2 || forest[(i+1)*n+j-1] == 2 || forest[(i+1)*n+j+1] == 2 || forest[i*n+j+1] == 2 || forest[(i-1)*n+j+1] == 2) {
                            isfire = true;
                        }
                        else if (forest[(i-1)*n+j] == 3 || forest[(i-1)*n+j-1] == 3 || forest[i*n+j-1] == 3 || forest[(i+1)*n+j] == 3 || forest[(i+1)*n+j-1] == 3 || forest[(i+1)*n+j+1] == 3 || forest[i*n+j+1] == 3 || forest[(i-1)*n+j+1] == 3) {
                            isash = true;
                        }
                    }
                    if (isfire){
                        if (rand() % 100 < fireprob) {
                            newforest[idx] = 2;
                        }
                        else {newforest[idx] = 1;}
                    }
                    else if (isash) {
                        if (rand() % 100 < fireprob/2) {
                            newforest[idx] = 2;
                        }
                        else {newforest[idx] = 1;}
                    }

                    else {newforest[idx] = 1;}

                    break;
                case 2: newforest[idx] = 3; break;
                default: newforest[idx] = 0; break;
            }

            isfire = false;
            isash = false;
                }
        }
    delete[] forest;
    forest = newforest;
    }


/*
 * this method is a boolean method that checks if the forest array has
 * any ash or fire cells still active.
 *
 * Precondition: the function receives the forest array, and the int n
 * that is the size of the array.
 *
 *
 * Postcondition: The method returns a false or true depending on if
 * there are any ash or fire cells.
 *
 *
 */

    bool continueSimulation(const int forest[], int n){
    for (int i = 0; i < n*n; i++) {
        if (forest[i] == 2 || forest[i] == 3) {return true;}
    }
    return false;
    }


int main() {
    string buffer;
    bool incorrectinput;
    int stepcount = 0;

    // print method asking for the array size
    cout << "To calculate the size of the grid please enter a integer number between 10-30 " << endl;
    getline(cin, buffer);
    int n = stoi(buffer);
    // if statement if there was an incorrect number input
    if (n < 10 || n > 30) {
        incorrectinput = true;
        while (incorrectinput) {
            cout << "Incorrect, please enter a number between 10-30 " << endl;
            getline(cin, buffer);
            n = stoi(buffer);
            if (n >= 10 && n <= 30) {
                break;
            }
        }
    }

    // print method asking for the initial probability
    cout << "To calculate the initial fire placement please enter a integer number between 10-90 " << endl;
    getline(cin, buffer);
    int initialprob = stoi(buffer);
    // if statement if there was an incorrect number input
    if (initialprob < 10 || initialprob > 90) {
        incorrectinput = true;
        while (incorrectinput) {
            cout << "Incorrect, please enter a number between 10-90 " << endl;
            getline(cin, buffer);
            initialprob = stoi(buffer);
            if (initialprob >= 10 && initialprob <= 90) {
                break;
            }
        }
    }

    // print method asking for the fire probability
    cout << "To calculate the fire spread possibility please enter a integer number between 25-100 " << endl;
    getline(cin, buffer);
    int fireprob = stoi(buffer);
    // if statement if there was an incorrect number input
    if (fireprob < 25 || fireprob > 100) {
        incorrectinput = true;
        while (incorrectinput) {
            cout << "Incorrect, please enter a number between 25-100 " << endl;
            getline(cin, buffer);
            fireprob = stoi(buffer);
            if (fireprob >= 25 && fireprob <= 100) {
                break;
            }
        }
    }

    //initiating the array, printing, and counting the first step
    int *forest = new int [n*n];
    initializeforest(forest, n, initialprob);
    printForest(forest, n);
    stepcount = 1;

    //while loop that checks to keep going
    while (continueSimulation(forest, n)) {
        spreadFire(forest, n, fireprob);
        printForest(forest, n);
        stepcount++;
    }

    //output of step count
    cout << "Simulation complete after " << stepcount << " steps" << endl;

}

