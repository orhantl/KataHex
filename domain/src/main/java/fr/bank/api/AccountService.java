package fr.bank.api;

import fr.bank.core.Account;
import fr.bank.core.AccountTransaction;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {

    Account findById(String bankAccountId);

    void addDeposit(String bankAccountId, BigDecimal amount);

    void addWithdrawal(String bankAccountId, BigDecimal amount);

    List<AccountTransaction> findTransactionByAccountId(String bankAccountId);
}
