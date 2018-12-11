package com.assignment.application;

import com.assignment.domain.StatementRecord;

import java.util.List;

public class ReportGenerator {

    public static void generateReport(List<StatementRecord> records) {
        records.stream().filter(rec -> !rec.isValid()).forEach(ReportGenerator::print);
    }

    private static void print(StatementRecord rec) {
        System.out.print(rec.getTransactionReference() + " " + rec.getDescription());
        System.out.println();
    }
}
