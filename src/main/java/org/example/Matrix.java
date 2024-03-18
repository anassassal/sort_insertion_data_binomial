package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;



public class Matrix {
    // Méthode pour générer des nombres aléatoires selon une distribution binomiale avec une moyenne et une variance spécifiées
    public static double[] generateRandomNumbers(int dataSize, double mean, double variance) {
        Random random = new Random();
        double p = 1 - (variance / mean); // Probabilité de succès
        double[] randomNumbers = new double[dataSize];
        for (int i = 0; i < dataSize; i++) {
            double var = random.nextDouble();
            double successes=0;
            for (int j = 0; j < dataSize; j++) {
                if (random.nextDouble() < p) {
                    successes=successes+var;
                }
            }
            randomNumbers[i] = successes;
        }
        return randomNumbers;


    }

    public static void main(String[] args) {
        // Définir les moyennes, les variances et les tailles de données
        double[] means = {1.0, 2.0, 3.0};
        double[] variances = {0.25, 0.5, 0.75};
        int[] dataSizes = {100,200,500};

        // Initialiser les matrices pour stocker les nombres aléatoires générés
        double[][][][] randomNumbersMatrices = new double[dataSizes.length][means.length][variances.length][];

        // Générer des nombres aléatoires pour chaque combinaison de moyenne, variance et taille de données
        for (int i = 0; i < dataSizes.length; i++) {
            for (int j = 0; j < means.length; j++) {
                for (int k = 0; k < variances.length; k++) {
                    randomNumbersMatrices[i][j][k] = generateRandomNumbers(dataSizes[i], means[j], variances[k]);
                    ;
                }
            }
        }

        // Afficher les nombres aléatoires générés
//        for (int i = 0; i < dataSizes.length; i++) {
//            System.out.println("Data Size: " + dataSizes[i]);
//            for (int j = 0; j < means.length; j++) {
//                for (int k = 0; k < variances.length; k++) {
//                    System.out.println("Mean: " + means[j] + ", Variance: " + variances[k]);
//                    for (int l = 0; l < dataSizes[i]; l++) {
//                        System.out.println(randomNumbersMatrices[i][j][k][l]);
//                    }
//                }
//            }
//        }
        String[] fileName = {"data_100.csv","data_200.csv","data_500.csv"};
        try {




            //////////
            for (int i = 0; i < dataSizes.length; i++) {
                FileWriter fileWriter = new FileWriter(fileName[i]);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                for (int j = 0; j < means.length; j++) {
                    for (int k = 0; k < variances.length; k++) {
                        for (int l = 0; l < dataSizes[i]; l++) {
                            printWriter.println(randomNumbersMatrices[i][j][k][l]);
                        }
                    }
                }
            }
            //////////



        } catch (IOException e)  {
            throw new RuntimeException(e);
        }

    }
}
