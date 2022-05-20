package com.example.api.Jwt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.hasLength;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JwtSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    //Test - Att det går att komma åt GET /customers med en giltig jwt-token
    @Test
    public void existentUserCanGetTokenAndAuthentication() throws Exception {
        String username = "sly";
        String password = "123123";
        String body = "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";

        MvcResult result = mockMvc.perform(post("http://localhost:8080/login/authenticate").contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String token = result.getResponse().getContentAsString();
        //response = response.replace(".", "");
        //String token = response.replace(".", "");

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/kund")
                .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }

    //Test Klart: Det inte går att komma åt GET /customers utan en giltig jwt-token, och att felkoden är 403
    @Test
    public void getCustomersWithoutJWT() throws Exception {
        mockMvc.perform(get("http://localhost:8080/kund"))
                .andDo(print())
                .andExpect(status().is(403));
    }

    //Test Klart: Att det går att komma åt GET /items utan en jwt-token och att sidan innehåller förväntat antal karaktärer
    @Test
    public void getItemsWithoutJWT() throws Exception {
        mockMvc.perform(get("http://localhost:8080/produkt"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(hasLength(334)));
    }
}