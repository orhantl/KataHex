package accountconsumer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class StatementResponse {

    private List<Statement> statements;
    private String accountId;

    public StatementResponse(List<Statement> statements, String accountId) {
        this.statements = statements;
        this.accountId = accountId;
    }

    static class Statement {

        private LocalDateTime operationTimestamp;
        private BigDecimal amount;
        private String transactionType;

        public Statement(LocalDateTime operationTimestamp, BigDecimal amount, String transactionType) {
            this.operationTimestamp = operationTimestamp;
            this.amount = amount;
            this.transactionType = transactionType;
        }
    }
}
