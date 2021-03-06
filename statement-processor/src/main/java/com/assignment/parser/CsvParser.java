package com.assignment.parser;

import com.assignment.domain.StatementRecord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CsvParser extends InputParser {

    private static final String COMMA_DELIMITER = ",";

    public List<StatementRecord> parseAndValidate(File file) {
        List<StatementRecord> statementRecordList = new ArrayList<>();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] statements = line.split(COMMA_DELIMITER);
                if (statements.length > 0) {
                    StatementRecord statementRecord = new StatementRecord(Integer.valueOf(statements[0]), statements[1], statements[2],
                            new BigDecimal(statements[3]), new BigDecimal(statements[4]), new BigDecimal(statements[5]));
                    //validate the input record before adding it to the list
                    validateReferenceNumber(statementRecordList, statementRecord);
                    validateEndBalance(statementRecord);

                    statementRecordList.add(statementRecord);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return statementRecordList;
    }
}
