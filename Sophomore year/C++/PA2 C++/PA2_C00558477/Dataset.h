//
// Created by coleb on 10/18/2025.
//



#ifndef PA2_C00558477_DATASET_H
#define PA2_C00558477_DATASET_H



#include <vector>
#include <fstream>
#include <sstream>
#include <string>
struct Dataset {
    std::vector<std::vector<double>> Data;
    std::vector<std::vector<double>> Labels;
    std::string Fields;
    Dataset(const std::string&);
};


#endif //PA2_C00558477_DATASET_H