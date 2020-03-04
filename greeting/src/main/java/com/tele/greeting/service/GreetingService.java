package com.tele.greeting.service;

import com.tele.greeting.model.AccountType;
import com.tele.greeting.model.BusinessType;

public interface GreetingService {

    String greeting(AccountType accountType, Integer id, BusinessType businessType);

}
