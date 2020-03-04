package com.tele.greeting.service;

import com.tele.greeting.factory.AccountFactory;
import com.tele.greeting.model.AccountType;
import com.tele.greeting.model.BusinessType;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String greeting(AccountType accountType, Integer id, BusinessType businessType) {
        return AccountFactory.getInstance(accountType, id, businessType).greeting();
    }
}
