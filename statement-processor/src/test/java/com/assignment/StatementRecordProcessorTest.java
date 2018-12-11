package com.assignment;

import com.assignment.application.StatementRecordProcessor;
import org.junit.Test;

import java.io.File;
import java.net.URL;

public class StatementRecordProcessorTest {

    private StatementRecordProcessor statementRecordProcessor = new StatementRecordProcessor();

    @Test
    public void testProcessingCsvFile() {
        URL url = getClass().getClassLoader().getResource("records.csv");
        if (url != null) {
            String file = url.getFile();
            statementRecordProcessor.processStatement(new File(file));
        }
    }

    @Test
    public void testProcessingXmlFile() {
        URL url = getClass().getClassLoader().getResource("records.xml");
        if (url != null) {
            String file = url.getFile();
            statementRecordProcessor.processStatement(new File(file));
        }
    }
}
