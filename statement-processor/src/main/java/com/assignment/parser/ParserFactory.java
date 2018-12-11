package com.assignment.parser;

public class ParserFactory {

    public static InputParser getParser(String fileType) {
        switch (FileType.valueOf(fileType.toUpperCase())) {
            case CSV:
                return new CsvParser();
            case XML:
                return new XmlParser();
            default:
                throw new IllegalArgumentException("Invalid file type");
        }
    }
}
