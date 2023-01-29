package core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static core.AccountTransaction.createDepositTransaction;
import static core.AccountTransaction.createWithdrawalTransaction;

public class Account {
    private final String id;
    private BigDecimal balance;
    private final List<AccountTransaction> statements;
    
    private Account(String id, BigDecimal seedAmount) {
        this.id = id;
        this.balance = seedAmount;
        this.statements = new ArrayList<>();
    }

    public static Account createNewAccountOf(String id, BigDecimal seedAmount) {
        return new Account(id, seedAmount);
    }

    public void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Amount is superior to available balance");
        }
        balance = balance.subtract(amount);
        AccountTransaction withdrawalTransaction = createWithdrawalTransaction(this.id, amount);
        statements.add(withdrawalTransaction);
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        AccountTransaction depositTransaction = createDepositTransaction(this.id, amount);
        statements.add(depositTransaction);
    }

    public List<AccountTransaction> getAccountTransactions() {
        return statements;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
