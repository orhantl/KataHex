package fr.bank.api;

import fr.bank.core.Account;
import fr.bank.core.TransactionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import fr.bank.spi.AccountRepository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DomainAccountServiceTest {

    private AccountRepository accountRepository;
    private DomainAccountService tested;
    private final String id = String.valueOf(UUID.randomUUID());
    private Account account;

    @BeforeEach
    void setUp() {
        accountRepository = mock(AccountRepository.class);
        account = Account.createNewAccountOf(id, BigDecimal.valueOf(100));
        lenient().when(accountRepository.findById(id)).thenReturn(Optional.ofNullable(account));
        tested = new DomainAccountService(accountRepository);
    }

    @Test
    void should_save_deposit() {
        BigDecimal depositAmount = BigDecimal.valueOf(100);
        tested.addDeposit(account.getId(), depositAmount);
        verify(accountRepository).save(any(Account.class));
        account.getAccountTransactions().stream()
                .filter(accountTransaction -> accountTransaction.getTransactionType().equals(TransactionType.DEPOSIT))
                .findAny().ifPresent(accountTransaction -> assertEquals(accountTransaction.getAmount(), depositAmount));
    }

    @Test
    void should_save_withdrawal() {
        BigDecimal withdrawalAmount = BigDecimal.valueOf(90);
        tested.addWithdrawal(account.getId(), withdrawalAmount);
        verify(accountRepository).save(any(Account.class));
        account.getAccountTransactions().stream()
                .filter(accountTransaction -> accountTransaction.getTransactionType().equals(TransactionType.WITHDRAWAL))
                .findAny().ifPresent(accountTransaction -> assertEquals(accountTransaction.getAmount(), withdrawalAmount));
    }

    @Test
    void should_throw_exception_when_withdrawal_is_superior_than_current_balance() {
        String id = account.getId();
        BigDecimal excessiveAmount = BigDecimal.valueOf(1000);
        assertThrows(IllegalArgumentException.class, () -> tested.addWithdrawal(id, excessiveAmount));
    }
}