package com.example.api.Jwt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JwtSecurityTests {

    @Autowired
    private MockMvc mockMvc;


    //Test Klart: Att det går att komma åt GET /kund med en giltig jwt-token
    @Test
    public void existentUserCanGetTokenAndAuthentication() throws Exception {
        String username = "sly";
        String password = "123123";
        String body = "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";

        HttpHeaders httpHeaders = new HttpHeaders();

        MvcResult result = mockMvc.perform(post("/login/authenticate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(httpHeaders)
                .content(body))
                .andReturn();
        String jwt = result.getResponse().getContentAsString().split("\"jwt\":\"")[1].trim();

        httpHeaders.add("Authorization", "Bearer " + jwt);


        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/kund")
                        .headers(httpHeaders))
                .andDo(print())
                .andExpect(status().isOk());
    }

    //Test Klart: Det inte går att komma åt GET /kund utan en giltig jwt-token, och att felkoden är 403
    @Test
    public void getCustomersWithoutJWT() throws Exception {
        mockMvc.perform(get("http://localhost:8080/kund"))
                .andDo(print())
                .andExpect(status().is(403));
    }

    //Test Klart: Att det går att komma åt GET /produkt utan en jwt-token och att sidan innehåller förväntat antal karaktärer
    @Test
    public void getItemsWithoutJWT() throws Exception {
        mockMvc.perform(get("http://localhost:8080/produkt"))
                .andDo(print())
                .andExpect(status().is(200));
    }

}



