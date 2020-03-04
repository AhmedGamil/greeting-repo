package com.tele.greeting.model;

public class BigBusinessAccount extends BusinessAccount {
    public BigBusinessAccount(){
        super.setBusinessType(BusinessType.big);
    }

    @Override
    public String greeting() {
        return "Welcome, business user!";
    }
}
