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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private GreetingService greetingService;


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

        given(greetingService.greeting(Enum.valueOf(AccountType.class,account),id, null )).willReturn(expectedContent);

        mvc.perform(get("/greeting").queryParam("account",account).queryParam("id", id.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andExpect(content().string(expectedContent));

        verify(greetingService, times(1)).greeting(Enum.valueOf(AccountType.class,account), id, null );
    }



    @Test
    public void testGreeting_withPersonalAccountAndNegativeID_WillReturnBadRequest() throws Exception{
        String account  = "personal";
        Integer id= -123;

        mvc.perform(get("/greeting").queryParam("account",account).queryParam("id", id.toString()))
                .andExpect(status().isBadRequest());

        verify(greetingService, times(0)).greeting(Enum.valueOf(AccountType.class,account), id, null );
    }

    @Test
    public void testGreeting_withBusinessAccountAndTypeBig_WillReturnStatusOkAndContentText() throws Exception{
        String account  = "business";
        String type= "big";

        String expectedContent = "Welcome, business user!";

        given(greetingService.greeting(Enum.valueOf(AccountType.class,account),null, Enum.valueOf(BusinessType.class,type))).willReturn(expectedContent);

        mvc.perform(get("/greeting").queryParam("account",account).queryParam("type", type))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andExpect(content().string(expectedContent));

        verify(greetingService, times(1)).greeting(Enum.valueOf(AccountType.class,account), null, Enum.valueOf(BusinessType.class,type));
    }

    @Test
    public void testGreeting_withBusinessAccountAndTypeSmall_WillReturnStatusNotImplemented() throws Exception{
        String account  = "business";
        String type= "small";


        given(greetingService.greeting(Enum.valueOf(AccountType.class,account),null, Enum.valueOf(BusinessType.class,type))).willThrow(UnsupportedOperationException.class);

        mvc.perform(get("/greeting").queryParam("account",account).queryParam("type", type))
                .andExpect(status().isNotImplemented());

        verify(greetingService, times(1)).greeting(Enum.valueOf(AccountType.class,account), null, Enum.valueOf(BusinessType.class,type));
    }

    @Test
    public void testGreeting_withBusinessAccountAndWrongType_WillReturnBadRequest() throws Exception{
        String account  = "business";
        String type= "other";

        mvc.perform(get("/greeting").queryParam("account",account).queryParam("type", type))
                .andExpect(status().isBadRequest());
    }

}
