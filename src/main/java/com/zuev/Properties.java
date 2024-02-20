package com.zuev;

import java.util.List;

public class Properties {
    public static List<ReadFromFile> inputFiles;

    public static List<WriteToFile> outputFiles;

    private static String fullPath = "";
    private static String prefix = "";
    private static boolean fullStatistics = false;
    private static boolean statistics = false;
    private static boolean rewrite = true;

    public static boolean isRewrite() {
        return rewrite;
    }

    public static String getFullPath() {
        return fullPath;
    }

    public static void setFullPath(String fullPath) {
        Properties.fullPath = fullPath;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static void setPrefix(String prefix) {
        Properties.prefix = prefix;
    }

    public static void setRewrite(boolean rewrite) {
        Properties.rewrite = rewrite;
    }


    public static boolean isFullStatistics() {
        return fullStatistics;
    }

    public static void setFullStatistics(boolean fullStatistics) {
        Properties.fullStatistics = fullStatistics;
    }

    public static boolean isStatistics() {
        return statistics;
    }

    public static void setStatistics(boolean statistics) {
        Properties.statistics = statistics;
    }
}

