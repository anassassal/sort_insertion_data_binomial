package org.example;

import java.util.ArrayList;

public class SelectionSort {

    // Méthode pour comparer deux éléments dans une ArrayList
    public static boolean less(Double v, Double w) {
        return v.compareTo(w) < 0;
    }

    // Méthode pour échanger deux éléments dans une ArrayList
    public static void exch(ArrayList<Double> list, int i, int j) {
        Double temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    // Tri par sélection
    public static void sort(ArrayList<Double> list) {
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = i; j >0; j--) {
                if (less(list.get(j), list.get(j-1))) {
                    exch(list, j, j-1);
                }else break;
            }

        }
    }

    // Méthode pour afficher une ArrayList
    public static void printList(ArrayList<Double> list) {
        for (Double item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }


}
