package co.devskills.springbootboilerplate.entity;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.type.UUIDCharType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@TypeDef(name = "uuid-char", typeClass = UUIDCharType.class)
public class Account {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    private UUID accountId;
    private int balance;

    public UUID getAccountId() {
        return accountId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account() {
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public Account(UUID accountId, int balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
}
