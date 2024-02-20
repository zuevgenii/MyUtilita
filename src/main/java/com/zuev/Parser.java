package com.zuev;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.getProperty;

public class Parser {


    static void parse(String[] args) {
        int currentArgs = 0;

        String path = "";
        for (int i = 0; i < args.length; ++i) {
            if (args[currentArgs].equalsIgnoreCase("-o")) {
                ++currentArgs;
                path = args[currentArgs++];
                path = path.replace("/", "\\");
            }
            if (args[currentArgs].equalsIgnoreCase("-p")) {
                ++currentArgs;
                Properties.setPrefix(args[currentArgs++]);
            }
            if (args[currentArgs].equalsIgnoreCase("-a")) {
                ++currentArgs;
                Properties.setRewrite(false);
            }
            if (args[currentArgs].equalsIgnoreCase("-s")) {
                //короткая стат
                Properties.setStatistics(true);
                Properties.setFullStatistics(false);
                ++currentArgs;
            }
            if (args[currentArgs].equalsIgnoreCase("-f")) {
                Properties.setStatistics(true);
                Properties.setFullStatistics(true);
                ++currentArgs;
            }
        }
        Properties.setFullPath(getProperty("user.dir") + path + "\\");

        List<String> inputFiles = new ArrayList<>(Arrays.asList(args).subList(currentArgs, args.length));
        if (inputFiles.size() < 1) {
            throw new RuntimeException("No input files");
        }

        Properties.inputFiles = new ArrayList<>();
        for (String file : inputFiles) {
            Properties.inputFiles.add(new ReadFromFile(new File(file)));
        }

        Properties.outputFiles = new ArrayList<>();
        String[] outputFiles = {Properties.getFullPath() + Properties.getPrefix() + "integer.txt",
                Properties.getFullPath() + Properties.getPrefix() + "double.txt",
                Properties.getFullPath() + Properties.getPrefix() + "string.txt"};

        for (String file : outputFiles) {
            Properties.outputFiles.add(new WriteToFile(file));
        }
    }
}
