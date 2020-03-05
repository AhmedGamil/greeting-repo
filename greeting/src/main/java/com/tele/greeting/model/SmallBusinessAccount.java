package com.tele.greeting.model;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.Charset;

public class SmallBusinessAccount extends BusinessAccount {

    public SmallBusinessAccount(){
        super.setBusinessType(BusinessType.small);
    }

    @Override
    public String greeting() {
        throw new UnsupportedOperationException("greeting is not yet implemented for small business");
    }
}
