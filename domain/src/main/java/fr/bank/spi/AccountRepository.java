package fr.bank.spi;

import fr.bank.core.Account;

import java.util.Optional;

public interface AccountRepository {

    Optional<Account> findById(String id);

    void save(Account account);
}
