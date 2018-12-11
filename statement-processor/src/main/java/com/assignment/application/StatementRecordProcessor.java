package com.assignment.application;

import com.assignment.domain.StatementRecord;
import com.assignment.parser.ParserFactory;

import java.util.List;

public class StatementRecordProcessor {

    public void processStatement(String fileName) {
        String fileType = determineFileType(fileName);
        final List<StatementRecord> statementRecords = ParserFactory.getParser(fileType).parseAndValidate(fileName);
        ReportGenerator.generateReport(statementRecords);
    }

    private String determineFileType(String fileName) {
        int lastIndexOf = fileName.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return fileName.substring(lastIndexOf);
    }
}
