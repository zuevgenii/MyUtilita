package com.zuev;

import java.io.IOException;
import java.util.*;


public class Filter {
    private ArrayList<String> listString = new ArrayList<>();
    private ArrayList<Double> listDouble = new ArrayList<>();
    private ArrayList<Integer> listInteger = new ArrayList<>();
    private String temp;

    public ArrayList<String> getListString() {
        return listString;
    }

    public ArrayList<Double> getListDouble() {
        return listDouble;
    }

    public ArrayList<Integer> getListInteger() {
        return listInteger;
    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    void sort() {
        for (ReadFromFile file : Properties.inputFiles) {
            while (!file.isEOF()) {
                temp = file.getCurrentString();
                if (isNumber(temp)) listInteger.add(Integer.parseInt(temp));
                else if (isDouble(temp)) listDouble.add(Double.parseDouble(temp));
                else listString.add(temp);
                temp = file.toNextString();
            }
        }
    }

    void filterWrite(List list, String str) {
        for (WriteToFile file : Properties.outputFiles) {
            if (file.getDest().toString().equals(Properties.getFullPath() + Properties.getPrefix() + str)) {
                for (int i = 0; i < list.size(); i++) {
                    file.write(list.get(i).toString());
                }
            }
        }
    }

    void printAll() {

        try {
            if (listInteger.size() > 0) WriteToFile.createFiles("integer.txt");
            if (listDouble.size() > 0) WriteToFile.createFiles("double.txt");
            if (listString.size() > 0) WriteToFile.createFiles("string.txt");
        } catch (IOException e) {
            System.out.println("I can't create file or directory");
        }

        filterWrite(listInteger, "integer.txt");
        filterWrite(listString, "string.txt");
        filterWrite(listDouble, "double.txt");

    }
}
