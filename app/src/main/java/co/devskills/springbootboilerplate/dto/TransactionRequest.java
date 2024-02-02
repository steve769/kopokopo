package co.devskills.springbootboilerplate.dto;




import java.util.UUID;

public class TransactionRequest {
    private UUID accountId;
    private int amount;

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public TransactionRequest(UUID accountId, int amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public TransactionRequest() {
    }
}
