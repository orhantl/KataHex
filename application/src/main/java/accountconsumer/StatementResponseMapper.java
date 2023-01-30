package accountconsumer;

import core.AccountTransaction;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StatementResponseMapper {

    public StatementResponse toStatementResponse(String accountId, List<AccountTransaction> accountTransactions) {
        List<Statement> statements =
                accountTransactions.stream().map(this::toStatement).collect(toList());
        return new StatementResponse(statements, accountId);
    }

    private Statement toStatement(AccountTransaction accountTransaction) {
        return new Statement(accountTransaction.getOperationTimestamp(),
                accountTransaction.getAmount(),
                accountTransaction.getTransactionType().name());
    }
}
