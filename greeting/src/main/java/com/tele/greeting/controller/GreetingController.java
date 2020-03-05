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

    @GetMapping(params = {"account=personal", "id"})
    public ResponseEntity<String> greeting(@RequestParam("id") @NotNull @Min(value = 1, message = "id must be positive number") Integer id) {
        return ResponseEntity.ok(greetingService.greeting(AccountType.personal, id, null));
    }

    @GetMapping(params = {"account=business", "type"})
    public ResponseEntity<String> greeting(@RequestParam("type") @NotNull BusinessType businessType) {
        return ResponseEntity.ok(greetingService.greeting(AccountType.business, null, businessType));
    }
}
