package com.tele.greeting.model;

public class PersonalAccount extends Account {

    private Integer id;

    public PersonalAccount(Integer id){
        super.setAccountType(AccountType.personal);
        this.id = id;
    }

    @Override
    public String greeting() {

        return  "Hi, userId " + id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
