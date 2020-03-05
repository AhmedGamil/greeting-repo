package com.tele.greeting.controller;

import com.tele.greeting.model.AccountType;
import com.tele.greeting.model.BusinessType;
import com.tele.greeting.service.GreetingService;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
public class GreetingControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;


    @Test
    public void testGreeting_withWrongAccountType_WillReturnBadRequest() throws Exception{
        String account  = "other";
        mvc.perform(get("/greeting").queryParam("account",account))
                .andExpect(status().isBadRequest());
    }


    @Test
    public void testGreeting_withPersonalAccountAndPositiveID_WillReturnStatusOkAndContentText() throws Exception{
        String account  = "personal";
        Integer id= 123;

        String expectedContent = "Hi, userId "+id;


        mvc.perform(get("/greeting").queryParam("account",account).queryParam("id", id.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andExpect(content().string(expectedContent));

    }



    @Test
    public void testGreeting_withPersonalAccountAndNegativeID_WillReturnBadRequest() throws Exception{
        String account  = "personal";
        Integer id= -123;

        mvc.perform(get("/greeting").queryParam("account",account).queryParam("id", id.toString()))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void testGreeting_withBusinessAccountAndTypeBig_WillReturnStatusOkAndContentText() throws Exception{
        String account  = "business";
        String type= "big";

        String expectedContent = "Welcome, business user!";

        mvc.perform(get("/greeting").queryParam("account",account).queryParam("type", type))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andExpect(content().string(expectedContent));

    }

    @Test
    public void testGreeting_withBusinessAccountAndTypeSmall_WillReturnStatusNotImplemented() throws Exception{
        String account  = "business";
        String type= "small";

        mvc.perform(get("/greeting").queryParam("account",account).queryParam("type", type))
                .andExpect(status().isNotImplemented());
    }

    @Test
    public void testGreeting_withBusinessAccountAndWrongType_WillReturnBadRequest() throws Exception{
        String account  = "business";
        String type= "other";

        mvc.perform(get("/greeting").queryParam("account",account).queryParam("type", type))
                .andExpect(status().isBadRequest());
    }

}
