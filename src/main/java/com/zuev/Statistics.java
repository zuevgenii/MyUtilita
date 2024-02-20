package com.zuev;

import java.util.ArrayList;


public class Statistics {
    public static void printStatistics(ArrayList<Integer> listInt,
                                       ArrayList<Double> listD,
                                       ArrayList<String> listStr) {
        if (Properties.isStatistics())
            if (Properties.isFullStatistics()) printFullStatistics(listInt, listD, listStr);
            else printShortStatistics(listInt, listD, listStr);

    }


    private static void printFullStatistics(ArrayList<Integer> listInt,
                                            ArrayList<Double> listD,
                                            ArrayList<String> listStr) {

        System.out.println("Тип данных: integer, кол-во = " + listInt.size() + ", минимум = " +
                listInt.stream().mapToInt(a -> a).min().orElse(0) + ", максимум = " +
                listInt.stream().mapToInt(a -> a).max().orElse(0) + ", сумма = " +
                listInt.stream().mapToInt(a -> a).reduce(0, (a, b) -> a + b) +
                ", среднее = " + listInt.stream().mapToDouble(a -> a).average().orElse(Double.NaN));

        System.out.println("Тип данных: double, кол-во = " + listD.size() + ", минимум = " +
                listD.stream().mapToDouble(a -> a).min().orElse(0.) + ", максимум = " +
                listD.stream().mapToDouble(a -> a).max().orElse(0.) + ", сумма = " +
                listD.stream().mapToDouble(a -> a).reduce(0, (a, b) -> a + b) +
                ", среднее = " + listD.stream().mapToDouble(a -> a).average().orElse(Double.NaN));

        System.out.println("Тип данных: string, кол-во = " + listStr.size() + ", минимум = " +
                min(listStr) + ", максимум = " + max(listStr));

    }

    private static void printShortStatistics(ArrayList<Integer> listInt,
                                             ArrayList<Double> listD,
                                             ArrayList<String> listStr) {

        System.out.println("Тип данных: integer, кол-во = " + listInt.size());

        System.out.println("Тип данных: double, кол-во = " + listD.size());

        System.out.println("Тип данных: string, кол-во = " + listStr.size());

    }


    private static int max(ArrayList<String> list) {
        int maxLen = 0;
        if (list.size() > 0) {
            maxLen = list.get(0).length();
            for (int i = 1; i < list.size(); i++) {
                if (maxLen < list.get(i).length()) maxLen = list.get(i).length();
            }
        }
        return maxLen;
    }

    private static int min(ArrayList<String> list) {
        int minLen = 0;
        if (list.size() > 0) {
            minLen = list.get(0).length();
            for (int i = 1; i < list.size(); i++) {
                if (minLen > list.get(i).length()) minLen = list.get(i).length();
            }
        }
        return minLen;
    }
}
