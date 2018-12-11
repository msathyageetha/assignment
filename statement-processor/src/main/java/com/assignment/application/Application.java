package com.assignment.application;

public class Application {

    public static void main(String[] args) {
      /*  String file = null;//args[0];
        String fileType = null;// args[1];
        if (file == null || fileType == null) {
            throw new IllegalArgumentException("File name and type are mandatory to process the statement");
        }*/
        StatementRecordProcessor processor = new StatementRecordProcessor();
        processor.processStatement("/records.xml");
    }
}
