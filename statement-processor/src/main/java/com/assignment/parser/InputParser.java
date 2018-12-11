package com.assignment.parser;

import com.assignment.domain.StatementRecord;

import java.io.File;
import java.util.List;

public abstract class InputParser {

    public abstract List<StatementRecord> parseAndValidate(File file);


    protected void validateEndBalance(StatementRecord statementRecord) {

        if (statementRecord.getEndBalance().compareTo(statementRecord.getStartBalance().add(statementRecord.getMutation())) != 0) {
            statementRecord.setValid(false);
        }
    }

    protected void validateReferenceNumber(List<StatementRecord> existingStatementRecords, StatementRecord newStatementRecord) {
        for (StatementRecord statementRecord : existingStatementRecords) {
            if (newStatementRecord.getTransactionReference().equals(statementRecord.getTransactionReference())) {
                newStatementRecord.setValid(false);
                break;
            }
        }
    }
}
