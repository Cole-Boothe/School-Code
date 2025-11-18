//
// Created by coleb on 10/18/2025.
//


#ifndef PA2_C00558477_CLASSIFIER_H
#define PA2_C00558477_CLASSIFIER_H


#include <vector>
#include <cmath>
struct Classifier {
    std::vector<std::vector<double>> W1;
    std::vector<std::vector<double>> W2;
    double AverageLoss;
    Classifier();
    static double Score(std::vector<double> activation, std::vector<double> label);
    std::vector<double> operator<<(std::vector<double> sample);
    std::vector<double> Activate(const std::vector<double>& LayerInput, const std::vector<std::vector<double>>& LayerWeights) {
        std::vector<double> Activations(LayerWeights[0].size(), 0.0);
        for (int j = 0; j < LayerWeights[0].size(); j++) {
            for (int i = 0; i < LayerWeights.size(); i++) {
                Activations[j] += LayerInput[i] * LayerWeights[i][j];
            }
        }
        for (double& Dub : Activations) {
            Dub = (1.0 / (1.0 + exp(-1.0 * Dub)));
        }
        return Activations;
    }
};


#endif //PA2_C00558477_CLASSIFIER_H