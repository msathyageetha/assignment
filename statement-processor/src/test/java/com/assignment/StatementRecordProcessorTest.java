package com.assignment;

import com.assignment.application.StatementRecordProcessor;
import org.junit.Test;

public class StatementRecordProcessorTest {

    private StatementRecordProcessor statementRecordProcessor = new StatementRecordProcessor();

    @Test
    public void testProcessingCsvFile() {
        statementRecordProcessor.processStatement("/records.csv");
    }

    @Test
    public void testProcessingXmlFile() {
        statementRecordProcessor.processStatement("/records.xml");
    }
}
