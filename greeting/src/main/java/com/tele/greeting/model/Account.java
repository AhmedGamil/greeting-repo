package com.tele.greeting.model;

public abstract class Account {

    public abstract String greeting();

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    private AccountType accountType;
}
