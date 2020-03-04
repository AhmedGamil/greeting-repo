package com.tele.greeting.factory;

import com.tele.greeting.model.*;

public class AccountFactory {

    public static Account getInstance(AccountType accountType, Integer id, BusinessType businessType){
        switch (accountType) {
            case personal:
                return createPersonalAccount(id);
            case business:
                return createBusinessAccount(businessType);
            default:
                throw new IllegalArgumentException("Only Personal and Business accounts are supported");
        }
    }

    private static Account createBusinessAccount(BusinessType businessType) {
        switch (businessType){
            case big:
                return new BigBusinessAccount();
            case small:
                return new SmallBusinessAccount();
            default:
                throw new IllegalArgumentException("Only Big and Small types are supported");
        }
    }

    private static Account createPersonalAccount(Integer id) {
        return new PersonalAccount(id);
    }
}
