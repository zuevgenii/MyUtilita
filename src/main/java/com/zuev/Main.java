package com.zuev;

public class Main {


    public static void main(String[] args) {
        try {
            Parser.parse(args);
        } catch (Exception e) {
            System.out.println("Invalid parameters");
            return;
        }

        Filter filter = new Filter();
        filter.sort();
        filter.printAll();
        System.out.println();
        Statistics.printStatistics(filter.getListInteger(), filter.getListDouble(), filter.getListString());
        System.out.println("FINISH");
    }
}