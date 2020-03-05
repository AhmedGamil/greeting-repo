package com.tele.greeting.service;

import com.tele.greeting.model.AccountType;
import com.tele.greeting.model.BusinessType;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;

public interface GreetingService {

    String greeting(AccountType accountType, Integer id, BusinessType businessType);

}
