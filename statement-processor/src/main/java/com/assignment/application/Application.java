package com.assignment.application;

import java.io.File;

public class Application {

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Input File is mandatory !!!");
        }
        File inFile = new File(args[0]);
        StatementRecordProcessor processor = new StatementRecordProcessor();
        processor.processStatement(inFile);
    }
}
