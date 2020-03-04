package com.tele.greeting.controller;

import com.tele.greeting.model.AccountType;
import com.tele.greeting.model.BusinessType;
import com.tele.greeting.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/greeting")
@Validated
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping()
    public ResponseEntity<String> greeting(@RequestParam("account")  AccountType accountType,
                                           @RequestParam(name = "id", required = false) @Min(value = 1, message = "Id must be positive number") Integer id,
                                           @RequestParam(name = "type", required = false) BusinessType businessType) {

        return ResponseEntity.ok(greetingService.greeting(accountType, id, businessType));
    }
}
