package accountconsumer;

import api.AccountService;
import core.AccountTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;
    
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    
    @PostMapping(value = "/deposit")
    void deposit(@RequestBody String accountId, @RequestBody BigDecimal amount) {
        accountService.addDeposit(accountId, amount);
    }

    @PostMapping(value = "/withdrawal")
    void withdraw(@RequestBody String accountId, @RequestBody BigDecimal amount) {
        accountService.addWithdrawal(accountId, amount);
    }
    
    @GetMapping("/{accountId}")
    StatementResponse getStatements(@PathVariable String accountId) {
        List<AccountTransaction> transactions = accountService.findTransactionByAccountId(accountId);
        StatementResponseMapper mapper = new StatementResponseMapper();
        return mapper.toStatementResponse(accountId, transactions);
    }
}
