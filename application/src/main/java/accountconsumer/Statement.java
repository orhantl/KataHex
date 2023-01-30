package accountconsumer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Statement {

    private LocalDateTime operationTimestamp;
    private BigDecimal amount;
    private String transactionType;

    public Statement(LocalDateTime operationTimestamp, BigDecimal amount, String transactionType) {
        this.operationTimestamp = operationTimestamp;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public LocalDateTime getOperationTimestamp() {
        return operationTimestamp;
    }

    public void setOperationTimestamp(LocalDateTime operationTimestamp) {
        this.operationTimestamp = operationTimestamp;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

}
