package api;

import core.Account;
import core.AccountTransaction;
import spi.AccountRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class DomainAccountService implements AccountService {

    private final AccountRepository accountRepository;

    public DomainAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account findById(String bankAccountId) {
        Optional<Account> account = accountRepository.findById(bankAccountId);
        if (account.isEmpty()) {
            throw new IllegalArgumentException("The given bank account id does not exist");
        }
        return account.get();
    }

    @Override
    public void addDeposit(String bankAccountId, BigDecimal amount) {
        Account account = findById(bankAccountId);
        account.deposit(amount);
        accountRepository.save(account);
    }

    @Override
    public void addWithdrawal(String bankAccountId, BigDecimal amount) {
        Account account = findById(bankAccountId);
        account.withdraw(amount);
        accountRepository.save(account);
    }

    @Override
    public List<AccountTransaction> findTransactionByAccountId(String bankAccountId) {
        Account account = findById(bankAccountId);
        return account.getAccountTransactions();
    }
}