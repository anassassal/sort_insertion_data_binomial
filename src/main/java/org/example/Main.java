package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    //////////////////////////////redData
    public static ArrayList<Double> readCSV(String filename) throws IOException {
        ArrayList<Double> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                double value = Double.parseDouble(line.trim());
                data.add(value);
            }
        }

        return data;
    }
    ////////////////////////writeCSV
    public static void writeCSV(ArrayList<Double> data, String filename) throws IOException {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (Double value : data) {
                    writer.write(value.toString());
                    writer.newLine();
                }
            }
        }
    //////////////convertint data to data best case
    public static void convertingDataToBestCase(String name_File_of_data_average_case,String name_File_of_data_best_case) throws IOException {
        ArrayList<Double> arrayList=readCSV("name_File_of_data_average_case");
        SelectionSort.sort(arrayList);
        writeCSV(arrayList,"name_File_of_data_best_case");

    }
    ////////////////////calcule time
    public static long calculeTimeOfSort(String name_of_csv){
        long time=-1;
        try {
            ArrayList<Double> dataList = readCSV(name_of_csv);
            long t0=System.nanoTime();
            SelectionSort.sort(dataList);
            long t1=System.nanoTime();
             time=(t1-t0)/1000000;

        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier CSV : " + e.getMessage());
        }
        return time;
    }
    ///////////////////////mainn
    public static void main(String[] args) throws IOException {
//        ArrayList<Double> arrayList=new ArrayList<>();
//        arrayList=readCSV("data_500.csv");
//        SelectionSort.sort(arrayList);
//        Collections.reverse(arrayList);
//        writeCSV(arrayList,"data_worst_case_500.csv");
//        convertingDataToBestCase("data_100.csv","data_best_100.csv");

        long time100=calculeTimeOfSort("data_worst_case_500.csv");
//        long time200=calculeTimeOfSort("data_100.csv");
//        long time500=calculeTimeOfSort("data_100.csv");
        System.out.println("Time of execution 100 : " + time100+"ms");
//        System.out.println("Time of execution 200 : " + time200+"ms");
//        System.out.println("Time of execution 500 : " + time500+"ms");

    }
}
