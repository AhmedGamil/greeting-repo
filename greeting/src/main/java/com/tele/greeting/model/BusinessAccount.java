package com.tele.greeting.model;

public abstract class BusinessAccount extends Account{

    private BusinessType businessType;

    public BusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }
}
