package com.assignment.application;

import com.assignment.domain.StatementRecord;
import com.assignment.parser.ParserFactory;

import java.io.File;
import java.util.List;

/**
 * This class is responsible in determining the incoming file type,
 * parse it and print report.
 *
 */
public class StatementRecordProcessor {

    public void processStatement(File file) {
        String fileType = determineFileType(file.getAbsolutePath());
        final List<StatementRecord> statementRecords = ParserFactory.getParser(fileType).parseAndValidate(file);
        ReportGenerator.generateReport(statementRecords);
    }

    private String determineFileType(String fileName) {
        int lastIndexOf = fileName.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return fileName.substring(lastIndexOf + 1);
    }
}
