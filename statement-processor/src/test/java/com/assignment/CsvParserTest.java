package com.assignment;

import com.assignment.domain.StatementRecord;
import com.assignment.parser.CsvParser;
import org.junit.Test;

import java.util.List;


public class CsvParserTest {

    CsvParser csvParser = new CsvParser();

    @Test
    public void processInput() {
        List<StatementRecord> statementRecords = csvParser.parseAndValidate("/records.csv");
        System.out.println(statementRecords.size());

    }
}