package com.assignment.parser;

/**
 * This factory is responsible in creating the
 * parser implementation based on the input file type.
 *
 */
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
