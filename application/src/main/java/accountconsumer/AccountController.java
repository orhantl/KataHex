package accountconsumer;

import api.AccountService;
import core.AccountTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //todo add ExceptionHandler
    @PostMapping(value = "/{accountId}/deposit")
    ResponseEntity<String> deposit(@PathVariable String accountId, @RequestBody BigDecimal amount) {
        accountService.addDeposit(accountId, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/{accountId}/withdrawal")
    ResponseEntity<String> withdraw(@PathVariable String accountId, @RequestBody BigDecimal amount) {
        accountService.addWithdrawal(accountId, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/{accountId}")
    StatementResponse getStatements(@PathVariable String accountId) {
        List<AccountTransaction> transactions = accountService.findTransactionByAccountId(accountId);
        StatementResponseMapper mapper = new StatementResponseMapper();
        return mapper.toStatementResponse(accountId, transactions);
    }
}
