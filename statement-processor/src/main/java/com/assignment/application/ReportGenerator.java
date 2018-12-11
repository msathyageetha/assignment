package com.assignment.application;

import com.assignment.domain.StatementRecord;

import java.util.List;

/**
 * This class is responsible in generating the report and printing it.
 *
 */
public class ReportGenerator {

    public static void generateReport(List<StatementRecord> records) {
        System.out.println("*********Statement Report*************");
        System.out.println("Reference | Description");
        System.out.println("-----------------------");
        records.stream().filter(rec -> !rec.isValid()).forEach(ReportGenerator::print);
    }

    private static void print(StatementRecord rec) {
        System.out.print(rec.getTransactionReference() + "    | " + rec.getDescription());
        System.out.println();
    }
}
