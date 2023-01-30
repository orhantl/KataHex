package accountconsumer;

import java.util.List;

public class StatementResponse {

    private List<Statement> statements;
    private String accountId;

    public StatementResponse(List<Statement> statements, String accountId) {
        this.statements = statements;
        this.accountId = accountId;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
