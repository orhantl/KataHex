package fr.bank.core;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountTransaction {
    private String id;
    private final String bankAccountId;
    private final LocalDateTime operationTimestamp;
    private final BigDecimal amount;
    private final TransactionType transactionType;

    public AccountTransaction(String bankAccountId, LocalDateTime operationTimestamp, BigDecimal amount,
                              TransactionType transactionType) {
        this.bankAccountId = bankAccountId;
        this.operationTimestamp = operationTimestamp;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public static AccountTransaction createWithdrawalTransaction(String bandAccountId, LocalDateTime timestamp, BigDecimal amount) {
        return new AccountTransaction(bandAccountId, timestamp, amount, TransactionType.WITHDRAWAL);
    }

    public static AccountTransaction createDepositTransaction(String bankAccountId, LocalDateTime timestamp, BigDecimal amount) {
        return new AccountTransaction(bankAccountId, timestamp, amount, TransactionType.DEPOSIT);
    }

    public String getBankAccountId() {
        return bankAccountId;
    }

    public LocalDateTime getOperationTimestamp() {
        return operationTimestamp;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    @Override
    public String toString() {
        return "AccountTransaction { " +
                "Transaction date : " + operationTimestamp +
                "Type : " + transactionType +
                "Amount : " + amount +
                '}';
    }
}
