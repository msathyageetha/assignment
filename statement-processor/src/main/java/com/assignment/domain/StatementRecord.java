package com.assignment.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class StatementRecord {
    private Integer transactionReference;
    private String accountNumber;
    private String description;
    private BigDecimal startBalance;
    private BigDecimal mutation;
    private BigDecimal endBalance;
    private boolean valid;

    public StatementRecord(){

    }

    public StatementRecord(Integer transactionReference, String accountNumber, String description, BigDecimal startBalance,
                           BigDecimal mutation, BigDecimal endBalance) {
        this.transactionReference = transactionReference;
        this.accountNumber = accountNumber;
        this.startBalance = startBalance;
        this.mutation = mutation;
        this.description = description;
        this.endBalance = endBalance;
        this.valid  = true;
    }

    public Integer getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(Integer transactionReference) {
        this.transactionReference = transactionReference;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getStartBalance() {
        return startBalance;
    }

    public void setStartBalance(BigDecimal startBalance) {
        this.startBalance = startBalance;
    }

    public BigDecimal getMutation() {
        return mutation;
    }

    public void setMutation(BigDecimal mutation) {
        this.mutation = mutation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getEndBalance() {
        return endBalance;
    }

    public void setEndBalance(BigDecimal endBalance) {
        this.endBalance = endBalance;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatementRecord that = (StatementRecord) o;
        return transactionReference.equals(that.transactionReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionReference);
    }
}
