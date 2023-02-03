package accountconsumer;

import fr.bank.api.AccountService;
import fr.bank.core.AccountTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static fr.bank.core.TransactionType.DEPOSIT;
import static fr.bank.core.TransactionType.WITHDRAWAL;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@WebMvcTest(AccountController.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }

    @BeforeEach
    public void setUp() {
        accountService = mock(AccountService.class);
    }

    @Test
    void should_return_account_statements() throws Exception {
        when(accountService.findTransactionByAccountId(any())).thenReturn(getAccountTransactionList());
        this.mockMvc.perform((MockMvcRequestBuilders.get("/account/{accountId}", "the_bank_account_id"))).andExpect(MockMvcResultMatchers.status().isOk());
    }

    private List<AccountTransaction> getAccountTransactionList() {
        AccountTransaction transaction1 = new AccountTransaction("the_bank_account_id", LocalDateTime.of(2021, 2, 10, 10, 20, 35), BigDecimal.TEN, DEPOSIT);
        AccountTransaction transaction2 = new AccountTransaction("the_bank_account_id", LocalDateTime.of(2021, 2, 10, 10, 20, 35), BigDecimal.TEN, DEPOSIT);
        AccountTransaction transaction3 = new AccountTransaction("the_bank_account_id", LocalDateTime.of(2021, 2, 10, 10, 20, 35), BigDecimal.TEN, WITHDRAWAL);
        return List.of(transaction1, transaction2, transaction3);
    }
}